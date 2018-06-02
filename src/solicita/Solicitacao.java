package solicita;

// Inclui os Modelos
import modelo.Aluno;
import modelo.Professor;
import modelo.Curso;
import modelo.Matriculado;

//Inclui os DAO's
import bd.AlunoDAO;
import bd.ProfessorDAO;
import bd.CursoDAO;

// Exceptions
import java.lang.RuntimeException;

public class Solicitacao {

	//Declara o core de cada solicitacao
	AlunoDAO aDao = null;
	ProfessorDAO pDao = null;
	CursoDAO cDao = null;

	/************************************************/
	//Solicitacoes para Professores


	// Adiciona Professor
	public String adicionaProfessor(Long id, String nome, int depto) {

		Professor p = new Professor();
		p.setidProf(id);
		p.setnomeProf(nome);
		p.setidDepto(depto);

		if(pDao == null) pDao = new ProfessorDAO();

		try {
			pDao.adiciona(p);
		}
		catch (RuntimeException e) {
			return("Erro ao adiconar o professor " + nome);
		}

		return("Professor " + nome + " adicionado com sucesso");
	}

	//Remove Professor
	public String removeProfessor(Long id) {

		if(pDao == null) pDao = new ProfessorDAO();

		Professor p = new Professor();
		p.setidProf(id);

		try {
			pDao.remove(p);
		}
		catch (RuntimeException e) {
			return("[ Erro ao remover professor com id " + String.valueOf(id) + " ]");
		}

		return("[ Professor com id " + String.valueOf(id) + " removido com sucesso ]");
	}

	//Altera Professor
	public String alteraProfessor(Long id, String nome, int depto) {
		Professor p = new Professor();
		p.setidProf(id);
		p.setnomeProf(nome);
		p.setidDepto(depto);

		if(pDao == null) pDao = new ProfessorDAO();

		try {
			pDao.altera(p);
		}
		catch (RuntimeException e) {
			return("[ Erro ao alterar professor " + nome + " ]");
		}

		return("[ Professor " + nome +" alterado com sucesso ]");
	}



	/************************************************/
	// Solicitacoes para Alunos


	// Adiciona Aluno
	public String adicionaAluno(Long nro, String nome, String formacao,
	  String nivel, int idade) {

		Aluno a = new Aluno();
		a.setnroAluno(nro);
		a.setnomeAluno(nome);
		a.setformacao(formacao);
		a.setnivel(nivel);
		a.setidade(idade);

		if(aDao == null)aDao = new AlunoDAO();

		try {
			aDao.adiciona(a);
		}
		catch (RuntimeException e) {
			return("[ Nao foi possivel inseriri o aluno " + nome + " ]");
		}

		return("[ Aluno " + nome + " adicionado com sucesso ]");
	}

	//Remove Aluno
	public String removeAluno(Long nro) {

		if(aDao == null)aDao = new AlunoDAO();

		Aluno a = new Aluno();
		a.setnroAluno(nro);

		try {
			aDao.remove(a);
		}
		catch (RuntimeException e) {
			return(" [ Erro ao remover aluno com id " + String.valueOf(nro) + " ]");
		}

		return("[ Aluno com id " + String.valueOf(nro) + " removido com sucesso ]");
	}

	// Altera Aluno
	public String alteraAluno(Long nro, String nome, String formacao,
	  String nivel, int idade) {

			Aluno a = new Aluno();
			a.setnroAluno(nro);
			a.setnomeAluno(nome);
			a.setformacao(formacao);
			a.setnivel(nivel);
			a.setidade(idade);

		if(aDao == null)aDao = new AlunoDAO();

		try {
			aDao.altera(a);
		}
		catch (RuntimeException e) {
			return("Não foi possivel alaterar aluno com id " + String.valueOf(nro));
		}

		return("Aluno com id " + String.valueOf(nro) + " alterado com sucesso");
	}

	/************************************************/
	// Solicitacoes para Curso

	//Adiciona Curso
	public String adicionaCurso(String nome, String horario,
	 String sala, Long idprof) {
		Curso c = new Curso();
		c.setnome(nome);
		c.sethorario(horario);
		c.setsala(sala);
		c.setidProf(idprof);

		if(cDao == null) cDao = new CursoDAO();

		try {
			cDao.adiciona(c);
		}
		catch (RuntimeException e) {
			return("Erro ao adiconar o curso " + nome);
		}

		return("Curso "  + nome + " adicionado com sucesso");
	}

	//Remove Curso
	public String removeCurso(String nome) {

	if(cDao == null) cDao = new CursoDAO();

	Curso c = new Curso();
	c.setnome(nome);
		try {
			cDao.remove(c);
		}
		catch (RuntimeException e) {
			return("[ Erro ao remover curso " + nome + " ]");
		}

		return("[ Curso " +  nome + " removido com sucesso ]");
	}

	//Altera Curso
	public String alteraCurso(String nome, String horario,
	 String sala, Long idprof) {

		Curso c = new Curso();
		c.setnome(nome);
		c.sethorario(horario);
		c.setsala(sala);
		c.setidProf(idprof);

		if(cDao == null) cDao = new CursoDAO();

		try {
			cDao.altera(c);
		}
		catch (RuntimeException e) {
			return("Erro ao alterar curso " + nome);
		}

		return("Curso " + nome + " alterado com sucesso");
	}


}
