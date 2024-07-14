package com.project.StudentList.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.StudentList.model.Student;
import com.project.StudentList.repo.IStudentRepo;

@Service
public class StudentService {
	
	@Autowired
	IStudentRepo repo;
	public List<Student> getAllStudents(){
		ArrayList<Student> studentList = new ArrayList<>();
		repo.findAll().forEach(student->studentList.add(student));
		return studentList;
	}
	
	public Student getStudentsById(Long id){
		return repo.findById(id).get();
	}
	
	public boolean updateStatus(Long id){
		Student student = getStudentsById(id);
		student.setStatus("Paid");
		
		return saveOrUpdateStudent(student);
	}
	
	
	public boolean saveOrUpdateStudent(Student student){
		Student updatedStudent = repo.save(student);
		
		if(getStudentsById(updatedStudent.getId()) !=null) {
			return true;
		}
		return false;
	}
	

	public boolean deleteStudent(Long id){
		repo.deleteById(id);
		
		if(repo.findById(id).isEmpty()) {
			return true;
		}
		return false;
	}
	

}
