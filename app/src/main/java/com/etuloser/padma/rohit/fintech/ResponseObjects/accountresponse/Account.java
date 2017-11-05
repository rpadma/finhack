package com.etuloser.padma.rohit.fintech.ResponseObjects.accountresponse;

/**
 * Created by Rohit on 11/5/2017.
 */
public class Account
{
    private Refreshinfo refreshinfo;

    private String CONTAINER;

    private String isManual;

    private String isAsset;

    private String lastUpdated;

    private CurrentBalance currentBalance;

    private AvailableBalance availableBalance;

    private String id;

    private Balance balance;

    private String accountName;

    private String accountNumber;

    private String aggregationSource;

    private String providerName;

    private String accountStatus;

    private String accountType;

    private String providerId;

    private String includeInNetWorth;

    private HolderProfile[] holderProfile;

    private String providerAccountId;

    private String createdDate;

    public Refreshinfo getRefreshinfo ()
    {
        return refreshinfo;
    }

    public void setRefreshinfo (Refreshinfo refreshinfo)
    {
        this.refreshinfo = refreshinfo;
    }

    public String getCONTAINER ()
    {
        return CONTAINER;
    }

    public void setCONTAINER (String CONTAINER)
    {
        this.CONTAINER = CONTAINER;
    }

    public String getIsManual ()
    {
        return isManual;
    }

    public void setIsManual (String isManual)
    {
        this.isManual = isManual;
    }

    public String getIsAsset ()
    {
        return isAsset;
    }

    public void setIsAsset (String isAsset)
    {
        this.isAsset = isAsset;
    }

    public String getLastUpdated ()
    {
        return lastUpdated;
    }

    public void setLastUpdated (String lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public CurrentBalance getCurrentBalance ()
    {
        return currentBalance;
    }

    public void setCurrentBalance (CurrentBalance currentBalance)
    {
        this.currentBalance = currentBalance;
    }

    public AvailableBalance getAvailableBalance ()
    {
        return availableBalance;
    }

    public void setAvailableBalance (AvailableBalance availableBalance)
    {
        this.availableBalance = availableBalance;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Balance getBalance ()
    {
        return balance;
    }

    public void setBalance (Balance balance)
    {
        this.balance = balance;
    }

    public String getAccountName ()
    {
        return accountName;
    }

    public void setAccountName (String accountName)
    {
        this.accountName = accountName;
    }

    public String getAccountNumber ()
    {
        return accountNumber;
    }

    public void setAccountNumber (String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public String getAggregationSource ()
    {
        return aggregationSource;
    }

    public void setAggregationSource (String aggregationSource)
    {
        this.aggregationSource = aggregationSource;
    }

    public String getProviderName ()
    {
        return providerName;
    }

    public void setProviderName (String providerName)
    {
        this.providerName = providerName;
    }

    public String getAccountStatus ()
    {
        return accountStatus;
    }

    public void setAccountStatus (String accountStatus)
    {
        this.accountStatus = accountStatus;
    }

    public String getAccountType ()
    {
        return accountType;
    }

    public void setAccountType (String accountType)
    {
        this.accountType = accountType;
    }

    public String getProviderId ()
    {
        return providerId;
    }

    public void setProviderId (String providerId)
    {
        this.providerId = providerId;
    }

    public String getIncludeInNetWorth ()
    {
        return includeInNetWorth;
    }

    public void setIncludeInNetWorth (String includeInNetWorth)
    {
        this.includeInNetWorth = includeInNetWorth;
    }

    public HolderProfile[] getHolderProfile ()
    {
        return holderProfile;
    }

    public void setHolderProfile (HolderProfile[] holderProfile)
    {
        this.holderProfile = holderProfile;
    }

    public String getProviderAccountId ()
    {
        return providerAccountId;
    }

    public void setProviderAccountId (String providerAccountId)
    {
        this.providerAccountId = providerAccountId;
    }

    public String getCreatedDate ()
    {
        return createdDate;
    }

    public void setCreatedDate (String createdDate)
    {
        this.createdDate = createdDate;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [refreshinfo = "+refreshinfo+", CONTAINER = "+CONTAINER+", isManual = "+isManual+", isAsset = "+isAsset+", lastUpdated = "+lastUpdated+", currentBalance = "+currentBalance+", availableBalance = "+availableBalance+", id = "+id+", balance = "+balance+", accountName = "+accountName+", accountNumber = "+accountNumber+", aggregationSource = "+aggregationSource+", providerName = "+providerName+", accountStatus = "+accountStatus+", accountType = "+accountType+", providerId = "+providerId+", includeInNetWorth = "+includeInNetWorth+", holderProfile = "+holderProfile+", providerAccountId = "+providerAccountId+", createdDate = "+createdDate+"]";
    }
}