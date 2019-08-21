package entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SelectTabela {
	
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Estudante.class)
			.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	public void selecionarTabela () {
		try {
			session.beginTransaction();
			List<Estudante> estudantes = session.createQuery("from Estudante as e where e.sobrenome = 'Souza'").getResultList();
			estudanteLoop(estudantes);
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
		
	}
	
	//Cria um metodo de Loop que pode ser utilizado para varios tipos de selects diferentes
	private void estudanteLoop(List<Estudante> estudantes) {
		for (Estudante estudante : estudantes) {
			System.out.println(estudante);
		}
	}
}
