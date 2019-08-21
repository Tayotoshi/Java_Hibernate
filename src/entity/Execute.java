package entity;



public class Execute {

	public static void main(String[] args) {
		
				
		// Inserindo um aluno na tabela student	
		InsertInto inserir = new InsertInto();
		Estudante bernardo = inserir.inserirAluno("Matheus", "Souza", "sdo.bernardo@gmail.com");
		
		//Selecionando uma tabela
		SelectTabela sel = new SelectTabela();
		sel.selecionarTabela();
		
		//Atualizando o nome de um estudante
		UpdateEstudantes atu = new UpdateEstudantes();
		atu.updateEstudanteNome(bernardo, "Sergio");
		
		//Buscando aluno da tabela
		GetEstudante estudante = new GetEstudante();
		estudante.buscarEstudante(bernardo);
		

	}
}