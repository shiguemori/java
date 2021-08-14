package problems;

import java.util.*;

public class BiggerIsGreater {

	static void biggerIsGreater(String s) {
		char charArr[] = s.toCharArray();
		int n = charArr.length;
		int i = 0;
		for (i = n - 1; i > 0; i--) {
			if (charArr[i] > charArr[i - 1]) {
				break;
			}
		}

		String r = "";
		if (i == 0) {
			r = "no answer";
		} else {
			int small = charArr[i - 1], next = i;

			for (int j = i + 1; j < n; j++) {
				if (charArr[j] > small && charArr[j] < charArr[next]) {
					next = j;
				}
			}
			swap(charArr, i - 1, next);
			Arrays.sort(charArr, i, n);
			r = new String(charArr);
		}
		System.out.println(r);
	}

	static void swap(char charArr[], int i, int j) {
		char temp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = temp;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int T = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int TItr = 0; TItr < T; TItr++) {
			String w = scanner.nextLine();
			biggerIsGreater(w);
		}
		scanner.close();
	}
}
