package teste;

import java.sql.SQLException;

import modelo.Aluno;
import bd.AlunoDAO;

public class TestaRemoveAluno {
	public static void main(String[] args) throws SQLException{
		 Long  nro = 7580421L;

		 AlunoDAO dao = new AlunoDAO();
		 Aluno aluno = dao.obter(nro);

		 if (aluno != null) {

			 // remove o aluno
			 dao.remove(aluno);

			 System.out.println("Aluno " + String.valueOf(nro) + "foi removido com sucesso!");
		 }
		 else
			 System.out.println("Não existe Aluno com id " + String.valueOf(nro) + "!");
	}
}
