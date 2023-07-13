package com.emni.astro.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoroscopeRepository extends JpaRepository<HoroscopeReading, Integer> {
    // find the entry in database with the given readingDate, horoscopeType, and readingType
    public HoroscopeReading findByReadingDateAndHoroscopeTypeAndReadingType( String readingDate, String horoscopeType, String readingType);

    // return true if the entry exists in the database
    public boolean existsByReadingDateAndHoroscopeTypeAndReadingType( String readingDate, String horoscopeType, String readingType);
}
