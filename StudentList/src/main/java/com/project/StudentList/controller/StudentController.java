package com.project.StudentList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.StudentList.model.Student;
import com.project.StudentList.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping({"/","ViewStudentList"})
	public String viewAllStudents(Model model, @ModelAttribute("message") String message) {
		
		model.addAttribute("list", service.getAllStudents());
		model.addAttribute("msg", message);
		
		return "ViewStudentList";
	}
	
	
	@GetMapping("/UpdateStudent/{id}")
	public String updateStudentStatus(@PathVariable Long id, RedirectAttributes redirectAttributes ) {
		if(service.updateStatus(id)) {
			redirectAttributes.addFlashAttribute("message","Update Success");
			return "redirect:/ViewStudentList";
		}
		
		redirectAttributes.addFlashAttribute("message","Update Failure");
		return "redirect:/ViewStudentList";
		
	}
	
	@GetMapping("/AddStudent")
	public String addStudent(Model model) {
		model.addAttribute("student",new Student());
		
		return "AddStudent";
	}
	
	@PostMapping("/SaveStudent")
	public String saveStudent(Student student, RedirectAttributes redirectAttributes) {
		if(service.saveOrUpdateStudent(student)) {
			redirectAttributes.addFlashAttribute("message","Save Success");
			return "redirect:/ViewStudentList";
		}
		
		redirectAttributes.addFlashAttribute("message","Save Failure");
		return "redirect:/AddStudent";
	}
	
	@GetMapping("/EditStudent/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student",service.getStudentsById(id));
		
		return "EditStudent";
	}
	
	@PostMapping("/EditSaveStudent")
	public String editSaveStudent(Student student, RedirectAttributes redirectAttributes) {
		if(service.saveOrUpdateStudent(student)) {
			redirectAttributes.addFlashAttribute("message","Edit Success");
			return "redirect:/ViewStudentList";
		}
		
		redirectAttributes.addFlashAttribute("message","Edit Failure");
		return "redirect:/EditStudent/" + student.getId();
	}
	
	@GetMapping("/DeleteStudent/{id}")
	public String deleteStudent(@PathVariable Long id,RedirectAttributes redirectAttributes) {
		if(service.deleteStudent(id)) {
			redirectAttributes.addFlashAttribute("message","Delete Success");
			return "redirect:/ViewStudentList";
		}
		
		redirectAttributes.addFlashAttribute("message","Delete Failure");
		return "redirect:/ViewStudentList";
	}
	
	

}
