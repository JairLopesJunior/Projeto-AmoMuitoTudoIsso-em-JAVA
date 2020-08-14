package amomuitotudoisso;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int opcao;
		FilaClientes sc = new FilaClientes();
		FilaEsperaPedido fep = new FilaEsperaPedido();
		
		do {
			System.out.println("PROJETO AMO MUITO TUDO ISSO");
			System.out.println("==============================");
			System.out.println("1. Cadastrar Cliente");
			System.out.println("==============================");
			System.out.println("2. Encontrar Cliente");
			System.out.println("==============================");
			System.out.println("3. Encontrar Cliente Preferencial");
			System.out.println("==============================");
			System.out.println("4. Realizar Pedido.");
			System.out.println("==============================");
			System.out.println("5. Ver média de satisfação.");
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
			
			if(opcao == 4) {
				int numPedido = 0;
				Pedido pedido = new Pedido();
				ClienteIdoso clienteIdosoEncontrado = sc.retornarClientesIdoso();
				if(clienteIdosoEncontrado == null) {
					System.out.println("\n======================================================================================");
					System.out.println("Bom. Não temos nenhuma senha preferêncial. Neste caso vou chamar da fila Normal.");
					System.out.println("======================================================================================");
					Cliente clienteEncontrado = sc.retornarCliente();
					if(clienteEncontrado == null) {
						System.out.println("\n==============================");
						System.out.println("Nenhuma senha encontrada.");
						System.out.println("==============================\n");
					}else {
						System.out.println("\n======================================================================================");
						System.out.println(clienteEncontrado.getNome().toUpperCase() + " por favor, realize o seu pedido.");
						System.out.println("======================================================================================\n");
						System.out.println("------------------ CARDÁPIO ------------------");
						System.out.println("1. Misto Quente --------------------- R$ 2.50");
						System.out.println("2. Hanburguer ----------------------- R$ 2.50");
						System.out.println("3. Suco ----------------------------- R$ 1.50");
						System.out.println("4. Cola-Cola ------------------------ R$ 1.50\n");
						
						System.out.println("Informe o numero do lanche que deseja.");
						double num = scan.nextDouble();
						boolean lancheValidado = pedido.validarLanche(num);
						if(lancheValidado != false) {
							System.out.printf("O numero %f informado é inválido.", num);
							break;
						}else {
							pedido.setLanche(num);		
						}
						System.out.println("Informe o numero da bebida que deseja.");
						double bebida = scan.nextDouble();
						boolean bebidaValidada = pedido.validarBebida(num);
						if(bebidaValidada != false) {
							System.out.printf("O numero %f informado é inválido.", num);
							break;
						}else {
							pedido.setBebida(bebida);	
						}
						double total = pedido.somarPedido(num, bebida);
						numPedido++;
						pedido.setNumero(numPedido);
						clienteEncontrado.setPedido(pedido);
						clienteEncontrado.setNumeroPedido(numPedido);
						System.out.println("\n====================================================================");
						System.out.printf("O valor total do pedido foi %f ", total);
						System.out.println(".Pedido realizado com sucesso.");
						System.out.println("====================================================================\n");
						
						System.out.println("===========================================================================");
						System.out.printf("Por favor, insira um numero de satisfação.\n");
						System.out.println("1. :’(");
						System.out.println("2. :(");
						System.out.println("3. -_-");
						System.out.println("4. :)");
						System.out.println("5. :D");
						System.out.println("===========================================================================\n");
						double numeroSatisfacao = scan.nextDouble();
						pedido.setSatisfacao(numeroSatisfacao);
						clienteEncontrado.setPedido(pedido);
						fep.add(clienteEncontrado);
						sc.remove(clienteEncontrado);
						System.out.println("\n=================================");
						System.out.println("Obrigado pela colaboração.");
						System.out.println("=================================\n");
					}

				}else {
					System.out.println("\n======================================================================================");
					System.out.println(clienteIdosoEncontrado.getNome().toUpperCase() + " por favor, realize o seu pedido.");
					System.out.println("======================================================================================\n");
					System.out.println("------------------ CARDÁPIO ------------------");
					System.out.println("1. Misto Quente --------------------- R$ 2.50");
					System.out.println("2. Hanburguer ----------------------- R$ 2.50");
					System.out.println("3. Suco ----------------------------- R$ 1.50");
					System.out.println("4. Cola-Cola ------------------------ R$ 1.50\n");
					
					System.out.println("Informe o numero do lanche que deseja.");
					double num = scan.nextDouble();
					boolean lancheValidado = pedido.validarLanche(num);
					if(lancheValidado != false) {
						System.out.printf("O numero %f informado é inválido.", num);
						break;
					}else {
						pedido.setLanche(num);		
					}
					System.out.println("Informe o numero da bebida que deseja.");
					double bebida = scan.nextDouble();
					boolean bebidaValidada = pedido.validarBebida(num);
					if(bebidaValidada != false) {
						System.out.printf("O numero %d informado é inválido.", num);
						break;
					}else {
						pedido.setBebida(bebida);	
					}
					double total = pedido.somarPedido(num, bebida);
					pedido.setNumero(numPedido);
					clienteIdosoEncontrado.setNumeroPedido(numPedido);
					System.out.println("\n===========================================================================");
					System.out.printf("O valor total do pedido foi %f ", total);
					System.out.println(".Pedido realizado com sucesso.");
					System.out.println("===========================================================================\n");
					
					System.out.println("===========================================================================");
					System.out.printf("Por favor, insira um numero de satisfação.\n");
					System.out.println("1. :’(");
					System.out.println("2. :(");
					System.out.println("3. -_-");
					System.out.println("4. :)");
					System.out.println("5. :D");
					System.out.println("===========================================================================\n");
					double numeroSatisfacao = scan.nextDouble();
					pedido.setSatisfacao(numeroSatisfacao);
					clienteIdosoEncontrado.setPedido(pedido);
					fep.addIdoso(clienteIdosoEncontrado);
					sc.removeIdoso(clienteIdosoEncontrado);
					System.out.println("\n=================================");
					System.out.println("Obrigado pela colaboração.");
					System.out.println("=================================\n");
				}
			}
			
			if(opcao == 5) {
				System.out.println("\n================================================================");
				double result = fep.retornarSatisfacao();
				double resultIdoso = fep.retornarSatisfacaoIdosa();
				result += resultIdoso;
				result /= 2;
				System.out.printf("A média de satisfação dos nossos clientes é %f ", result);
				System.out.println("\n================================================================\n");
			}

			
		}while(opcao != 0);{
			System.exit(0);
		}

	}

}
