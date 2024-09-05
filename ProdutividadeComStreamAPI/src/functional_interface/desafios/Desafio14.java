package functional_interface.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Desafio14 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

		Optional<Integer> maiorPrimo = numeros.stream()
	            .filter(n -> n > 1 && 
	                    java.util.stream.IntStream.rangeClosed(2, (int) Math.sqrt(n))
	                    .noneMatch(i -> n % i == 0))  // Verifica se o número é primo
	            .max(Integer::compareTo);  // Encontra o maior número primo
		
	    System.out.println("Maior número primo: " + maiorPrimo.get());
	}
}
