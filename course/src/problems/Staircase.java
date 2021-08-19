package problems;

import java.util.*;

public class Staircase {

	static void staircase(int n) {
		for (int i = 1; i <= n; i++) {
			int target = n;
			for (int j = 1; j <= n; j++) {
				if (i >= target) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
				target--;
			}
			System.out.println();
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		staircase(n);

		scanner.close();
	}
}
