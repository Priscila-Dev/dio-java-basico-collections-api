package functional_interface.desafios;

import java.util.Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Desafio09 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        
		 // Cria um Set a partir da lista
        Set<Integer> numerosDistintos = new HashSet<>(numeros);
        
        // Verifica se o tamanho do Set é igual ao tamanho da lista original
        boolean todosDistintos = numerosDistintos.size() == numeros.size();
        
        System.out.println("Todos os números são distintos? " + todosDistintos);
	}
}
