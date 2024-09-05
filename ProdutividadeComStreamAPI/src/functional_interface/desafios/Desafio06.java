package functional_interface.desafios;

import java.util.Arrays;
import java.util.List;

public class Desafio06 {

	public static void main(String[] args) {
		 List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
		 
		 boolean maiorQueDez = numeros.stream()
		         .allMatch(n -> n > 10);  // Verifica se contém algum número maior que 10
		        
		 System.out.println("Contém algum número maior que 10? " + maiorQueDez);
	}
}
