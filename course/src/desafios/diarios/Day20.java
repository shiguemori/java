package desafios.diarios;

import java.util.*;

public class Day20 {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			int insert = in.nextInt();
			a[a_i] = insert;
		}

		int totalSwaps = 0;
		for (int i = n - 1; i > 0; i--) {
			int numberOfSwaps = 0;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					numberOfSwaps++;
					totalSwaps++;
				}
			}
			if (numberOfSwaps == 0) {
				break;
			}
		}
		System.out.println("Array is sorted in " + totalSwaps + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[n - 1]);
	}
}
