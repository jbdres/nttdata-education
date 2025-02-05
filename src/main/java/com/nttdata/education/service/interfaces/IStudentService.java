package com.nttdata.education.service.interfaces;

import com.nttdata.education.dto.requests.StudentRequestDto;
import com.nttdata.education.dto.responses.StudentResponseDto;

import java.util.List;

public interface IStudentService {

    List<StudentResponseDto> getAll();

    StudentResponseDto getById(Integer id);

    StudentResponseDto create(StudentRequestDto studentRequestDto);

    StudentResponseDto updateById(Integer id, StudentRequestDto studentRequestDto);

    void deleteById(Integer id);

}
