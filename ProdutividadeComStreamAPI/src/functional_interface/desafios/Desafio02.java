package functional_interface.desafios;

import java.util.Arrays;
import java.util.List;

public class Desafio02 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        
        int somaNumerosPares = numeros.stream()
            .filter(n -> n % 2 == 0) // Filtra os números pares
            .mapToInt(Integer :: intValue) // Converte o stream de Integer para int
            .sum();  // Soma os números
        
        System.out.println("Soma dos números pares: " + somaNumerosPares);
	}
}
