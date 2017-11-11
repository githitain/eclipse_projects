package com.sessions;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.filters.RequestFilter;
import net.lightbody.bmp.filters.RequestFilterAdapter;
import net.lightbody.bmp.filters.ResponseFilter;
import net.lightbody.bmp.filters.ResponseFilterAdapter;
import net.lightbody.bmp.proxy.CaptureType;
import org.apache.commons.lang3.StringUtils;

import com.setting.TestSettings;
import com.utilites.CsvPerformanceMetricLogger;
import com.utilites.LogStatuses;
import com.utilites.Logger;
import com.utilites.StaticWait;

import java.net.InetSocketAddress;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class ProxyFactory {
    public static synchronized BrowserMobProxy getBrowserMobProxy(OpenedRequestsContainer openedRequests) 
    {

        BrowserMobProxy bmpProxy = startProxy();

        bmpProxy.addRequestFilter((request, contents, messageInfo) -> {
            //DO NOT REMOVE THIS!
            //I know that this code (the following three lines) does nothing, but it is really needed. Just trust me.
            String contentType =  contents.getContentType();
            byte[] buf = contents.getBinaryContents();
            String requestText  = contents.getTextContents();

            //Exclude 'CONNECT' requests and ping requests from the synchronization logic
            if (!request.getMethod().name().equals("CONNECT") &&
                    (StringUtils.isEmpty(requestText) || !requestText.contains("Action=ping"))) {
                openedRequests.put(messageInfo.getOriginalRequest(), contents, Instant.now());
            }

            return null;
        });

        bmpProxy.addResponseFilter((response, contents, messageInfo) -> {
            if (openedRequests.containsKey(messageInfo.getOriginalRequest())) {
                Duration requestDuration = Duration.between(openedRequests.get(messageInfo.getOriginalRequest()).getRequestSentTime(), Instant.now());

                CsvPerformanceMetricLogger.httpResponseTimeMetrics.logAction(
                        requestDuration.toMillis(),
                        messageInfo.getOriginalRequest().getMethod().name(),
                        messageInfo.getOriginalRequest().getUri(),
                        openedRequests.get(messageInfo.getOriginalRequest()).getRequestContent().getTextContents(), "");


                openedRequests.remove(messageInfo.getOriginalRequest());
            }
        });

        bmpProxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

        return bmpProxy;
    }

    private static BrowserMobProxy startProxy(){
        try {
            //Initializing BrowserMobob proxy
            BrowserMobProxy bmpProxy = new BrowserMobProxyServer(){
                @Override
                public void addRequestFilter(RequestFilter filter) {
                    addFirstHttpFilterFactory(new RequestFilterAdapter.FilterSource(filter, Integer.MAX_VALUE));
                }

                @Override
                public void addResponseFilter(ResponseFilter filter) {
                    addLastHttpFilterFactory(new ResponseFilterAdapter.FilterSource(filter, Integer.MAX_VALUE));
                }
            };;

            if (TestSettings.Current.getUseChainedProxy()) {
                bmpProxy.setChainedProxy(new InetSocketAddress(
                        TestSettings.Current.getChainedProxyHost(),
                        TestSettings.Current.getChainedProxyPort()));
            }
            int timeout = 180;
            TimeUnit timeUnit = TimeUnit.SECONDS;

            bmpProxy.setTrustAllServers(true);

            bmpProxy.setConnectTimeout(timeout, timeUnit);
            bmpProxy.setRequestTimeout(timeout, timeUnit);
            bmpProxy.setIdleConnectionTimeout(timeout, timeUnit);

            bmpProxy.start(0);
            return bmpProxy;

        } catch (Exception exception) {
            Logger.write(LogStatuses.ERR, "Proxy has not been started from the first attempt. Trying one more time.", exception);
            StaticWait.forSeconds(5);

            //Second attempt
            BrowserMobProxy bmpProxy = new BrowserMobProxyServer();

            if (TestSettings.Current.getUseChainedProxy()) {
                bmpProxy.setChainedProxy(new InetSocketAddress(
                        TestSettings.Current.getChainedProxyHost(),
                        TestSettings.Current.getChainedProxyPort()));
            }

            bmpProxy.setTrustAllServers(true);
            bmpProxy.start(0);
            return bmpProxy;
        }
    }
}
