package teste;

import java.sql.SQLException;

import modelo.Curso;
import bd.CursoDAO;

public class TestaAlteraCurso{
	public static void main(String[] args) throws SQLException{
		 String  nome = "Laboratorio de BD2";

		 CursoDAO dao = new CursoDAO();
		 Curso c = dao.obter(nome);

		 if (c != null) {

			 // altera sala
			 c.setsala("Linux");

			 // grava as alteracoes
			 dao.altera(c);

			 System.out.println("Alterações no curso gravadas com sucesso! " + nome);
		 }
		 else
			 System.out.println("Não existe curso com nome " + nome + "!");
	}
}
