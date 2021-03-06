package menu;

import java.util.Scanner;
import java.util.List;
import solicita.Solicitacao;

import modelo.Aluno;
import modelo.Curso;

public class Interface {

	public Solicitacao solicita;

	public Interface() {
		solicita = new Solicitacao();
	}

	/********************************************/
	// Adicionar

	// Adiciona Professor
	public void adicionaProfessor() {
		Scanner line = new Scanner(System.in);

		// Recebe os dados do novo professor
		System.out.println("");
		System.out.println("Informe os seguintes dados do novo Professor:");
		System.out.println("ID do professor:");
		System.out.println("");
		Long id = line.nextLong();

		System.out.println("Nome do Professor:");
		line.useDelimiter(System.getProperty("line.separator"));
		String nome = line.next();

		System.out.println("ID do Departamento:");
		int depto = line.nextInt();

		System.out.println(solicita.adicionaProfessor(id, nome, depto));
	}

	// Adiciona Aluno
	public void adicionaAluno() {
		Scanner line = new Scanner(System.in);

		// Recebe os dados do novo aluno
		System.out.println("Informe os seguintes dados do novo Aluno:");
		System.out.println("Número do Aluno:");
		Long id = line.nextLong();

		System.out.println("Nome do Aluno:");
		line.useDelimiter(System.getProperty("line.separator"));
		String nome = line.next();

		System.out.println("Formacao do Aluno:");
		line.useDelimiter(System.getProperty("line.separator"));
		String formacao = line.next();

		System.out.println("Nivel do Aluno:");
		line.useDelimiter(System.getProperty("line.separator"));
		String nivel = line.next();

		System.out.println("Idade do Aluno:");
		int idade = line.nextInt();

		System.out.println(solicita.adicionaAluno(id, nome, formacao, nivel, idade));
	}

	// Adiciona Curso
	public void adicionaCurso() {
		Scanner line = new Scanner(System.in);

		// Recebe os dados do novo curso
		System.out.println("Informe os seguintes dados do novo Curso:");
		System.out.println("Nome do Curso:");
		line.useDelimiter(System.getProperty("line.separator"));
		String nome = line.next();

		System.out.println("Horario do Curso:");
		line.useDelimiter(System.getProperty("line.separator"));
		String horario = line.next();

		System.out.println("Sala do Curso:");
		line.useDelimiter(System.getProperty("line.separator"));
		String sala = line.next();

		System.out.println("ID do Professor do Curso:");
		Long id = line.nextLong();

		System.out.println(solicita.adicionaCurso(nome, horario, sala, id));
	}

	/********************************************/
	// Remover

	//Remove Professor
	public void removeProfessor() {
		Scanner line = new Scanner(System.in);

		System.out.println("Informe os seguintes dados do Professor:");
		System.out.println("ID do Professor");
		Long id = line.nextLong();

		System.out.println(solicita.removeProfessor(id));
	}

	//Remove Aluno
	public void removeAluno() {
		Scanner line = new Scanner(System.in);

		System.out.println("Informe os seguintes dados do Aluno:");
		System.out.println("ID do Aluno");
		Long id = line.nextLong();

		System.out.println(solicita.removeAluno(id));
	}

	//Remove Curso
	public void removeCurso() {
		Scanner line = new Scanner(System.in);

		System.out.println("Informe os seguintes dados do Curso:");
		System.out.println("Nome do Curso:");
		line.useDelimiter(System.getProperty("line.separator"));
		String nome = line.next();

		System.out.println(solicita.removeCurso(nome));
	}

	/********************************************/
	// Alterar

	// Altera Professor
	public void alteraProfessor() {
		Scanner line = new Scanner(System.in);

		System.out.println("Informe os seguintes dados do Professor:");
		System.out.println("ID do professor:");
		Long id = line.nextLong();

		System.out.println("Nome do Professor:");
		line.useDelimiter(System.getProperty("line.separator"));
		String nome = line.next();

		System.out.println("ID do Departamento:");
		int depto = line.nextInt();

		System.out.println(solicita.alteraProfessor(id, nome, depto));
	}

	// Altera Aluno
	public void alteraAluno() {
		Scanner line = new Scanner(System.in);

		// Recebe os dados do aluno
		System.out.println("Informe os seguintes dados do Aluno:");
		System.out.println("Número do Aluno:");
		Long id = line.nextLong();

		System.out.println("Nome do Aluno:");
		line.useDelimiter(System.getProperty("line.separator"));
		String nome = line.next();

		System.out.println("Formacao do Aluno:");
		line.useDelimiter(System.getProperty("line.separator"));
		String formacao = line.next();

		System.out.println("Nivel do Aluno:");
		line.useDelimiter(System.getProperty("line.separator"));
		String nivel = line.next();

		System.out.println("Idade do Aluno:");
		int idade = line.nextInt();

		System.out.println(solicita.alteraAluno(id, nome, formacao, nivel, idade));
	}

	// Altera Curso
	public void alteraCurso() {
		Scanner line = new Scanner(System.in);

		// Recebe os dados do curso
		System.out.println("Informe os seguintes dados do Curso:");
		System.out.println("Nome do Curso:");
		line.useDelimiter(System.getProperty("line.separator"));
		String nome = line.next();

		System.out.println("Horario do Curso:");
		line.useDelimiter(System.getProperty("line.separator"));
		String horario = line.next();

		System.out.println("Sala do Curso:");
		line.useDelimiter(System.getProperty("line.separator"));
		String sala = line.next();

		System.out.println("ID do Professor do Curso:");
		Long id = line.nextLong();

		System.out.println(solicita.alteraCurso(nome, horario, sala, id));
	}

	/********************************************/
	// Buscar

	//Retorna os dados do curso e os alunos do curso
	public void buscaCursoExato() {

		Scanner line = new Scanner(System.in);
		List<Aluno> alunos = null;
		Curso curso = null;
		int escolha = 2;

		// Recebe os dados do curso
		System.out.println("");
		System.out.println("Informe o nome (exato) do Curso a ser buscado:");
		line.useDelimiter(System.getProperty("line.separator"));
		String nome = line.next();

		curso = new Curso();
		curso = solicita.mostraCurso(nome);
		alunos = solicita.mostraAlunos(nome);

		if(curso != null){
			System.out.println("");
			System.out.println("Detalhes do Curso:");
			System.out.println("");
			System.out.println("[ NOME: " + curso.getnome() + " ]");
			System.out.println("[ HORARIO: " + curso.gethorario() + " ]");
			System.out.println("[ SALA: " + curso.getsala() + " ]");
			System.out.println("[ IDPROF: " + String.valueOf(curso.getidProf()) + " ]");
			System.out.println("");
		}

		if(alunos != null) {
			System.out.println("");
			System.out.println("-> Alunos neste Curso:");
			for(Aluno aluno : alunos) {
				String elemento = "[ (Nro do aluno: " + aluno.getnroAluno() + ","
				+ "Nome: " + aluno.getnomeAluno() + ", "
				+ "Formacao: " + aluno.getformacao() + ", "
				+ "Nivel: " + aluno.getnivel() + ", "
				+ "Idade: " + aluno.getidade() + ")";
				System.out.println(elemento);
				System.out.println("");
			}
		}

		System.out.println("Deseja matricular uma aluno neste curso?");
		System.out.println("");
		System.out.println("SIM -> [1]");
		System.out.println("NAO -> [2]");
		System.out.println("");
		line.useDelimiter(System.getProperty("line.separator"));
		escolha = line.nextInt();
		//Caso queira efetuar matricula
		if(escolha == 1){

			System.out.println("");
			System.out.println("Qual eh o Numero do Aluno a ser matriculado?");
			System.out.println("");
			line.useDelimiter(System.getProperty("line.separator"));
			Long nro = line.nextLong();
			System.out.println(solicita.adicionaMatricula(nro,curso.getnome()));
		}
	}


	//Retorna os dados do curso e os alunos do curso
	public void buscaCursoParcial() {

		Scanner line = new Scanner(System.in);
		List<Aluno> alunos = null;
		List<Curso> cursos = null;
		int escolha = 2;

		// Recebe os dados do curso
		System.out.println("");
		System.out.println("Informe o nome (parcial) do Curso a ser buscado:");
		line.useDelimiter(System.getProperty("line.separator"));
		String nome = line.next();

		cursos = solicita.mostraCursos(nome);


		if(cursos != null){
			for(Curso c : cursos) {
			System.out.println("");
			System.out.println("Detalhes do Curso:");
			System.out.println("");
			System.out.println("[ NOME: " + c.getnome() + " ]");
			System.out.println("[ HORARIO: " + c.gethorario() + " ]");
			System.out.println("[ SALA: " + c.getsala() + " ]");
			System.out.println("[ IDPROF: " + String.valueOf(c.getidProf()) + " ]");
			System.out.println("");

			alunos = solicita.mostraAlunos(c.getnome());

			if(alunos != null) {
				System.out.println("");
				System.out.println("-> Alunos neste Curso:");
				for(Aluno aluno : alunos) {
					String elemento = "[ (Nro do aluno: " + aluno.getnroAluno() + ","
					+ "Nome: " + aluno.getnomeAluno() + ", "
					+ "Formacao: " + aluno.getformacao() + ", "
					+ "Nivel: " + aluno.getnivel() + ", "
					+ "Idade: " + aluno.getidade() + ")";
					System.out.println(elemento);
					System.out.println("");
					}
				}

				System.out.println("Deseja matricular uma aluno neste curso?");
				System.out.println("");
				System.out.println("SIM -> [1]");
				System.out.println("NAO -> [2]");
				System.out.println("");
				line.useDelimiter(System.getProperty("line.separator"));
				escolha = line.nextInt();
				//Caso queira efetuar matricula
				if(escolha == 1){

					System.out.println("");
					System.out.println("Qual eh o Numero do Aluno a ser matriculado?");
					System.out.println("");
					line.useDelimiter(System.getProperty("line.separator"));
					Long nro = line.nextLong();
					System.out.println(solicita.adicionaMatricula(nro,c.getnome()));
				}

			}
		}
	}

	public static void main(String[] args) {

		Interface tela;
		tela = new Interface();
		Scanner line = new Scanner(System.in);
		int escolha;
		int show = 1;

		while(show == 1) {
			System.out.println("SISTEMA ESCOLA:");
			System.out.println(" ESCOLHA UMA DAS OPÇÕES:");
			System.out.println("Adicionar um Professor          -> [1]");
			System.out.println("Adicionar um Aluno              -> [2]");
			System.out.println("Adicionar um Curso              -> [3]");
			System.out.println("Remover um Professor            -> [4]");
			System.out.println("Remover um Aluno                -> [5]");
			System.out.println("Remover um Curso                -> [6]");
			System.out.println("Alterar um Professor            -> [7]");
			System.out.println("Alterar um Aluno                -> [8]");
			System.out.println("Alterar um Curso                -> [9]");
			System.out.println("Buscar Curso por nome (exato)   -> [10]");
			System.out.println("Buscar Curso por nome (parcial) -> [11]");
			System.out.println("Buscar Curso por professor      -> [12]");
			System.out.println("SAIR ->  [13]");

			escolha = line.nextInt();

			if(escolha == 1) tela.adicionaProfessor();
			else if (escolha == 2) tela.adicionaAluno();
			else if (escolha == 3) tela.adicionaCurso();
			else if (escolha == 4) tela.removeProfessor();
			else if (escolha == 5) tela.removeAluno();
			else if (escolha == 6) tela.removeCurso();
			else if (escolha == 7) tela.alteraProfessor();
			else if (escolha == 8) tela.alteraAluno();
			else if (escolha == 9) tela.alteraCurso();
			else if (escolha == 10) tela.buscaCursoExato();
			else if (escolha == 11) tela.buscaCursoParcial();
			else if (escolha == 12) tela.buscaCursoProfessor();
			/*else if (escolha == 14) show = 0;*/
			else System.out.println("Escolha uma opção válida ou -1 para sair!");
			System.out.println();
		}
	}
}
