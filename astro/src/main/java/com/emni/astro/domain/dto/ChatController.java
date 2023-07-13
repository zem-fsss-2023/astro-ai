package com.emni.astro.domain.dto;

import com.emni.astro.domain.ChatGptClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ChatController {


    @Autowired
    private ChatGptClientImpl client;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt) {

        return client.generateNoteText(prompt);
    }
    @GetMapping("/test")
    public String test() {
        return "hello";
    }
}