package br.com.desafio.banco.sistema;

import java.util.ArrayList;

import br.com.desafio.banco.Cliente;
import br.com.desafio.banco.contas.Conta;
import br.com.desafio.banco.contas.ContaCorrente;
import br.com.desafio.banco.contas.ContaPoupanca;

public class Main {

	public static void main(String[] args) {

		ArrayList<Cliente> clientes = new ArrayList<>();
		
		clientes.add(new Cliente("Corrente", "Patrícia Cardoso", "352.320.170-55", "34453", 1500.00, 11111, 222));
		clientes.add(new Cliente("Corrente", "Rafael Carvalho", "059.000.815-32", "123059", 1200.00, 22222,333));
		clientes.add(new Cliente("Corrente", "Gabriela Oliveira", "436.599.560-07", "567436", 800.00, 33333, 444));
		clientes.add(new Cliente("Corrente", "Carlos Medeiros", "682.143.008-00", "890682", 300.00,44444,555));
		clientes.add(new Cliente("Poupanca", "Maria Eduarda Silveira", "826.376.616-82", "345826", 600.00,66666,333));
		clientes.add(new Cliente("Poupanca", "Eduarda Lara Ferreira", "861.973.433-47", "123861", 800.00,77777,444));
		clientes.add(new Cliente("Poupanca", "Marcelo Diogo das Neves", "723.098.739-34", "123723", 900.00, 88888, 555));
		clientes.add(new Cliente("Poupanca", "Sophia Luana da Costa", "450.579.610-80", "658942", 920.00, 99999, 222));
		//System.out.println(clientes);
		
		// Adicionando cada cliente no mapaClientes, usando o CPF como chave
		for (Cliente cliente : clientes) {
		    Cliente.mapaClientes.put(cliente.getCpf(), cliente);
		    
		    if (cliente.getTipoConta().equalsIgnoreCase("Corrente")) {
		        ContaCorrente contaCorrente = new ContaCorrente(cliente);
		        Conta.mapaContas.put(cliente.getCpf(), contaCorrente);
		        
		    } else if (cliente.getTipoConta().equalsIgnoreCase("Poupanca")) {
		        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);
		        Conta.mapaContas.put(cliente.getCpf(), contaPoupanca);
		    }
		}
	
		MenuPrincipal.apresentacao();
		MenuPrincipal.menuInterativo();
	}

}
