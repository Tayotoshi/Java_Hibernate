package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetEstudante {
	
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Estudante.class)
			.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	public void buscarEstudante (Estudante estudante) {
		
		try {			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("\nGetting student with the id :"+estudante.getId());
			
			Estudante busca = session.get(Estudante.class, estudante.getId());
			
			System.out.println("Get complete: "+busca);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
}
