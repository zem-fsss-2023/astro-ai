package com.emni.astro.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoroscopeRepository extends JpaRepository<HoroscopeReading, Integer> {
    public HoroscopeReading findByReadingDateAndHoroscopeType(String readingDate, String horoscopeType);
}
