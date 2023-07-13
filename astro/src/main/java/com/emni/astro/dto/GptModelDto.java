package com.emni.astro.dto;

public record GptModelDto(
        String id,
        String object,
        Long created,
        String owned_by
) {}
