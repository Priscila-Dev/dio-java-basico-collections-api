package functional_interface.desafios;

import java.util.Arrays;
import java.util.List;

public class Desafio11 {

	public static void main(String[] args) {
		 List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

	        int somaQuadrados = numeros.stream()
	            .mapToInt(n -> n * n)  // Calcula o quadrado de cada número
	            .sum();  // Soma os quadrados
	        
	        System.out.println("Soma dos quadrados: " + somaQuadrados);
	}
}
