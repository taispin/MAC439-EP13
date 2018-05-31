package teste;

import java.sql.SQLException;

import modelo.Curso;
import bd.CursoDAO;

public class TestaRemoveCurso {
	public static void main(String[] args) throws SQLException{
		 String  nome = "Laboratorio de BD";

		 CursoDAO dao = new CursoDAO();
		 Curso c = dao.obter(nome);

		 if (c != null) {

			 // remove o curso
			 dao.remove(c);

			 System.out.println("Curso " + nome + " foi removido com sucesso!");
		 }
		 else
			 System.out.println("Não existe Curso  com nome " + nome + "!");
	}
}
