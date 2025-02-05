package com.nttdata.education.dto.responses;

public record StudentResponseDto(
        String firstname,
        String lastname,
        String email,
        int age
) {
}
