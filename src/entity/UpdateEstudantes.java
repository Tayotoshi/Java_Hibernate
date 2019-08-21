package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEstudantes {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Estudante.class)
			.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	public void updateEstudanteNome (Estudante estudante,String nome) {
		try {			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("\nGetting student with the id :"+estudante.getPrimeiro_nome());
			
			Estudante busca = session.get(Estudante.class, estudante.getId());
			
			System.out.println("Atualizando estudante...: ");
			busca.setPrimeiro_nome(nome);
			
			session.getTransaction().commit();
			
			System.out.println("Estudante atualizado!");
		}
		finally {
			factory.close();
		}
	}
}
