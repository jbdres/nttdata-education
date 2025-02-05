package com.nttdata.education.dto.requests;

public record StudentRequestDto(
        String firstname,
        String lastname,
        String email,
        int age,
        Integer schoolId
) {
}
