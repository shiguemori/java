package problems;

import java.util.*;

public class MissingNumbers {

	static void missingNumbers(Map<String, Integer> arr1, Map<String, Integer> arr2) {
		List<Integer> aux = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : arr2.entrySet()) {
			if (arr1.get(entry.getKey()) == null || arr1.get(entry.getKey()) != entry.getValue()) {
				aux.add(Integer.parseInt(entry.getKey()));
			}
		}
		aux.sort(null);
		aux.forEach(p -> {
			System.out.print(p + " ");
		});
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		Map<String, Integer> arr1 = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (arr1.containsKey(arrItems[i])) {
				arr1.put(arrItems[i], arr1.get(arrItems[i]) + 1);
			} else {
				arr1.put(arrItems[i], 1);
			}
		}

		int m = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		Map<String, Integer> arr2 = new HashMap<>();

		String[] brrItems = scanner.nextLine().split(" ");

		for (int i = 0; i < m; i++) {
			if (arr2.containsKey(brrItems[i])) {
				arr2.put(brrItems[i], arr2.get(brrItems[i]) + 1);
			} else {
				arr2.put(brrItems[i], 1);
			}
		}

		missingNumbers(arr1, arr2);

		scanner.close();
	}
}
