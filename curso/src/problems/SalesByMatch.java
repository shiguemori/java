package problems;

import java.util.*;

public class SalesByMatch {
	static int sockMerchant(ArrayList<Integer> ar) {
		ar.sort(null);
		String verify = ar.toString();
		verify = verify.replace("[", " ");
		verify = verify.replace("]", " ");
		int count = 0;
		for (int i = 0; i < ar.size(); i++) {
			String search = " " + ar.get(i) + ", " + ar.get(i);
			if (verify.indexOf(search) != -1) {
				verify = verify.replaceFirst(search, " ");
				count++;
			}
		}
		System.out.println(count);
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Begin");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		ArrayList<Integer> ar1 = new ArrayList<Integer>();

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			ar1.add(Integer.parseInt(arItems[i]));
		}

		int result = sockMerchant(ar1);
		System.out.println(result);
		scanner.close();
	}
}
