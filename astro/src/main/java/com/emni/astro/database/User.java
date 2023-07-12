package com.emni.astro.database;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// import jakarta.persistence.Enumerated;

public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;
    private String email;
    private Date birthDate;
    
    // @Enumerated()
    private Horoscope userHoroscope;

    public User(String email, Date birthDate, Horoscope userHoroscope) {
        this.email = email;
        this.birthDate = birthDate;
        this.userHoroscope = userHoroscope;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Horoscope getUserHoroscope() {
        return userHoroscope;
    }
    public void setUserHoroscope(Horoscope userHoroscope) {
        this.userHoroscope = userHoroscope;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
