package com.cybersoft.asimovapi.teacher.domain.repository;

import java.util.Optional;

import com.cybersoft.asimovapi.teacher.domain.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    public Optional<Teacher> findByName(String name);
}
