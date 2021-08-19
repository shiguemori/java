package problems;

import java.util.*;

public class DivisbleSumPairs {

	static void divisibleSumPairs(long k, List<Long> ar) {

		int count = 0;
		for (int i = 0; i < ar.size(); i++) {
			for (int j = i + 1; j < ar.size(); j++) {
				if ((ar.get(i) + ar.get(j)) % k == 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] nk = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int n = Integer.parseInt(nk[0]);
		long k = Integer.parseInt(nk[1]);
		List<Long> ar = new ArrayList<Long>();

		String[] arItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			ar.add(Long.parseLong(arItems[i]));
		}

		divisibleSumPairs(k, ar);
		scanner.close();
	}
}
