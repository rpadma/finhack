package com.etuloser.padma.rohit.fintech.ResponseObjects.accountresponse;

/**
 * Created by Rohit on 11/5/2017.
 */

public class HolderProfile
{
    private Name name;

    public Name getName ()
    {
        return name;
    }

    public void setName (Name name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+"]";
    }
}
