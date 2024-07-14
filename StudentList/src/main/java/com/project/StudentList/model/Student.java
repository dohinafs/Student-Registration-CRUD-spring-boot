package com.project.StudentList.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //Auto generates id
	@NonNull
	private Long id; //student id
	
	@Column
	@NonNull
	private String name; //student name
	
	@Column
	@NonNull
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date date; //date of joining
	
	@Column
	@NonNull
	private String status; //status of fee payment
	
	//created constructor
	public Student() {
		
	}
	
	//added getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
