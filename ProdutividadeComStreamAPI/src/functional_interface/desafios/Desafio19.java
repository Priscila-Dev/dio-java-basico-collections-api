package functional_interface.desafios;

import java.util.Arrays;
import java.util.List;

public class Desafio19 {

	public static void main(String[] args) {
		 List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
		 
		 int somaDivisiveis = numeros.stream()
		            .filter(n -> n % 3 == 0 && n % 5 == 0)  // Filtra números divisíveis por 3 ou 5
		            .mapToInt(Integer :: intValue) //converte para int
		            .sum(); //Soma os números	
		 
		 System.out.println("A soma dos números divisíveis por 3 e 5 é: " + somaDivisiveis );
	}

}
