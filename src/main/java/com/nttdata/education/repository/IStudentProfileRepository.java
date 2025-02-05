package com.nttdata.education.repository;

import com.nttdata.education.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentProfileRepository extends JpaRepository<StudentProfile, Integer> {
}
