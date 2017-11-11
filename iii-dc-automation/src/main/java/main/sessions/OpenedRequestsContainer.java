package main.sessions;

import io.netty.handler.codec.http.HttpRequest;
import net.lightbody.bmp.util.HttpMessageContents;
import main.utils.CsvPerformanceMetricLogger;
import main.utils.LogStatuses;
import main.utils.Logger;
import main.utils.StaticWait;

import java.time.Duration;
import java.time.Instant;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OpenedRequestsContainer
{
    private volatile ConcurrentHashMap<HttpRequest, RequestData> requests;

    public OpenedRequestsContainer ()
    {
        requests = new ConcurrentHashMap<>();
    }

    public void put(HttpRequest key, HttpMessageContents requestContent, Instant requestSentTime)
    {
        requests.put(key, new RequestData(requestSentTime, requestContent));
    }

    public void remove(HttpRequest key)
    {
        requests.remove(key);
    }

    public void clear()
    {
        requests.clear();
    }

    public boolean waitForAllRequestProcessing(int timeoutSeconds)
    {
        Instant startTime = Instant.now();
        while (Duration.between(startTime, Instant.now()).toMillis() < timeoutSeconds * 1000)
        {
            if (requests.size() == 0) {
                return true;
            }

            StaticWait.forMilliseconds(200);
        }

        Logger.write(LogStatuses.DEBUG, String.format("Synchronization is NOT successful. Duration: %1s ms.  Remained requests count: %2s", Duration.between(startTime, Instant.now()).toMillis(), requests.size()));
        Iterator<Map.Entry<HttpRequest, RequestData>> iterator = requests.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<HttpRequest, RequestData> request = iterator.next();
            HttpMessageContents content = request.getValue().getRequestContent();
            String text = content.getTextContents();
            HttpRequest nativeRequest = request.getKey();

//            Logger.write(LogStatuses.DEBUG, String.format("Request is unanswered: \t%1s\t%2s\n\t\t%3s",
//                    nativeRequest.getMethod(), nativeRequest.getUri(), text));

            CsvPerformanceMetricLogger.httpResponseTimeMetrics.logAction(
                    -1,
                    request.getKey().getMethod().name(),
                    request.getKey().getUri(),
                    request.getValue().getRequestContent().getTextContents(), "Unanswered for " + timeoutSeconds + " seconds");
        }

        return false;
    }

    public RequestData get(HttpRequest key)
    {
        return requests.get(key);
    }

    public boolean containsKey(HttpRequest key)
    {
        return requests.containsKey(key);
    }

    public void killFreezedRequests()
    {
        try {
            Iterator<Map.Entry<HttpRequest, RequestData>> iterator = requests.entrySet().iterator();
            while (iterator.hasNext())
            {
                Map.Entry<HttpRequest, RequestData> request = iterator.next();
                if (Duration.between(request.getValue().getRequestSentTime(), Instant.now()).toMillis() > 30000) {
                    HttpMessageContents content = request.getValue().getRequestContent();

                    String contentType = content.getContentType();
                    byte[] buf = content.getBinaryContents();
                    String text = content.getTextContents();

                    HttpRequest nativeRequest = request.getKey();
                    this.remove(nativeRequest);

//                    Logger.write(LogStatuses.DEBUG, String.format("Request is unanswered for more than 30 seconds: \t%1s\t%2s\n\t\t%3s",
//                            nativeRequest.getMethod(), nativeRequest.getUri(), text));
                }
            }
        } catch (ConcurrentModificationException ex)
        {
            Logger.write(LogStatuses.DEBUG, "Exception on requests filter", ex);
        }
    }
}

class RequestData
{
    private Instant requestSentTime;
    private HttpMessageContents requestContent;

    public RequestData(Instant requestSentTime, HttpMessageContents requestContent) {
        this.requestSentTime = requestSentTime;
        this.requestContent = requestContent;
    }

    public Instant getRequestSentTime()
    {
        return requestSentTime;
    }

    public HttpMessageContents getRequestContent()
    {
        return requestContent;
    }
}