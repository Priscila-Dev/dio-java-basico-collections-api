package functional_interface.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Desafio17 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
		
		List<Integer> numerosPrimos = numeros.stream()
	            .filter(n -> n > 1 && 
	                    java.util.stream.IntStream.rangeClosed(2, (int) Math.sqrt(n))
	                    .noneMatch(i -> n % i == 0)) // Verifica se o número é primo
	            		.collect(Collectors.toList());  // Coleta em uma lista
		
	    System.out.println("Números primos: " + numerosPrimos);
	}
}
