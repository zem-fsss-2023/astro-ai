package com.emni.astro.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;



@Entity
@Table(name = "HoroscopeReadings", uniqueConstraints = { @UniqueConstraint(columnNames = { "horoscopeType", "readingDate" }) })
public class HoroscopeReading {
    @Id
    @Column(name = "readingId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer readingId;
    
    @Column(name = "horoscopeType")
    private String horoscopeType;
    @Column(name = "readingDate")
    private String readingDate;
    private String loveReading;
    private String personalReading;
    private String careerReading;
    private String healthReading;
    private String tip;

    public HoroscopeReading() {}
    
    public HoroscopeReading(String horoscopeType, String readingDate, String loveReading, String personalReading,
            String careerReading, String healthReading, String tip) {
        this.horoscopeType = horoscopeType;
        this.readingDate = readingDate;
        this.loveReading = loveReading;
        this.personalReading = personalReading;
        this.careerReading = careerReading;
        this.healthReading = healthReading;
        this.tip = tip;
    }
    public Integer getReadingId() {
        return readingId;
    }
    public void setReadingId(Integer readingId) {
        this.readingId = readingId;
    }
    public String getHoroscopeType() {
        return horoscopeType;
    }
    public void setHoroscopeType(String horoscopeType) {
        this.horoscopeType = horoscopeType;
    }
    public String getReadingDate() {
        return readingDate;
    }
    public void setReadingDate(String readingDate) {
        this.readingDate = readingDate;
    }
    public String getLoveReading() {
        return loveReading;
    }
    public void setLoveReading(String loveReading) {
        this.loveReading = loveReading;
    }
    public String getPersonalReading() {
        return personalReading;
    }
    public void setPersonalReading(String personalReading) {
        this.personalReading = personalReading;
    }
    public String getCareerReading() {
        return careerReading;
    }
    public void setCareerReading(String careerReading) {
        this.careerReading = careerReading;
    }
    public String getHealthReading() {
        return healthReading;
    }
    public void setHealthReading(String healthReading) {
        this.healthReading = healthReading;
    }
    public String getTip() {
        return tip;
    }
    public void setTip(String tip) {
        this.tip = tip;
    }

    
}
