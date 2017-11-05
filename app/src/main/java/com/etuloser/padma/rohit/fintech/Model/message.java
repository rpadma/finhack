package com.etuloser.padma.rohit.fintech.Model;

/**
 * Created by Rohit on 11/4/2017.
 */

public class message {

    private String msg;
    private String userid;
    private String msgkey;
    private String name;
    private String when;
    private String type;
    private String status;
private String tmsg;
private String ckey;
private String Touserkey;

    public String getTouserkey() {
        return Touserkey;
    }

    public void setTouserkey(String touserkey) {
        Touserkey = touserkey;
    }

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }

    public String getTmsg() {
        return tmsg;
    }

    public void setTmsg(String tmsg) {
        this.tmsg = tmsg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMsgkey() {
        return msgkey;
    }

    public void setMsgkey(String msgkey) {
        this.msgkey = msgkey;
    }
}
