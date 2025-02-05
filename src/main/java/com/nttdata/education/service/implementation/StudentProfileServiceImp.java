package com.nttdata.education.service.implementation;

import com.nttdata.education.dto.requests.StudentProfileRequestDto;
import com.nttdata.education.dto.responses.StudentProfileResponseDto;
import com.nttdata.education.entity.Student;
import com.nttdata.education.entity.StudentProfile;
import com.nttdata.education.repository.IStudentProfileRepository;
import com.nttdata.education.repository.IStudentRepository;
import com.nttdata.education.service.interfaces.IStudentProfileService;
import com.nttdata.education.service.mapper.StudentProfileMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentProfileServiceImp implements IStudentProfileService {

    private final StudentProfileMapper studentProfileMapper;
    private final IStudentProfileRepository studentProfileRepository;
    private final IStudentRepository studentRepository;

    public StudentProfileServiceImp(StudentProfileMapper studentProfileMapper, IStudentProfileRepository studentProfileRepository, IStudentRepository studentRepository) {
        this.studentProfileMapper = studentProfileMapper;
        this.studentProfileRepository = studentProfileRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentProfileResponseDto> getAll() {
        return studentProfileRepository.findAll()
                .stream()
                .map(studentProfileMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentProfileResponseDto getById(Integer id) {
        return studentProfileRepository.findById(id)
                .map(studentProfileMapper::toResponse)
                .orElse(null);
    }

    @Override
    public StudentProfileResponseDto create(StudentProfileRequestDto studentProfileRequestDto) {
        return studentProfileMapper.toResponse(
                studentProfileRepository.save(
                        studentProfileMapper.toEntity(studentProfileRequestDto)
                )
        );
    }

    @Override
    public StudentProfileResponseDto updateById(Integer id, StudentProfileRequestDto studentProfileRequestDto) {
        StudentProfile actualStudentProfile = studentProfileRepository.findById(id).orElse(null);
        Student actualStudent = studentRepository.findById(studentProfileRequestDto.studentId()).orElse(null);
        if (actualStudentProfile == null || actualStudent == null) {
            return null;
        }
        actualStudentProfile.setDate(studentProfileRequestDto.date());
        actualStudentProfile.setDescription(studentProfileRequestDto.description());
        actualStudentProfile.setStudent(actualStudent);
        return studentProfileMapper.toResponse(studentProfileRepository.save(actualStudentProfile));
    }

    @Override
    public void deleteById(Integer id) {
        studentProfileRepository.deleteById(id);
    }
}
