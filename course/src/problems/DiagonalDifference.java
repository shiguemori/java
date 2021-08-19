package problems;

import java.util.*;

public class DiagonalDifference {

	public static void diagonalDifference(List<String> list, int qtd) {
		int soma = 0;
		int sub = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).split(" ").length; j++) {
				if (i == j) {
					soma += Integer.parseInt(list.get(i).split(" ")[j]);
				}
			}
			int tam = list.get(i).split(" ").length - 1;
			sub += Integer.parseInt(list.get(i).split(" ")[tam - i]);
		}

		int result = Math.abs(soma - sub);
		System.out.println(result);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int sc = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < sc; i++) {
			String aux = scanner.nextLine();
			list.add(aux);
		}

		diagonalDifference(list, 3);
		scanner.close();
	}
}
