package desafios.diarios;

import java.util.*;

public class Day3 {

	public static String validate(int n) {
		if (n % 2 == 0) {
			if (n >= 2 && n <= 5) {
				return "Not Weird";
			}
			if (n >= 6 && n <= 20) {
				return "Weird";
			}
			if (n > 20) {
				return "Not Weird";
			}
		} else {
			return "Weird";
		}
		return "Weird";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String result = validate(n);
		System.out.println(result);
		scanner.close();
	}
}
