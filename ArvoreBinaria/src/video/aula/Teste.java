package video.aula;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Shiguemori
 *
 */
public class Teste {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		rodarArvoreBinaria();
	}

	public static void rodarArvoreBinaria() {

		System.out.println("Inicio Arvore Binaria");
		Scanner scan = new Scanner(System.in);
		ArvoreBinaria noDaArvore = null;
//		int t = scan.nextInt();
//		while (t-- > 0) {
//			int valor = scan.nextInt();
//			noDaArvore = inserir(noDaArvore, valor);
//		}
		for (int i = 0; i < 10; i++) {
			Random rand = new Random();
			noDaArvore = ArvoreBinaria.inserir(noDaArvore, rand.nextInt(300));
		}

		System.out.println("Imprimir pre ordem");
		ArvoreBinaria.imprimirPreOrdem(noDaArvore);

		System.out.println("\nAltura");
		System.out.println(noDaArvore.altura());

		System.out.println("Imprimir transversal");
		noDaArvore.iterarNo();
		
		System.out.println("\nQuantidade de nós é :" + noDaArvore.contarNos(0));

		System.out.println("Buscar");
		int t = scan.nextInt();
		boolean resultadoBusca = noDaArvore.buscar(t, false);
		System.out.println(resultadoBusca ? "Encontrado" : "Não encontrado");

		System.out.println("Remover");
		t = scan.nextInt();
		noDaArvore.removerNo(t);

		System.out.println("Imprimir transversal");
		noDaArvore.iterarNo();
		System.out.println("\nFim Arvore Binaria");
		scan.close();
	}

}
