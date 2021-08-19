package problems;

import java.util.*;

public class MigratoryBirds {

	static void migratoryBirds(int arrCount, List<Integer> arr) {
		arr.sort(null);
		int[] aux = new int[arrCount];
		for (Integer bird : arr) {
			aux[bird]++;
		}
		int maior = -1;
		int chave = 0;
		for (int i = 0; i < aux.length; i++) {
			if (aux[i] > maior) {
				maior = aux[i];
				chave = i;
			}
		}
		System.out.println(chave);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int arrCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String[] birds = scanner.nextLine().split(" ");

		List<Integer> listBirds = new ArrayList<Integer>();

		for (int i = 0; i < arrCount; i++) {
			listBirds.add(Integer.parseInt(birds[i]));
		}

		migratoryBirds(arrCount, listBirds);

		scanner.close();
	}
}
