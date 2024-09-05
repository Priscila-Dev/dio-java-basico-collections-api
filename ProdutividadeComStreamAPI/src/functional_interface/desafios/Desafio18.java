package functional_interface.desafios;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Desafio18 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

		// Cria um Set para rastrear números encontrados e outro para números repetidos
        Set<Integer> encontrados = new HashSet<>();
        Set<Integer> repetidos = numeros.stream()
            .filter(n -> !encontrados.add(n))  // Tenta adicionar ao conjunto, se falhar, é repetido
            .collect(Collectors.toSet());  // Coleta os números repetidos em um conjunto
      
        System.out.println("Números que se repetem: " + repetidos);
	}

}
