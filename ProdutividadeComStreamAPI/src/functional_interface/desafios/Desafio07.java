package functional_interface.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Desafio07 {

	public static void main(String[] args) {
		 List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
	        
	        Optional<Integer> segundoMaior = numeros.stream()
	            .distinct()  // Remove valores duplicados
	            .sorted((a, b) -> b - a)  // Ordena os números em ordem decrescente
	            .skip(1)  // Pula o primeiro número (que é o maior)
	            .findFirst();  // Obtém o segundo maior número
	        
	     System.out.println("O segundo maior número da lista é: " + segundoMaior.get()); 
	}
}
