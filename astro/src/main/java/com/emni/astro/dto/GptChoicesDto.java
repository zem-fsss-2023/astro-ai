package com.emni.astro.dto;

public record GptChoicesDto(GptAutocompletionMessageDto message, String finish_reason, Integer index) {

}
