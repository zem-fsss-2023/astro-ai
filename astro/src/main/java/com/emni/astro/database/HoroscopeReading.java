package com.emni.astro.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HoroscopeReadings")
public class HoroscopeReading {
    @Id
    @Column(name = "id")
    private Integer readingId;
    
    private String horoscopeType;
    private String readingDate;
    private String loveReading;
    private String personalReading;
    private String careerReading;
    private String healthReading;
    private String tip;
}
