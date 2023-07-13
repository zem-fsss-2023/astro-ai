package com.emni.astro.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;



@Entity
@Table(name = "HoroscopeReadings", uniqueConstraints = { @UniqueConstraint(columnNames = { "horoscopeType", "readingDate", "readingType" }) })
public class HoroscopeReading {
    @Id
    @Column(name = "readingId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer readingId;
    
    @Column(name = "horoscopeType")
    private String horoscopeType;
    @Column(name = "readingDate")
    private String readingDate;
    @Lob
    private String reading;
    @Column(name = "readingType")
    private String readingType;
    

    public HoroscopeReading() {}
    
    public HoroscopeReading(String horoscopeType, String readingDate, String reading, String readingType) {
        this.horoscopeType = horoscopeType;
        this.readingDate = readingDate;
        this.reading = reading;
        this.readingType = readingType;

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
    public String getReading() {
        return reading;
    }
    public void setReading(String loveReading) {
        this.reading = loveReading;
    }
    public String getReadingType() {
        return readingType;
    }
    public void setReadingType(String readingType) {
        this.readingType = readingType;
    }
}
