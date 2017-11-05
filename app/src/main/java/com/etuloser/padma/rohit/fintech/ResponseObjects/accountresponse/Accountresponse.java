package com.etuloser.padma.rohit.fintech.ResponseObjects.accountresponse;

/**
 * Created by Rohit on 11/5/2017.
 */

public class Accountresponse
{
    private Account[] account;

    public Account[] getAccount ()
    {
        return account;
    }

    public void setAccount (Account[] account)
    {
        this.account = account;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [account = "+account+"]";
    }
}