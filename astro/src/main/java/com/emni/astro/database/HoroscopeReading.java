package com.emni.astro.database;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

enum Horoscope {
    ARIES,
    TAURUS,
    GEMINI,
    CANCER,
    LEO,
    VIRGO,
    LIBRA,
    SCORPIO,
    SAGITTARIUS,
    CAPRICORN,
    AQUARIUS,
    PISCES
}


@Entity
@Table(name = "HoroscopeReadings")
public class HoroscopeReading {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer readingId;
    
    private Horoscope horoscopeType;
    private Date readingDate;
    private String loveReading;
    private String personalReading;
    private String careerReading;
    private String healthReading;
    private String tip;
    

    public HoroscopeReading(Horoscope horoscopeType, Date readingDate, String loveReading, String personalReading,
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
    public Horoscope getHoroscopeType() {
        return horoscopeType;
    }
    public void setHoroscopeType(Horoscope horoscopeType) {
        this.horoscopeType = horoscopeType;
    }
    public Date getReadingDate() {
        return readingDate;
    }
    public void setReadingDate(Date readingDate) {
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
