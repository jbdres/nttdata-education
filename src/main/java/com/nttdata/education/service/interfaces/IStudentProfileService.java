package com.nttdata.education.service.interfaces;

import com.nttdata.education.dto.requests.StudentProfileRequestDto;
import com.nttdata.education.dto.responses.StudentProfileResponseDto;

import java.util.List;

public interface IStudentProfileService {

    List<StudentProfileResponseDto> getAll();

    StudentProfileResponseDto getById(Integer id);

    StudentProfileResponseDto create(StudentProfileRequestDto studentProfileRequestDto);

    StudentProfileResponseDto updateById(Integer id, StudentProfileRequestDto studentProfileRequestDto);

    void deleteById(Integer id);

}
