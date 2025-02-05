package com.nttdata.education.service.mapper;

import com.nttdata.education.dto.requests.StudentRequestDto;
import com.nttdata.education.dto.responses.StudentResponseDto;
import com.nttdata.education.entity.School;
import com.nttdata.education.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toEntity(StudentRequestDto studentDto) {
        School school = new School();
        school.setId(studentDto.schoolId());
        return new Student(
                studentDto.firstname(),
                studentDto.lastname(),
                studentDto.email(),
                studentDto.age(),
                school
        );
    }

    public StudentResponseDto toResponse(Student student) {
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail(),
                student.getAge()
        );
    }

}
