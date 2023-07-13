package com.emni.astro.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emni.astro.database.HoroscopeReading;
import com.emni.astro.database.HoroscopeRepository;
import com.emni.astro.database.User;
import com.emni.astro.database.UserRepository;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api")
public class DBController {
    
    private HoroscopeRepository horoscopeRepository;
    private UserRepository userRepository;
    
    public DBController(HoroscopeRepository horoscopeRepository, UserRepository userRepository){
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

    @GetMapping(value="/getReadingsFor")
    public HoroscopeReading getReading(@RequestParam("readingDate") String readingDate, @RequestParam("horoscopeType") String horoscopeType) {
        return horoscopeRepository.findByReadingDateAndHoroscopeType(readingDate, horoscopeType);
    }

    @GetMapping(value="/getUserFor")
    public User getUser(@RequestParam("email") String email) {
        return userRepository.findByEmail(email);
    }
    
    
}
