package com.nttdata.education.dto.requests;

public record StudentProfileRequestDto(
        String date,
        String description,
        Integer studentId
) {
}
