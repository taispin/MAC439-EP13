package teste;

import java.sql.SQLException;

import modelo.Professor;
import bd.ProfessorDAO;

public class TestaRemoveProfessor {
	public static void main(String[] args) throws SQLException{
		 Long  nro = 77778L;

		 ProfessorDAO dao = new ProfessorDAO();
		 Professor p = dao.obter(nro);

		 if (p != null) {

			 // remove o professor
			 dao.remove(p);

			 System.out.println("Professor " + String.valueOf(nro) + " foi removido com sucesso!");
		 }
		 else
			 System.out.println("Não existe Professor com id " + String.valueOf(nro) + "!");
	}
}
