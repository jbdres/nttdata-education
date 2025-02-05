package com.nttdata.education.controller;

import com.nttdata.education.dto.requests.StudentRequestDto;
import com.nttdata.education.dto.responses.StudentResponseDto;
import com.nttdata.education.service.implementation.StudentServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentServiceImp studentServiceImp;

    public StudentController(StudentServiceImp studentServiceImp) {
        this.studentServiceImp = studentServiceImp;
    }

    @GetMapping("/")
    public List<StudentResponseDto> getAllStudents() {
        return studentServiceImp.getAll();
    }

    @GetMapping("/{id}")
    public StudentResponseDto getStudentById(@PathVariable Integer id) {
        return studentServiceImp.getById(id);
    }

    @PostMapping("/")
    public StudentResponseDto createStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return studentServiceImp.create(studentRequestDto);
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(@PathVariable Integer id, @RequestBody StudentRequestDto studentRequestDto) {
        return studentServiceImp.updateById(id, studentRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentServiceImp.deleteById(id);
    }

}
