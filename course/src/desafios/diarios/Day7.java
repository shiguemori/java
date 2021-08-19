package desafios.diarios;

import java.util.*;

public class Day7 {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] arrItems = scanner.nextLine().split(" ");

		for (int i = n - 1; i >= 0; i--) {
			System.out.print(arrItems[i] + " ");
		}

		scanner.close();
	}
}
