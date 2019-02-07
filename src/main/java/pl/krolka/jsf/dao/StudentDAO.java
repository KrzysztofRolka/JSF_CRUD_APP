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
	
}