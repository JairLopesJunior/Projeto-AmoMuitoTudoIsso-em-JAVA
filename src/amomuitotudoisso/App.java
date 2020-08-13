package amomuitotudoisso;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int opcao;
		FilaClientes sc = new FilaClientes();
		
		do {
			System.out.println("PROJETO AMO MUITO TUDO ISSO");
			System.out.println("==============================");
			System.out.println("1. Cadastrar Cliente");
			System.out.println("==============================");
			System.out.println("2. Encontrar Cliente");
			System.out.println("==============================");
			System.out.println("3. Encontrar Cliente Preferencial");
			System.out.println("==============================");
			System.out.println("0. Sair");
			System.out.println("==============================");
			opcao = scan.nextInt();
			
			if(opcao == 1) {
				Cliente c = new Cliente();
				ClienteIdoso ci = new ClienteIdoso();
				System.out.print("Informe o nome do Cliente:");
				String nome = scan.next();
				System.out.print("Informe a idade do Cliente:");
				int idade = scan.nextInt();
				System.out.print("Informe o CPF do Cliente:");
				String cpf = scan.next();
				Cliente clienteEncontrado = sc.encontrarClienteCpf(cpf);
				ClienteIdoso clienteIdosoEncontrado = sc.encontrarClienteIdosoCpf(cpf);
				if(clienteEncontrado != null || clienteIdosoEncontrado != null) {
					System.out.println("\n==============================");
					System.out.println("Cliente já cadastrado.");
					System.out.println("==============================\n");
				}else {
					boolean clienteIdoso = sc.verificarIdade(idade);
					if(clienteIdoso == true) {
						ci.setNome(nome);
						ci.setIdade(idade);
						ci.setCpf(cpf);
						sc.addIdoso(ci);
						System.out.println("\n==============================");
						System.out.println("Cliente idoso adicionado.");
						System.out.println("==============================\n");
					}else {
						c.setNome(nome);
						c.setIdade(idade);
						c.setCpf(cpf);
						sc.add(c);
						System.out.println("\n==============================");
						System.out.println("Cliente cadastrado com sucesso.");
						System.out.println("==============================\n");
					}
				}
			}
			
			if(opcao == 2) {
				int count = 0;
				System.out.println("Informe o nome que deseja encontrar:");
				String nome = scan.next();
				Cliente encontrarCliente = sc.encontrarCliente(nome);
				if (encontrarCliente != null) {
					System.out.println("\n==============================");
					System.out.println("Nome: " + encontrarCliente.getNome());
					System.out.println("Idade: " + encontrarCliente.getIdade());
					int encontrar = sc.verificarIndex(encontrarCliente, count);
					if(encontrar != -1) {
						System.out.println("Posição na fila: " + (encontrar+1));
						System.out.println("==============================\n");
					}
				}else {
					System.out.println("\n==============================");
					System.out.println("Cliente não encontrado.");
					System.out.println("==============================\n");
				}
			}
			
			if(opcao == 3) {
				int count = 0;
				System.out.println("Informe o nome que deseja encontrar:");
				String nome = scan.next();
				ClienteIdoso clienteIdosoEncontrado = sc.encontrarClienteIdoso(nome);
				if (clienteIdosoEncontrado != null) {
					System.out.println("\n==============================");
					System.out.println("Nome: " + clienteIdosoEncontrado.getNome());
					System.out.println("Idade: " + clienteIdosoEncontrado.getIdade());
					int encontrar = sc.verificarIndexIdoso(clienteIdosoEncontrado, count);
					if(encontrar != -1) {
						System.out.println("Posição na fila: " + (encontrar+1));
						System.out.println("==============================\n");
					}
				}else {
					System.out.println("\n==============================");
					System.out.println("Cliente não encontrado.");
					System.out.println("==============================\n");
				}
			}
			
		}while(opcao != 0);{
			System.exit(0);
		}

	}

}
