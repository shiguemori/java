package problems;

import java.util.*;

public class PowerSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int n = scan.nextInt();
		scan.close();
		System.out.println(powerSum(x, n, 0));
	}

	static int powerSum(int x, int n, int i) {
		x = x - (int) Math.pow(i, n);
		if (x == 0) {
			return 1;
		}
		if (x > 0) {
			int sum = 0;
			for (int j = i + 1; Math.pow(j, n) <= x; j++) {
				sum += powerSum(x, n, j);
			}
			return sum;
		} else {
			return 0;
		}
	}
}
