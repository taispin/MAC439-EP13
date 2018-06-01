package teste;

import java.sql.SQLException;

import modelo.Professor;
import bd.ProfessorDAO;

public class TestaAlteraProfessor {
	public static void main(String[] args) throws SQLException{
		 Long  nro = 77777L;

		 ProfessorDAO dao = new ProfessorDAO();
		 Professor p = dao.obter(nro);

		 if (p != null) {

			 // altera nome
			 p.setnomeProf("Kelly Rosa Bla");

			 // grava as alteracoes
			 dao.altera(p);

			 System.out.println("Alterações no prof gravadas com sucesso!" + String.valueOf(nro));
		 }
		 else
			 System.out.println("Não existe prof com id " + String.valueOf(nro) + "!");
	}
}
