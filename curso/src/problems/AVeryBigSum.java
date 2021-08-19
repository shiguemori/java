package problems;

import java.util.*;

public class AVeryBigSum {

	static void aVeryBigSum(List<Long> list) {
		long sum = list.stream().mapToLong(Long::longValue).sum();
		System.out.println(sum);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int arCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		List<Long> ar = new ArrayList<Long>();
		
		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < arCount; i++) {
			ar.add(Long.parseLong(arItems[i]));
		}

		aVeryBigSum(ar);
		scanner.close();
	}
}
