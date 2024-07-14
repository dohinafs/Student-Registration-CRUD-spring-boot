package com.project.StudentList.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.StudentList.model.Student;

@Repository
public interface IStudentRepo extends JpaRepository<Student, Long> {

}
