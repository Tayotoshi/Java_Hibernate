package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEstudante {
	
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Estudante.class)
			.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	public void deleteEstudante (Estudante estudante) {
		try {			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("\nInteragindo com o estudante :"+estudante.getId());
			
			Estudante busca = session.get(Estudante.class, estudante.getId());
			
			System.out.println("Deletando estudante...: ");
			session.delete(busca);
			
			session.getTransaction().commit();
			
			System.out.println("Estudante deletado da tabela!");
		}
		finally {
			factory.close();
		}
	}
}
