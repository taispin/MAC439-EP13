package teste;

import java.sql.SQLException;
import modelo.Curso;
import bd.CursoDAO;

public class TestaInsereCurso {
	public static void main(String[] args) throws SQLException{
		 // pronto para gravar
		 Curso c = new Curso();
		 c.setnome("Laboratorio de BD2");
		 c.sethorario("WeFr 10-8");
		 c.setsala("CEC");
		 c.setidProf(77777L);

		 // grave nessa conexão!!!
		 CursoDAO dao = new CursoDAO();

		 // método elegante
		 dao.adiciona(c);

		 System.out.println("Foi Curso!");
	}
}
