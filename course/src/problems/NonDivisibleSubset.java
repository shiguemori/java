package problems;

import java.util.*;

public class NonDivisibleSubset {

	static void nonDivisibleSubset(String[] s1, String[] s2) {
		
		int k = Integer.parseInt(s1[1]);
		int[] remainderArr = new int[k];
		for (String each : s2) {
			remainderArr[Integer.parseInt(each) % k]++;
		}
		int zeroRemainder = remainderArr[0];
		int maxNumberOfDivisibleSet = zeroRemainder > 0 ? 1 : 0;
		for (int i = 1; i <= (k / 2); i++) {
			if (i != k - i)
				maxNumberOfDivisibleSet += Math.max(remainderArr[i], remainderArr[k - i]);
			else
				maxNumberOfDivisibleSet++;
		}

		System.out.println(maxNumberOfDivisibleSet);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] s1 = scanner.nextLine().replaceAll("\\s+$", "").split(" ");
		String[] s2 = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

		nonDivisibleSubset(s1, s2);
	}
}
