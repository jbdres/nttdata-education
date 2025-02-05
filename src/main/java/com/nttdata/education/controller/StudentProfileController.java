package com.nttdata.education.controller;

import com.nttdata.education.dto.requests.StudentProfileRequestDto;
import com.nttdata.education.dto.responses.StudentProfileResponseDto;
import com.nttdata.education.service.implementation.StudentProfileServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentProfiles")
public class StudentProfileController {

    private final StudentProfileServiceImp studentProfileServiceImp;

    public StudentProfileController(StudentProfileServiceImp studentProfileServiceImp) {
        this.studentProfileServiceImp = studentProfileServiceImp;
    }

    @GetMapping("/")
    public List<StudentProfileResponseDto> getAllStudentProfiles() {
        return studentProfileServiceImp.getAll();
    }

    @GetMapping("/{id}")
    public StudentProfileResponseDto getStudentProfileById(@PathVariable Integer id) {
        return studentProfileServiceImp.getById(id);
    }

    @PostMapping("/")
    public StudentProfileResponseDto createStudentProfile(@RequestBody StudentProfileRequestDto studentProfileRequestDto) {
        return studentProfileServiceImp.create(studentProfileRequestDto);
    }

    @PutMapping("/{id}")
    public StudentProfileResponseDto updateStudentProfile(@PathVariable Integer id, @RequestBody StudentProfileRequestDto studentProfileRequestDto) {
        return studentProfileServiceImp.updateById(id, studentProfileRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentProfileById(@PathVariable Integer id) {
        studentProfileServiceImp.deleteById(id);
    }

}
