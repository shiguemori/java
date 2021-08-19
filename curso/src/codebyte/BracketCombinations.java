package codebyte;

import java.util.*;

public class BracketCombinations {

	static int count;

	public static int bracketCombinations(int num) {
		count = 0;
		helper(num, num);
		return count;
	}

	public static void helper(int lp, int rp) {
		if (lp > rp)
			return;
		if (lp == 0 && rp == 0) {
			count++;
			return;
		}
		if (lp > 0) {
			helper(lp - 1, rp);
		}
		if (rp > 0) {
			helper(lp, rp - 1);
		}
	}

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print(bracketCombinations(s.nextInt()));
	}
}
