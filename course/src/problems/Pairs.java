package problems;

import java.util.*;

public class Pairs {

	static void pairs(int k, int[] arr) {
		int total = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		for (int i : set) {
			total += (set.contains(i + k)) ? 1 : 0;
		}
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i + 1; j < arr.length; j++) {
//				if (Math.abs(arr[i] - arr[j]) == k) {
//					total++;
//				}
//			}
//		}
		System.out.println(total);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}
		pairs(k, arr);

		scanner.close();
	}
}
