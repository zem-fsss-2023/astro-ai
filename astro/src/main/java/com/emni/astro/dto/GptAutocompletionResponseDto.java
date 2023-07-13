package com.emni.astro.dto;

import java.util.List;

public record GptAutocompletionResponseDto(String id, String object, List<GptChoicesDto> choices) {
    public String getAutocompletedMesage() {
        return this.choices.get(0).message().content();
    }
}

