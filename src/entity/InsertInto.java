package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertInto {
	
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Estudante.class)
			.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	public Estudante inserirAluno(String nome, String sobre_nome, String email) {
		
		
		// create a student object
		System.out.println("Creating new student object...");
		Estudante estudante = new Estudante(nome, sobre_nome, email);
		
		// start a transaction
		session.beginTransaction();
		
		// save the student object
		System.out.println("Saving the student...");
		session.save(estudante);
		// commit transaction
		session.getTransaction().commit();
		
		factory.close();
		return estudante;
	}
}
