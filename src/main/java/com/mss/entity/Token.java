package com.mss.entity;

import com.mss.annotations.RequiredString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Token implements Serializable {
    @NotNull
    private User user;

    @RequiredString
    private String key;

    @NotNull
    private long expirationTime;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }
}
