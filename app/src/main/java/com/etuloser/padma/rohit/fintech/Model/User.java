package com.etuloser.padma.rohit.fintech.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Rohit on 11/4/2017.
 */

public class User implements Serializable{
    private String firstname;
    private String lastname;
    private String gender;
    private String imgurl;
    private String email;
    private String uid;
    private String key;
    private String rating;
    private String type;
    private String creditlevel;

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", email='" + email + '\'' +
                ", uid='" + uid + '\'' +
                ", key='" + key + '\'' +
                ", rating='" + rating + '\'' +
                ", type='" + type + '\'' +
                ", creditlevel='" + creditlevel + '\'' +
                '}';
    }

    public String getCreditlevel() {
        return creditlevel;
    }

    public void setCreditlevel(String creditlevel) {
        this.creditlevel = creditlevel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

}
