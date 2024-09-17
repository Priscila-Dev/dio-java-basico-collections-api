package br.com.desafio.banco.sistema;

import java.io.IOException;
import java.util.Scanner;

import br.com.desafio.banco.Cliente;
import br.com.desafio.banco.contas.Conta;
import br.com.desafio.banco.enuns.ETipoConta;

public class MenuPrincipal {

	static Scanner sc = new Scanner(System.in);
	double inputValor;
	static String inputCpf;
	static String inputSenha;
	String operacao;
	
	public static void imprimeLinhaHorizontal() {
		System.out.println("------------------------------------------------------------------------------");
	}

	public void loopMenu() {
		boolean manterLoop = true;
		do {
			menuInterativo();
		} while (manterLoop == true);
	}
	
	public static void menuInterativo() {
		try {
			imprimeLinhaHorizontal();
			System.out.println("Digite seu CPF");
			inputCpf = sc.next();
			System.out.println("Digite sua Senha");
			inputSenha = sc.next();
			
			Cliente cliente = Cliente.mapaClientes.get(inputCpf);
			
			 // Se o cliente for null, significa que o CPF não está cadastrado
	        if (cliente == null) {
	            System.out.println("CPF não encontrado.\n\n");
	            
	            System.out.print("Digite seu CPF: ");
				inputCpf = sc.next();
				System.out.print("Digite sua senha: ");
				inputSenha = sc.next();
	        }

	        // Verifica se a senha está correta
	        if (!cliente.getSenha().equals(inputSenha)) {
	            System.out.println("Senha incorreta.\n\n");
	            
	            System.out.print("Digite seu CPF: ");
				inputCpf = sc.next();
				System.out.print("Digite sua senha: ");
				inputSenha = sc.next();
	        }

	        // Se o CPF e senha estiverem corretos, continua para o submenu
	        Conta conta = Conta.mapaContas.get(inputCpf);
	        subMenu(cliente, conta);
				
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
	
	public static void apresentacao() {

		try {
			System.out.println("******************************************************************************");
			Thread.sleep(200);
			System.out.println("********************************  Bem Vindo   ********************************");
			Thread.sleep(200);
			System.out.println("********************************   My Bank    ********************************");
			Thread.sleep(200);
			System.out.println("******************************************************************************");
			Thread.sleep(200);
			System.out.println("*****************************  Sempre Com Você!  *****************************");
			Thread.sleep(200);
			System.out.println("******************************************************************************");
			Thread.sleep(1000);
			limTela();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void limTela() {
		for (int i = 0; i < 15; i++) {
			System.out.println();
		}
	}
	
//SUBMENU
	public static void subMenu(Cliente cliente, Conta conta) throws IOException {
		try {
			imprimeLinhaHorizontal();
			System.out.println("Bem-vindo(a) ao seu Banco, " + cliente.getNome() + "!\n");
			MenuPrincipal.menuCliente(cliente, conta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			subMenu(cliente, conta);
		}
		menuCliente(cliente, conta);
	}
	
	public static void menuCliente(Cliente cliente, Conta conta) throws IOException {

		try {
			imprimeLinhaHorizontal();
			System.out.println("[1]\tSaque");
			System.out.println("[2]\tDepósito");
			System.out.println("[3]\tTransferência");
			System.out.println("[4]\tSaldo");
			System.out.println("[5]\tExtrato");
			System.out.println("[6]\tSimulação de Rendimentos");
			System.out.println("[7]\tSair");
			imprimeLinhaHorizontal();
			
			System.out.print("Digite a opção desejada: ");
			String opcaoOperacao = sc.next();
			imprimeLinhaHorizontal();
			
			Double inputValor;

			switch (opcaoOperacao) {
			case "1":
				System.out.print("Digite o valor que deseja sacar: ");
				inputValor = Double.parseDouble(sc.next());
				imprimeLinhaHorizontal();
				conta.sacar(inputValor);
				break;
			case "2":
				System.out.print("Digite o valor que deseja depositar: ");
				inputValor = Double.parseDouble(sc.next());
				imprimeLinhaHorizontal();
				conta.depositar(inputValor);
				break;
			case "3":
				System.out.println("Informe para qual CPF deseja realizar a transferência: ");
				String cpf = sc.next();
				System.out.print("Digite o valor que deseja transferir: ");
				inputValor = Double.parseDouble(sc.next());
				imprimeLinhaHorizontal();
				Conta contaDestino = (Conta) Conta.mapaContas.get(cpf);
				conta.transferir(inputValor, contaDestino);
				break;
			case "4":
				System.out.printf("Seu saldo é: R$%.2f", conta.getSaldo());
				System.out.println();
				double valor = conta.getSaldo();
				break;
			case "5":
				conta.imprimirExtrato();
				break;
			case "6":
				if (conta.getTipoConta().equalsIgnoreCase(ETipoConta.POUPANCA.getTipoConta())) {
					System.out.println("Informe a quantia em dinheiro: ");
					Double quantia = sc.nextDouble();
					System.out.println("Informe quantos dias de rendimento: ");
					int dias = sc.nextInt();
					imprimeLinhaHorizontal();
					Double rendimento = dias * 0.5;
					Double total = quantia + rendimento;
					System.out.printf("O rendimento de " + dias + " dias é: R$%.2f ", rendimento, "!");
					System.out.println();
					System.out.printf("O rendimento total é: R$%.2f ", total, "!");
					System.out.println();
				} else {
					System.out.println("A sua conta não possui rendimento!");
				}
				break;
			case "7":
				menuInterativo();
				break;
			default:
				imprimeLinhaHorizontal();
				System.out.println("Opção inválida!");
				imprimeLinhaHorizontal();
				sc.close();
			}

			menuCliente(cliente, conta);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			menuCliente(cliente, conta);
		}
	}
}
