package com.emni.astro.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;
    private String email;
    private String birthDate;
    private String userHoroscope;

    public User(String email, String birthDate, String userHoroscope) {
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
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public String getUserHoroscope() {
        return userHoroscope;
    }
    public void setUserHoroscope(String userHoroscope) {
        this.userHoroscope = userHoroscope;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
