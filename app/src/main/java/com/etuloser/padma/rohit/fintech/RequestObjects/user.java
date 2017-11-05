package com.etuloser.padma.rohit.fintech.RequestObjects;

/**
 * Created by Rohit on 11/5/2017.
 */

public class user {

    String loginName;
    String password;
    String locale;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
