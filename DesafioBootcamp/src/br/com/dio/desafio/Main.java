package br.com.dio.desafio;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {

		Curso curso1 = new Curso();
		curso1.setTitulo("Sintaxe Básica Com Java");
		curso1.setDescricao("Sintaxe Java, Estruturas Condicionais, Estruturas de Repetição, Tratamento de Exeções.");
		curso1.setCargaHoraria(8);

		Curso curso2 = new Curso();
		curso2.setTitulo("Programação Orientada a Objetos Com Java");
		curso2.setDescricao(
				"Fundamentos da Programação Orientada a Objetos, Pilares da Programação Orientada a Objetos, \n"

						+ "Conhecendo Collections Java, Ganhando Produtividades Com Stream API.");
		curso2.setCargaHoraria(10);

		Curso curso3 = new Curso();
		curso3.setTitulo("Testes e Gerenciamento de Dependências em Projetos Java");
		curso3.setDescricao(
				"Gerenciamento de Dependências e Build em Java com Maven, Introdução a Testes de Software, \n"
						+ "Testes Unitários Com JUnit, Desenvolvendo Testes Utilizando Mockito, Calculando Consumo e Limite de Dados Móveis.");
		curso3.setCargaHoraria(8);

		Curso curso4 = new Curso();
		curso4.setTitulo("Banco de Dados SQL e NoSQL Para Desenvolvedores Back-End");
		curso4.setDescricao(
				"Introdução a Banco de Dados Relacionais (SQL), Introdução ao MongoDB e Bancos de Daos NoSQL.");

		curso4.setCargaHoraria(6);

		Mentoria mentoria1 = new Mentoria();
		mentoria1.setTitulo("O Mundo Devops na Claro");
		mentoria1.setDescricao(
				"Descubra como a Claro implementa práticas DevOps para otimizar processos e melhorar a eficiência operacional.");

		mentoria1.setData(LocalDate.now());

		Mentoria mentoria2 = new Mentoria();
		mentoria2.setTitulo("Criando Aplicações de IA com Agentes Autônomos");
		mentoria2.setDescricao("Aprenda a criar e implementar agentes que tomam decisões de forma independente, "
				+ "\nsimulando comportamento humano em diversos cenários e aprimorando a eficiência das suas soluções.");
		mentoria2.setData(LocalDate.now());

		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Construa uma API com Java e Spring de ponta a ponta!");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(curso3);
		bootcamp.getConteudos().add(curso4);
		bootcamp.getConteudos().add(mentoria1);
		bootcamp.getConteudos().add(mentoria2);

		ArrayList<Dev> devs = new ArrayList<>();

		devs.add(new Dev("Priscila Almeida", "258.351.227-54", "123045"));
		devs.add(new Dev("Lucas Ferreira", "957.365.861-73", "945568"));
		devs.add(new Dev("João Oliveira", "346.265.731-98", "548964"));
		devs.add(new Dev("Marcelo Carvalho", "294.618.951-34", "198948"));
		devs.add(new Dev("Paola Silveira", "794.219.846-58", "985549"));

		for (Dev dev : devs) {
			Dev.mapaDevs.put(dev.getCpf(), dev);
		}

		Menu.apresentacao(bootcamp);
		Menu.subMenu(bootcamp);
	}
}
