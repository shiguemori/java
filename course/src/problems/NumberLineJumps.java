package problems;

import java.util.*;

public class NumberLineJumps {

	static String kangaroo(long x1, long v1, long x2, long v2) {
		if (v2 == v1) {
			if (x1 != v2) {
				return "NO";
			}
		}
		if (x2 > x1) {
			if (v2 > v1) {
				return "NO";
			} else {
				while (x2 > x1) {
					x1 += v1;
					x2 += v2;
					if (x2 == x1) {
						return "YES";
					}
				}
			}
		}
		if (x2 < x1) {
			if (v2 < v1) {
				return "NO";
			}
			while (x2 < x1) {
				x1 += v1;
				x2 += v2;
				if (x2 == x1) {
					return "YES";
				}
			}
		}
		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] sc = scanner.nextLine().split(" ");

		long x1 = Integer.parseInt(sc[0]);
		long v1 = Integer.parseInt(sc[1]);

		long x2 = Integer.parseInt(sc[2]);
		long v2 = Integer.parseInt(sc[3]);

		System.out.println(kangaroo(x1, v1, x2, v2));

		scanner.close();
	}
}
