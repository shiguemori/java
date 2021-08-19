package problems;

import java.math.BigInteger;
import java.util.*;

public class ExtraLongFactorials {

	static void extraLongFactorials(int n) {
		BigInteger fact = BigInteger.valueOf(1);
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		System.out.println(fact);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		extraLongFactorials(n);
		scanner.close();
	}
	
}
