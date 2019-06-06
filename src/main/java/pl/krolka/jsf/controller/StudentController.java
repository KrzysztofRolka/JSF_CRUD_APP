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
public class StudentController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private StudentDAO studentDAO;

	private List<Student> students;

	private Student student;

	private Student studentToUpdate;

	public StudentController() {
		student = new Student();
	}

	public List<Student> getStudents() {
		return students;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getStudentToUpdate() {
		return studentToUpdate;
	}

	@PostConstruct
	public void OnSetup() {
		students = studentDAO.findAll();
	}

	public String addStudent() {
		studentDAO.add(student);
		student = new Student();
		students = studentDAO.findAll();
		return "student_list";
	}

	public String deleteStudent(int id) {
		studentDAO.delete(id);
		students = studentDAO.findAll();
		return "student_list";
	}

	public String updateStudent() {
		studentDAO.update(studentToUpdate);
		students = studentDAO.findAll();
		return "student_list";
	}
	
	public String onUpdate(Student student) {
		studentToUpdate = student;
		return "update_Student_Form";
	}
}