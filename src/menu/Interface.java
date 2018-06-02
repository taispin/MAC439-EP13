package menu;

import java.util.Scanner;
import solicita.Solicitacao;

public class Interface {

	public Solicitacao solicita;

	public Interface() {
		solicita = new Solicitacao();
	}

	// Adiciona Professor
	public void adicionaProfessor() {
		Scanner line = new Scanner(System.in);

		// Recebe os dados do novo professor
		System.out.println("Informe os seguintes dados do novo Professor:");
		System.out.println("ID do professor:");
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

	public static void main(String[] args) {

		Interface tela;
		tela = new Interface();
		Scanner line = new Scanner(System.in);
		int escolha;
		int show = 1;

		while(show == 1) {
			System.out.println("SISTEMA ESCOLA:");
			System.out.println(" ESCOLHA UMA DAS OPÇÕES:");
			System.out.println("[1] -> Adicionar um Professor");
			System.out.println("[2] -> Adicionar um Aluno");
			System.out.println("[-1] -> SAIR");

			escolha = line.nextInt();

			if(escolha == 1) tela.adicionaProfessor();
			else if (escolha == 2) tela.adicionaAluno();
			else if (escolha == -1) show = 0;
			else System.out.println("Escolha uma opção válida ou -1 para sair!");
			System.out.println();
		}
	}
}
