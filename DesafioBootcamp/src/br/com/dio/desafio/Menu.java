package br.com.dio.desafio;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Menu {

	static Scanner sc = new Scanner(System.in);
	static String inputCpf;
	static String inputSenha;

	public static void imprimeLinhaHorizontal() {
		System.out.println("----------------------------------------------------------------------------------------");
	}

	public void loopMenu(Bootcamp bootcamp) {
		boolean manterLoop = true;
		do {
			subMenu(bootcamp);
		} while (manterLoop == true);
	}

	public static void apresentacao(Bootcamp bootcamp) {
		try {
			System.out.println(
					"****************************************************************************************");
			Thread.sleep(200);
			System.out.println(
					"****************************************************************************************");
			Thread.sleep(200);
			System.out.println(
					"************************* Bem Vindo ao " + bootcamp.getNome() + " *************************");
			Thread.sleep(200);
			System.out.println(
					"****************************************************************************************");
			Thread.sleep(200);
			System.out.println("***************** " + bootcamp.getDescricao() + " *****************");
			Thread.sleep(200);
			System.out.println(
					"****************************************************************************************");
			Thread.sleep(200);
			System.out.println(
					"****************************************************************************************");
			Thread.sleep(1000);

			limTela();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void limTela() {
		for (int i = 0; i < 8; i++) {
			System.out.println();
		}
	}

	public static void subMenu(Bootcamp bootcamp) {
		try {
			imprimeLinhaHorizontal();
			System.out.println("Por favor, faça o login para acessar seus conteúdos.");
			System.out.println();
			System.out.print("Digite seu CPF: ");
			inputCpf = sc.next();
			System.out.print("Digite sua Senha: ");
			inputSenha = sc.next();

			Dev dev = Dev.mapaDevs.get(inputCpf);

			if (dev == null) {
				System.out.println("CPF não encontrado.\n\n");

				System.out.print("Digite seu CPF: ");
				inputCpf = sc.next();
				System.out.print("Digite sua senha: ");
				inputSenha = sc.next();
			}

			if (!dev.getSenha().equals(inputSenha)) {
				System.out.println("Senha incorreta.\n\n");

				System.out.print("Digite seu CPF: ");
				inputCpf = sc.next();
				System.out.print("Digite sua senha: ");
				inputSenha = sc.next();
			}
			System.out.println();
			System.out.println("Bem-vindo(a) ao " + bootcamp.getNome() + ", " + dev.getNome() + "!\n");
			menuInterativo(dev, bootcamp);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

	public static void menuInterativo(Dev dev, Bootcamp bootcamp) {

		int opcaoOperacao;
		do {
			imprimeLinhaHorizontal();
			System.out.println("[1]\tSe Inscrever");
			System.out.println("[2]\tConteúdos Inscritos");
			System.out.println("[3]\tConteúdos Concluídos");
			System.out.println("[4]\tConcluir Conteúdo");
			System.out.println("[5]\tHoras Concluídas");
			System.out.println("[6]\tXP");
			System.out.println("[7]\tSair");
			imprimeLinhaHorizontal();

			System.out.print("Digite a opção desejada: ");
			opcaoOperacao = sc.nextInt();
			imprimeLinhaHorizontal();

			switch (opcaoOperacao) {
			case 1:
				inscreverNoBootcamp(dev, bootcamp);
				break;

			case 2:
				if (dev.getConteudosInscritos().isEmpty()) {
					System.out.println("\nVocê não está inscrito em nenhum Curso ou Mentoria!\n");
				} else {
					System.out.println("\nConteúdos Inscritos:");

					// Listar Cursos
					System.out.println("\nCursos:\n");
					dev.getConteudosInscritos().stream().filter(conteudo -> conteudo instanceof Curso)
							.forEach(conteudo -> System.out.println("- " + conteudo.getTitulo() + "\n"
									+ "\nDescrição:\n*" + conteudo.getDescricao() + "\n" + "\nCarga Horária:\n"
									+ conteudo.calcularCargaHoraria() + " horas\n"));

					imprimeLinhaHorizontal();
					// Listar Mentorias
					System.out.println("\nMentorias:\n");
					// LocalDate dataMentoria = dev.calcularData();
					dev.getConteudosInscritos().stream().filter(conteudo -> conteudo instanceof Mentoria)
							.forEach(conteudo -> System.out.println(
									"- " + conteudo.getTitulo() + "\n" + "\nDescrição:\n*" + conteudo.getDescricao()
											+ "\n" + "\nData da Mentoria:\n" + conteudo.calcularData() + "\n"));
					System.out.println();
				}
				break;

			case 3:
				if (dev.getConteudosConcluidos().isEmpty()) {
					System.out.println("\nVocê não concluiu nenhum Curso ou Mentoria!\n");
				} else {

					// Listar Cursos
					System.out.println("\nCursos Concluídos:");
					dev.getConteudosConcluidos().stream().filter(conteudo -> conteudo instanceof Curso)
							.forEach(conteudo -> System.out.println("- " + conteudo.getTitulo()));

					// Listar Mentorias
					System.out.println("\nMentorias Concluídas:");
					dev.getConteudosConcluidos().stream().filter(conteudo -> conteudo instanceof Mentoria)
							.forEach(conteudo -> System.out.println("- " + conteudo.getTitulo()));
					System.out.println();
				}
				break;

			case 4:
				if (dev.getConteudosInscritos().isEmpty()) {
					System.out.println("\nVocê não está inscrito em nenhum Curso ou Mentoria!\n");
				} else {
					concluirConteudo(dev, bootcamp);
				}
				break;

			case 5:
				System.out.println("\nHoras concluídas: " + dev.calcularCargaHoraria() + " horas\n");
				break;

			case 6:
				System.out.println("\nXP acumulado: " + dev.calcularXp() + " XP\n");
				break;

			case 7:
				System.out.println("\nAté breve, " + dev.getNome() + "!\n");
				subMenu(bootcamp);
				break;
			default:
				imprimeLinhaHorizontal();
				System.out.println("Opção inválida!");
				imprimeLinhaHorizontal();
				sc.close();
			}

			menuInterativo(dev, bootcamp);

		} while (opcaoOperacao != 0);

		menuInterativo(dev, bootcamp);

	}

	public static void inscreverNoBootcamp(Dev dev, Bootcamp bootcamp) {

		int opcao;
		do {
			System.out.println("\nConteúdos disponíveis no " + bootcamp.getNome() + ":");
			imprimeLinhaHorizontal();
			System.out.println("[1]\tCursos");
			System.out.println("[2]\tMentorias");
			System.out.println("[3]\tSair");
			imprimeLinhaHorizontal();

			System.out.print("Digite a opção desejada: ");
			opcao = sc.nextInt();
			imprimeLinhaHorizontal();

			switch (opcao) {
			case 1:
				System.out.println("\nCursos:");
				imprimeLinhaHorizontal();
				int cursoNumero = 1; // Contador para cursos
				ArrayList<Conteudo> cursos = new ArrayList<>();
				for (Conteudo conteudo : bootcamp.getConteudos()) {
					if (conteudo instanceof Curso && !dev.getConteudosInscritos().contains(conteudo)
							&& !dev.getConteudosConcluidos().contains(conteudo)) {
						System.out.println("[" + cursoNumero + "]\t" + conteudo.getTitulo());
						cursos.add(conteudo); // Adiciona à lista para referência posterior
						cursoNumero++;
					}
				}

				if (cursos.isEmpty()) {
					System.out.println("\nTodos os Cursos já estão inscritos!\n");
					imprimeLinhaHorizontal();
				} else {

					System.out.println("[" + cursoNumero + "]\tSair");
					imprimeLinhaHorizontal();
					System.out.print("Digite o número do Curso que deseja se inscrever: ");
					int escolhaCurso = sc.nextInt();
					imprimeLinhaHorizontal();

					if (escolhaCurso > 0 && escolhaCurso <= cursos.size()) {
						Conteudo cursoEscolhido = cursos.get(escolhaCurso - 1);
						dev.inscreverConteudo(cursoEscolhido);
						imprimeLinhaHorizontal();
						System.out.println("\nVocê se inscreveu no Curso: " + cursoEscolhido.getTitulo() + "\n");
						imprimeLinhaHorizontal();
					} else if (escolhaCurso > 0 && escolhaCurso == cursos.size() + 1) {
						inscreverNoBootcamp(dev, bootcamp);
					} else {
						System.out.println("Opção inválida.");
					}
				}
				break;

			case 2:
				System.out.println("\nMentorias:");
				imprimeLinhaHorizontal();
				int mentoriaNumero = 1;
				ArrayList<Conteudo> mentorias = new ArrayList<>();
				for (Conteudo conteudo : bootcamp.getConteudos()) {
					if (conteudo instanceof Mentoria && !dev.getConteudosInscritos().contains(conteudo)
							&& !dev.getConteudosConcluidos().contains(conteudo)) {
						System.out.println("[" + mentoriaNumero + "]\t" + conteudo.getTitulo());
						mentorias.add(conteudo); // Adiciona à lista para referência posterior
						mentoriaNumero++;
					}
				}

				if (mentorias.isEmpty()) {
					System.out.println("\nTodos as Mentorias já estão inscritas!\n");
					imprimeLinhaHorizontal();
				} else {

					System.out.println("[" + mentoriaNumero + "]\tSair");
					imprimeLinhaHorizontal();
					System.out.print("Digite o número da Mentoria que deseja se inscrever: ");
					int escolhaMentoria = sc.nextInt();
					imprimeLinhaHorizontal();

					if (escolhaMentoria > 0 && escolhaMentoria <= mentorias.size()) {
						Conteudo mentoriaEscolhida = mentorias.get(escolhaMentoria - 1);
						dev.inscreverConteudo(mentoriaEscolhida);
						imprimeLinhaHorizontal();
						System.out.println("\nVocê se inscreveu na Mentoria: " + mentoriaEscolhida.getTitulo() + "\n");
						imprimeLinhaHorizontal();
					} else if (escolhaMentoria > 0 && escolhaMentoria == mentorias.size() + 1) {
						inscreverNoBootcamp(dev, bootcamp);
					} else {
						System.out.println("Opção inválida.");
					}
				}

				break;

			case 3:
				menuInterativo(dev, bootcamp);
				break;
			default:
				imprimeLinhaHorizontal();
				System.out.println("Opção inválida!");
				imprimeLinhaHorizontal();
				sc.close();
			}

		} while (opcao != 0);

	}

	public static void concluirConteudo(Dev dev, Bootcamp bootcamp) {

		int opcao;
		do {
			System.out.println("\nConcluír conteúdo:");
			imprimeLinhaHorizontal();
			System.out.println("[1]\tCursos");
			System.out.println("[2]\tMentorias");
			System.out.println("[3]\tSair");
			imprimeLinhaHorizontal();

			System.out.print("Digite a opção desejada: ");
			opcao = sc.nextInt();
			imprimeLinhaHorizontal();

			Set<Conteudo> conteudosInscritos = dev.getConteudosInscritos();
			switch (opcao) {
			case 1:

				int cursoNumero = 1;
				ArrayList<Conteudo> cursos = new ArrayList<>();

				// Exibir cursos
				for (Conteudo conteudo : conteudosInscritos) {

					if (conteudo instanceof Curso) {

						System.out.println("[" + cursoNumero + "]\t" + conteudo.getTitulo());
						cursos.add(conteudo); // Adiciona à lista para referência posterior
						cursoNumero++;

					} else if (dev.getConteudosInscritos().isEmpty()) {
						System.out.println("\nVocê não está inscrito em nenhum Curso.\n");
						imprimeLinhaHorizontal();
					}
				}

				if (cursos.isEmpty()) {
					System.out.println("\nTodos os Cursos já estão concluídos!\n");
					imprimeLinhaHorizontal();
				} else {

					System.out.println("[" + cursoNumero + "]\tSair");
					imprimeLinhaHorizontal();
					System.out.print("Digite o número do Curso que deseja concluir: ");
					int escolhaCurso = sc.nextInt();
					imprimeLinhaHorizontal();

					if (escolhaCurso > 0 && escolhaCurso <= cursos.size()) {
						Conteudo conteudoEscolhido = cursos.get(escolhaCurso - 1);
						dev.concluirConteudo(conteudoEscolhido);
						imprimeLinhaHorizontal();
						System.out.println("\nVocê concluiu o Curso: " + conteudoEscolhido.getTitulo() + "\n");
						imprimeLinhaHorizontal();

					} else if (escolhaCurso > 0 && escolhaCurso == cursos.size() + 1) {
						concluirConteudo(dev, bootcamp);
					} else {
						System.out.println("Opção inválida.");
					}
				}

				break;
			case 2:
				int mentoriaNumero = 1;
				ArrayList<Conteudo> mentorias = new ArrayList<>();

				// Exibir mentorias
				for (Conteudo conteudo : conteudosInscritos) {

					if (conteudo instanceof Mentoria) {

						System.out.println("[" + mentoriaNumero + "]\t" + conteudo.getTitulo());
						mentorias.add(conteudo); // Adiciona à lista para referência posterior
						mentoriaNumero++;
					} else if (dev.getConteudosInscritos().isEmpty()) {
						System.out.println("\nVocê não está inscrito em nenhuma Mentoria.\n");
						imprimeLinhaHorizontal();

					}
				}

				if (mentorias.isEmpty()) {
					System.out.println("\nTodos as Mentorias já estão concluídas!\n");
					imprimeLinhaHorizontal();
				} else {

					System.out.println("[" + mentoriaNumero + "]\tSair");
					imprimeLinhaHorizontal();
					System.out.print("Digite o número da Mentoria que deseja concluir: ");
					int escolhaMentoria = sc.nextInt();
					imprimeLinhaHorizontal();

					if (escolhaMentoria > 0 && escolhaMentoria <= mentorias.size()) {
						Conteudo conteudoEscolhido = mentorias.get(escolhaMentoria - 1);
						dev.concluirConteudo(conteudoEscolhido);
						imprimeLinhaHorizontal();
						System.out.println("\nVocê concluiu a Mentoria: " + conteudoEscolhido.getTitulo() + "\n");

					} else if (escolhaMentoria > 0 && escolhaMentoria == mentorias.size() + 1) {
						concluirConteudo(dev, bootcamp);
					} else {
						System.out.println("Opção inválida.");
					}
				}

				break;
			case 3:
				menuInterativo(dev, bootcamp);
				break;
			default:
				imprimeLinhaHorizontal();
				System.out.println("Opção inválida!");
				imprimeLinhaHorizontal();
				sc.close();
			}

		} while (opcao != 0);

	}

}
