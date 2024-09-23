package br.com.dio.desafio.dominio;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Conteudo {

	protected static final double XP_PADRAO = 10d;

	private String titulo;
	private String descricao;

	public abstract double calcularXp();

	public abstract int calcularCargaHoraria();

	public String calcularData() {
		// Data atual
		LocalDateTime dataAtual = LocalDateTime.now();

		// Gerar um número aleatório de dias entre 1 e 30
		int diasAleatorios = ThreadLocalRandom.current().nextInt(1, 31);

		// Gerar um número aleatório de horas entre 0 e 23
		int horasAleatorias = ThreadLocalRandom.current().nextInt(0, 24);

		// Gerar um número aleatório de minutos entre 0 e 59
		int minutosAleatorios = ThreadLocalRandom.current().nextInt(0, 60);

		// Gerar um número aleatório de segundos entre 0 e 59
		int segundosAleatorios = ThreadLocalRandom.current().nextInt(0, 60);

		// Adiciona dias aleatórios à data atual
		LocalDateTime dataAleatoria = dataAtual.plusDays(diasAleatorios).plusHours(horasAleatorias)
				.plusMinutes(minutosAleatorios).plusSeconds(segundosAleatorios);

		// Converte LocalDateTime para Date
		Date dataConvertida = Date.from(dataAleatoria.atZone(ZoneId.systemDefault()).toInstant());

		// Formatar a data e hora no padrão dd/MM/YYYY - HH:mm 08/08/2021 12:52 hrs
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY - HH:mm");

		// Retorna a nova data
		return formatador.format(dataConvertida);

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
