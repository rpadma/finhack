package com.etuloser.padma.rohit.fintech.ResponseObjects.accountresponse;

/**
 * Created by Rohit on 11/5/2017.
 */

public class Name
{
    private String displayed;

    public String getDisplayed ()
    {
        return displayed;
    }

    public void setDisplayed (String displayed)
    {
        this.displayed = displayed;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [displayed = "+displayed+"]";
    }
}
