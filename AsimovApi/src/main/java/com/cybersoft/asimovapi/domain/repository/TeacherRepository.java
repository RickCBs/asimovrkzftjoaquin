package com.cybersoft.asimovapi.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybersoft.asimovapi.domain.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    public Optional<Teacher> findByName(String name);
}
