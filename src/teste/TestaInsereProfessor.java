package teste;

import java.sql.SQLException;
import modelo.Professor;
import bd.ProfessorDAO;

public class TestaInsereProfessor {
	public static void main(String[] args) throws SQLException{
		 // pronto para gravar
		 Professor professor = new Professor();
		 professor.setidProf(77778L);
		 professor.setnomeProf("Kelly Ana Rosa");
		 professor.setidDepto(42);

		 // grave nessa conexão!!!
		 ProfessorDAO dao = new ProfessorDAO();

		 // método elegante
		 dao.adiciona(professor);

		 System.out.println("Foi Professor!");
	}
}
