package teste;

import java.sql.SQLException;

import modelo.Aluno;
import bd.AlunoDAO;

public class TestaAlteraAluno {
	public static void main(String[] args) throws SQLException{
		 Long  nro = 7580421L;

		 AlunoDAO dao = new AlunoDAO();
		 Aluno aluno = dao.obter(nro);

		 if (aluno != null) {

			 // altera nome
			 aluno.setnomeAluno("Tais Pin Pin");

			 // grava as alteracoes
			 dao.altera(aluno);

			 System.out.println("Alterações no aluno gravadas com sucesso!" + String.valueOf(nro));
		 }
		 else
			 System.out.println("Não existe aluno com id " + String.valueOf(nro) + "!");
	}
}
