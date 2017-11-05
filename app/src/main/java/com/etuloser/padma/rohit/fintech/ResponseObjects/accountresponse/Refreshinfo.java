package com.etuloser.padma.rohit.fintech.ResponseObjects.accountresponse;

/**
 * Created by Rohit on 11/5/2017.
 */

public class Refreshinfo
{
    private String statusCode;

    private String lastRefreshAttempt;

    private String lastRefreshed;

    private String nextRefreshScheduled;

    private String statusMessage;

    public String getStatusCode ()
    {
        return statusCode;
    }

    public void setStatusCode (String statusCode)
    {
        this.statusCode = statusCode;
    }

    public String getLastRefreshAttempt ()
    {
        return lastRefreshAttempt;
    }

    public void setLastRefreshAttempt (String lastRefreshAttempt)
    {
        this.lastRefreshAttempt = lastRefreshAttempt;
    }

    public String getLastRefreshed ()
    {
        return lastRefreshed;
    }

    public void setLastRefreshed (String lastRefreshed)
    {
        this.lastRefreshed = lastRefreshed;
    }

    public String getNextRefreshScheduled ()
    {
        return nextRefreshScheduled;
    }

    public void setNextRefreshScheduled (String nextRefreshScheduled)
    {
        this.nextRefreshScheduled = nextRefreshScheduled;
    }

    public String getStatusMessage ()
    {
        return statusMessage;
    }

    public void setStatusMessage (String statusMessage)
    {
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [statusCode = "+statusCode+", lastRefreshAttempt = "+lastRefreshAttempt+", lastRefreshed = "+lastRefreshed+", nextRefreshScheduled = "+nextRefreshScheduled+", statusMessage = "+statusMessage+"]";
    }
}


