package com.etuloser.padma.rohit.fintech.ResponseObjects.accountresponse;

/**
 * Created by Rohit on 11/5/2017.
 */

public class TotalCashLimit
{
    private String amount;

    private String currency;

    public String getAmount ()
    {
        return amount;
    }

    public void setAmount (String amount)
    {
        this.amount = amount;
    }

    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [amount = "+amount+", currency = "+currency+"]";
    }
}