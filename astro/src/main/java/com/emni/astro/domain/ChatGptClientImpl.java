package com.emni.astro.domain;

import com.emni.astro.dto.GptAutocompletionRequestDto;
import com.emni.astro.dto.GptAutocompletionResponseDto;
import com.emni.astro.dto.GptModelsResponseDto;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChatGptClientImpl implements ChatGptClient {

    private final String apiKey;
    private final Counter noteGeneratorCounter;
    private final Timer noteGenerationTimer;
    private final ChatGptApi chatGptApi;

    @Autowired
    public ChatGptClientImpl(@Value("${gpt.api.url}") final String url,
                             @Value("${gpt.api.key}") final String apiKey,
                             final MeterRegistry meterRegistry) {
        this.noteGeneratorCounter = meterRegistry.counter("noteGeneratorCounter");
        this.noteGenerationTimer = meterRegistry.timer("noteGeneratorTimer");
        this.apiKey = apiKey;
        this.chatGptApi = Feign.builder()
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .target(ChatGptApi.class, url);
    }

    @Override
    public GptModelsResponseDto getModels() {
        return chatGptApi.getModels(apiKey);
    }

    @Override
    public String generateNoteText(String request) {
        GptAutocompletionRequestDto requestBody = new GptAutocompletionRequestDto(
                "gpt-3.5-turbo",
                request
        );
        noteGeneratorCounter.increment();
        GptAutocompletionResponseDto response = noteGenerationTimer.record(() -> chatGptApi.generateTask(requestBody, apiKey));

        return response.getAutocompletedMesage();
    }
}
