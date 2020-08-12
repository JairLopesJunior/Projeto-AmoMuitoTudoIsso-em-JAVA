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
			System.out.println("0. Sair");
			System.out.println("==============================");
			opcao = scan.nextInt();
			
			if(opcao == 1) {
				Cliente c = new Cliente();
				System.out.print("Informe o nome do Cliente:");
				String nome = scan.next();
				c.setNome(nome);
				System.out.print("Informe a idade do Cliente:");
				int idade = scan.nextInt();
				c.setIdade(idade);
				sc.verificarIdade(idade);
				System.out.print("Informe o CPF do Cliente:");
				String cpf = scan.next();
				c.setCpf(cpf);
				Cliente clienteEncontrado = sc.encontrarClienteCpf(cpf);
				if(clienteEncontrado != null) {
					System.out.println("\n==============================");
					System.out.println("Cliente já cadastrado.");
					System.out.println("==============================\n");
				}else {
					sc.add(c);
					System.out.println("\n==============================");
					System.out.println("Cliente cadastrado com sucesso.");
					System.out.println("==============================\n");
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
			
		}while(opcao != 0);{
			System.exit(0);
		}

	}

}
