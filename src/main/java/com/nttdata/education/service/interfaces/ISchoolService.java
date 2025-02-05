package com.nttdata.education.service.interfaces;

import com.nttdata.education.dto.requests.SchoolRequestDto;
import com.nttdata.education.dto.responses.SchoolResponseDto;

import java.util.List;

public interface ISchoolService {

    List<SchoolResponseDto> getAll();

    SchoolResponseDto getById(Integer id);

    SchoolResponseDto create(SchoolRequestDto schoolRequestDto);

    SchoolResponseDto updateById(Integer id, SchoolRequestDto schoolRequestDto);

    void deleteById(Integer id);

}
