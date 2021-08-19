package problems;

import java.util.*;

public class PlusMinus {
	static void plusMinus(List<Integer> arr) {
		double positivos = 0.0;
		double negativos = 0.0;
		double zeros = 0.0;

		for (int i = 0; i < arr.size(); i++) {
			int j = arr.get(i);
			if (j == 0) {
				zeros++;
			} else if (j > 0) {
				positivos++;
			} else {
				negativos++;
			}
		}
		System.out.printf("%.6f\n", positivos / arr.size());
		System.out.printf("%.6f\n", negativos / arr.size());
		System.out.printf("%.6f\n", zeros / arr.size());
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		List<Integer> arr = new ArrayList<Integer>();
		String[] arrItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(arrItems[i]));
		}

		plusMinus(arr);
		scanner.close();
	}
}
