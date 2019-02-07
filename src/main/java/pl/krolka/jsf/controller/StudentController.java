package pl.krolka.jsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.krolka.jsf.dao.StudentDAO;
import pl.krolka.jsf.entities.Student;

@Named
@SessionScoped
public class StudentController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private StudentDAO studentDAO;
	
	private List<Student> students;
	
	public StudentController() {
		
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	@PostConstruct
	public void OnSetup() {
		students = studentDAO.findAll();
	}

}