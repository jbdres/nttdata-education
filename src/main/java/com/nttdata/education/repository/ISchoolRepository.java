package com.nttdata.education.repository;

import com.nttdata.education.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISchoolRepository extends JpaRepository<School, Integer> {
}
