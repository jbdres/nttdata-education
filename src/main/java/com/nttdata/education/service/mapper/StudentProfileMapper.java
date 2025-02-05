package com.nttdata.education.service.mapper;

import com.nttdata.education.dto.requests.StudentProfileRequestDto;
import com.nttdata.education.dto.responses.StudentProfileResponseDto;
import com.nttdata.education.entity.Student;
import com.nttdata.education.entity.StudentProfile;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileMapper {

    public com.nttdata.education.entity.StudentProfile toEntity(StudentProfileRequestDto studentProfileRequestDto) {
        Student student = new Student();
        student.setId(studentProfileRequestDto.studentId());
        return new StudentProfile(
                studentProfileRequestDto.date(),
                studentProfileRequestDto.description(),
                student
        );
    }

    public StudentProfileResponseDto toResponse(StudentProfile studentProfile) {
        return new StudentProfileResponseDto(
                studentProfile.getDate(),
                studentProfile.getDescription()
        );
    }

}
