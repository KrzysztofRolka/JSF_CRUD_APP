package pl.krolka.jsf.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.krolka.jsf.entities.Student;

@Stateless
public class StudentDAO {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public List<Student> findAll(){
		 TypedQuery<Student> query =  entityManager.createQuery("SELECT s FROM Student s", Student.class);
		 return query.getResultList();
	}
	
	public void add(Student student) {
		entityManager.persist(student);
		entityManager.flush();
	}
	
	public void delete(int id) {
		Student studentToRemove = entityManager.find(Student.class, id);
		entityManager.remove(studentToRemove);
		entityManager.flush();
	}
	
	public void update(Student student) {
		entityManager.merge(student);
		entityManager.flush();
	}
}