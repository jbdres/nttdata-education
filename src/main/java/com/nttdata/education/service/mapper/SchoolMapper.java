package com.nttdata.education.service.mapper;

import com.nttdata.education.dto.requests.SchoolRequestDto;
import com.nttdata.education.dto.responses.SchoolResponseDto;
import com.nttdata.education.entity.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School toEntity(SchoolRequestDto schoolRequestDto) {
        return new School(
                schoolRequestDto.name(),
                schoolRequestDto.address(),
                schoolRequestDto.phone()
        );
    }

    public SchoolResponseDto toResponse(School school) {
        return new SchoolResponseDto(
                school.getName(),
                school.getAddress(),
                school.getPhone()
        );
    }

}
