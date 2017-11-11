package com.sessions;

import net.lightbody.bmp.BrowserMobProxy;


public class SessionProxy
{
    private final BrowserMobProxy nativeProxy;
    private final OpenedRequestsContainer openedRequestsContainer;

    public SessionProxy(BrowserMobProxy nativeProxy, OpenedRequestsContainer openedRequestsContainer)
    {
        this.nativeProxy = nativeProxy;
        this.openedRequestsContainer = openedRequestsContainer;
    }

    public BrowserMobProxy getNativeProxy()
    {
        return nativeProxy;
    }

    public OpenedRequestsContainer getOpenedRequestsContainer()
    {
        return openedRequestsContainer;
    }
}