package problems;

import java.util.*;

public class SimpleArraySum {
	static int simpleArraySum(int[] ar) {
		int total = 0;
		for (int i = 0; i < ar.length; i++) {
			total += ar[i];

		}
		return total;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int arCount = Integer.parseInt(scanner.nextLine().trim());
		int[] ar = new int[arCount];
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String[] arItems = scanner.nextLine().split(" ");

		for (int arItr = 0; arItr < arCount; arItr++) {
			int arItem = Integer.parseInt(arItems[arItr].trim());
			ar[arItr] = arItem;
		}

		int result = simpleArraySum(ar);
		System.out.println(result);
		scanner.close();
	}
}
