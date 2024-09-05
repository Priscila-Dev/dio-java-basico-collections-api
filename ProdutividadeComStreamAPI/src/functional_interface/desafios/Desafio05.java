package functional_interface.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Desafio05 {

	public static void main(String[] args) {
		 List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
	        
	        OptionalDouble media = numeros.stream()
	            .filter(n -> n > 5)  // Filtra os números maiores que 5
	            .mapToInt(Integer::intValue)  // Converte o stream de Integer para int
	            .average();  // Calcula a média dos números
	      
	     System.out.println("Média dos números maiores que 5: " + media.getAsDouble());
	}
}
