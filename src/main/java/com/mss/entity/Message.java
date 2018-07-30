package com.mss.entity;

import com.mss.annotations.RequiredString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@Entity
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;

    @ManyToOne
    @JoinColumn(name = "threadId")
    @XmlTransient
    Thread thread;

    @ManyToOne
    @JoinColumn(name = "userId")
    @XmlTransient
    private User user;

    @RequiredString
    private String message;

    @NotNull
    private long postingTime;

    public long getMessageId() {
        return messageId;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getPostingTime() {
        return postingTime;
    }

    public void setPostingTime(long postingTime) {
        this.postingTime = postingTime;
    }
}
