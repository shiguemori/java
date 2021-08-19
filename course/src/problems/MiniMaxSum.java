package problems;

import java.util.*;
import java.util.stream.Collectors;

public class MiniMaxSum {

	static void miniMaxSum(List<Long> arr) {
		arr.sort(null);
		List<Long> menor = new ArrayList<Long>();
		List<Long> maior = new ArrayList<Long>();
		for (int i = 0; i < arr.size(); i++) {
			if (i != 0) {
				maior.add(arr.get(i));
			}
			if (i != arr.size() - 1) {
				menor.add(arr.get(i));
			}
		}
		System.out.println(menor.stream().collect(Collectors.summingLong(Long::longValue)) + " "
				+ maior.stream().collect(Collectors.summingLong(Long::longValue)));
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		List<Long> arr = new ArrayList<Long>();

		for (int i = 0; i < 5; i++) {
			arr.add(Long.parseLong(arrItems[i]));
		}
		miniMaxSum(arr);
		scanner.close();
	}
}
