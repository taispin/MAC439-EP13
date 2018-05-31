package teste;

import java.sql.SQLException;

import modelo.Aluno;
import bd.AlunoDAO;

public class TestaInsereAluno {
	public static void main(String[] args) throws SQLException{
		 // pronto para gravar
		 Aluno aluno = new Aluno();
		 aluno.setnroAluno(7580421L);
		 aluno.setnomeAluno("Tais Pin");
		 aluno.setformacao("Computer Science");
		 aluno.setnivel("JR");
		 aluno.setidade(28);

		 // grave nessa conexão!!!
		 AlunoDAO dao = new AlunoDAO();

		 // método elegante
		 dao.adiciona(aluno);

		 System.out.println("Foi Aluno!");
	}
}
