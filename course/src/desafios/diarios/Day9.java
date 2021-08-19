package desafios.diarios;

import java.util.*;

public class Day9 {

	static int factorial(int n) {
		int aux = 1;
		int result = n;
		while (n > 1) {
			result = result * aux;
			aux++;
			n--;
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int result = factorial(n);
		System.out.println(result);

		scanner.close();
	}
}
