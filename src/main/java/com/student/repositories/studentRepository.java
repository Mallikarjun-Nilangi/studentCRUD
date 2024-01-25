package com.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entities.student;

public interface studentRepository extends JpaRepository<student, Long> {

}
