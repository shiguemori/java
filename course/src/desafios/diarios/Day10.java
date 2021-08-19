package desafios.diarios;

import java.util.*;

public class Day10 {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		int rem = 0, s = 0, t = 0;
		while (n > 0) {
			rem = n % 2;
			n = n / 2;
			if (rem == 1) {
				s++;
				if (s >= t) {
					t = s;
				}
			} else {
				s = 0;
			}
		}
		System.out.println(t);
		scanner.close();
	}
}
