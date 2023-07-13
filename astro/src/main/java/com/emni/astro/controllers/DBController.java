package com.emni.astro.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emni.astro.database.HoroscopeReading;
import com.emni.astro.database.HoroscopeRepository;
import com.emni.astro.database.User;
import com.emni.astro.database.UserRepository;
import com.emni.astro.domain.ChatGptClientImpl;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api")
public class DBController {

    private HoroscopeRepository horoscopeRepository;
    private UserRepository userRepository;
    @Autowired
    private ChatGptClientImpl client;

    public DBController(HoroscopeRepository horoscopeRepository, UserRepository userRepository) {
        this.horoscopeRepository = horoscopeRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/postReading")
    public String newReading(@RequestBody HoroscopeReading horoscopeReading) {
        horoscopeRepository.save(horoscopeReading);
        return "Saved";
    }

    @PostMapping("/postUser")
    public String newUser(@RequestBody User user) {
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping("/getReadings")
    public List<HoroscopeReading> getReadings() {
        return horoscopeRepository.findAll();
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/getReadingsFor")
    public HoroscopeReading getReading(@RequestParam("readingType") String readingType, @RequestParam("horoscopeType") String horoscopeType) {
        // check if if readingType is valid
        // check if horoscopeType is valid
        String[] validReadingTypes = {"love", "career", "health", "money", "general"};
        String[] validHoroscopeTypes = {"aries", "taurus", "gemini", "cancer", "leo", "virgo", "libra", "scorpio",
                "sagittarius", "capricorn", "aquarius", "pisces"};
        boolean readingTypeValid = false;
        boolean horoscopeTypeValid = false;
        for (String validReadingType : validReadingTypes) {
            if (validReadingType.equals(readingType)) {
                readingTypeValid = true;
                break;
            }
        }
        for (String validHoroscopeType : validHoroscopeTypes) {
            if (validHoroscopeType.equals(horoscopeType)) {
                horoscopeTypeValid = true;
                break;
            }
        }
        if (!readingTypeValid || !horoscopeTypeValid) {
            return null;
        }
        String readingDate = Date.valueOf(java.time.LocalDate.now()).toString();
        // check if reading exists in database
        if (horoscopeRepository.existsByReadingDateAndHoroscopeTypeAndReadingType(readingDate, horoscopeType, readingType)) {
            return horoscopeRepository.findByReadingDateAndHoroscopeTypeAndReadingType(readingDate, horoscopeType, readingType);
        }

        String reading = client.generateNoteText("In two sentences write a " + readingType + " horoscope prediction for " + horoscopeType + " for " + readingDate);
        HoroscopeReading readingObject = new HoroscopeReading(horoscopeType, readingDate, reading, readingType);
        horoscopeRepository.save(readingObject);
        return readingObject;
    }

    @GetMapping(value = "/getUserFor")
    public User getUser(@RequestParam("email") String email) {
        return userRepository.findByEmail(email);
    }

}
