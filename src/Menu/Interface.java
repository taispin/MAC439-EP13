package menu;

import java.util.Scanner;
import Solicitacoes;

public class Interface {

	public Solicitacao solicita;

	public Interface() {
		solicita = new Solicitacao();
	}

	/************************************************/
	//Solicitacoes para Professores

	// Adiciona Professor
	public void adicionaProfessor() {
		Scanner line = new Scanner(System.in);

		// Recebe os dados do novo professor
		System.out.println("Informe ops seguintes dados do novo Professor:");
		System.out.println("ID do professor:");
		Long id = line.nextLong();

		System.out.println("Nome do Professor:");
		String nome = line.next();

		System.out.println("ID do Departamento:");
		Int depto = line.next();

		System.out.println(solicita.adicionaProfessor(id, nome, depto));
	}
}


	public static void main(String[] args) {

		Interface interface = new Interface();
		Scanner line = new Scanner(System.in);
		int escolha;

		while(true) {
			System.out.println("SISTEMA ESCOLA:");
			System.out.println(" ESCOLHA UMA DAS OPÇÕES:");
			System.out.println("[1] -> Adicionar um novo Professor");
			System.out.println("[2] -> Remover um Professor");
			System.out.println("[3] -> Alterar um Professor");

			escolha = line.nextInt();

			if(escolha == 1) interface.adicionaProfessor();

		}
}
