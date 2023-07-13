package com.emni.astro.domain;

import com.emni.astro.dto.GptModelsResponseDto;


public interface ChatGptClient {
    GptModelsResponseDto getModels();

    String generateNoteText(String request);
}
