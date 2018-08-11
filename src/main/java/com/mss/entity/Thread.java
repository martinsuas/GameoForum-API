package com.mss.entity;

import com.mss.annotations.RequiredString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Thread implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int threadId;

    @ManyToOne
    @JoinColumn(name = "forumId")
    @XmlTransient
    private Forum forum;

    @ManyToOne
    @JoinColumn(name = "userId")
    @XmlTransient
    private User user;

    @RequiredString
    private String title;

    @NotNull
    private long creationTime;

    @OneToMany(mappedBy = "thread")
    @XmlTransient
    private List<Message> messages = new ArrayList<>();

    public int getThreadId() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAuthorId() {
        return this.user.getUserId();
    }

    public String getAuthor() {
        return this.user.getUsername();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
