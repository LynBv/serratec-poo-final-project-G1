// Fazer um programa para contagem de funcionários.
package com.folhadepagamento.alexandre;

import java.util.ArrayList;
import java.util.Scanner;

public class ContagemFuncionarios {

	public static void main(String[] args) {

		// Lista simples de funcionários.
		ArrayList<String> funcionarios = new ArrayList<>();
		funcionarios.add("Ana Paula Ferreira");
		funcionarios.add("Bruno Henrique Almeida");
		funcionarios.add("Camila Silva Oliveira");
		funcionarios.add("Diego Martins Pereira");
		funcionarios.add("Eliane Souza Lima");
		funcionarios.add("Gabriela Costa Nunes");
		funcionarios.add("Felipe Gomes Rocha");
		funcionarios.add("Henrique Barbosa Teixeira");
		funcionarios.add("Ronaldo Ribeiro Dominguez");
		funcionarios.add("Isabela Mendes Cardoso");

		Scanner scanner = new Scanner(System.in);
		int opcao;

		do {

			System.out.println("1. Listar funcionários");
			System.out.println("2. Contar funcionários");
			System.out.println("3. Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {

			case 1:

				// Listar funcionários.
				System.out.println("Lista de funcionários:");
				for (String f : funcionarios) {
					System.out.println(f);

				}

				System.out.println();
				break;

			case 2:

				// Contar funcionários.
				System.out.println("Número total de funcionários: " + funcionarios.size() + "\n");
				break;

			case 3:

				// Saindo do programa.
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.\n");

			}

		} while (opcao != 3);

		scanner.close();

	}

}