package com.emni.astro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class DBController {

    @GetMapping("/getReadings")
    public String getHoroscopeReading(@RequestParam(value = "ARIES", defaultValue = "Horse") String horoscope,@RequestParam(value = "date", defaultValue = "2023-07-12") String readingDate) {
        return "Testing" + horoscope + readingDate;
    }
}
