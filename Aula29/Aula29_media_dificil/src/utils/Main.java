package utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Trie w = new Trie();
		ArrayList<String> palavras = new ArrayList<>();

		System.out.printf("Digite as palavras que deseja inserir ou 'sair' para sair : ");
		Scanner teclado = new Scanner(System.in);
		String entrada = teclado.nextLine();
		
		while (entrada.equalsIgnoreCase("sair") == false) {
			palavras.add(entrada);
			entrada = teclado.nextLine();
		}
		for (int i = 0; i < palavras.size(); i++) {
			w.insert(palavras.get(i));
		}
		w.print();
	}

}
