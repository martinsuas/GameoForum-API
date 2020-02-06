package com.mss.entity;

import com.mss.annotations.RequiredString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Serializable {

    @Transient
    public static final String USERNAME_REGEX = "[a-zA-Z][a-zA-z0-9_]*";

    @Transient
    public static final String CAMELCASE_REGEX = "[A-Z][a-z]*";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(unique = true)
    @Size(min = 5, max = 30, message = "Must be between 5 and 30 characters")
    @Pattern(regexp = USERNAME_REGEX,
             message = "Must start with alphanumerical character and may include numbers or '_'")
    private String username;

    @RequiredString
    private String password;

    @Pattern(regexp = CAMELCASE_REGEX)
    private String firstName;

    @Pattern(regexp = CAMELCASE_REGEX)
    private String lastName;

    @Column(unique=true)
    @Email
    private String email;

    @NotNull
    private long registrationTime;

    @OneToMany(mappedBy = "user")
    @XmlTransient
    @Transient
    private List<Thread> threads = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @XmlTransient
    @Transient
    private List<Message> messages = new ArrayList<>();

    private LocalDate dob;

    private String gender;

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(long registrationTime) {
        this.registrationTime = registrationTime;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public void setThreads(List<Thread> threads) {
        this.threads = threads;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
