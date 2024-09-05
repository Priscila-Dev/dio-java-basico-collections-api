package functional_interface.desafios;

import java.util.Arrays;
import java.util.List;

public class Desafio08 {

	public static void main(String[] args) {
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        
        int somaNumeros = numeros.stream()
            .mapToInt(Integer :: intValue) // Converte o stream de Integer para int
            .sum();  // Soma os números
        
        System.out.println("Soma de todos os números: " + somaNumeros);
	}
}
