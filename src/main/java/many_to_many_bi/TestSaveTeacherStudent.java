package many_to_many_bi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveTeacherStudent {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Teacher t = new Teacher();
		t.setName("sapthala");
		t.setAge(22);
		
		List<Teacher> ls = new ArrayList<Teacher>();
		ls.add(t);
		
		Subject s1 = new Subject();
		s1.setName("CS");
		s1.setDays(20);
		
		Subject s2 = new Subject();
		s2.setName("EEE");
		s2.setDays(30);
		
		List<Subject> lss = new ArrayList<Subject>();
		lss.add(s1);
		lss.add(s2);
		
		s1.setTeacher(ls);
		t.setSubject(lss);
		
		entityTransaction.begin();
		entityManager.persist(t);
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityTransaction.commit();
		
		System.out.println("Data stored");
	}

}
