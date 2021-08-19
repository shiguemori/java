package problems;

import java.util.*;

public class MaximumSubarray {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int T = in.nextInt();
			for (int j = 0; j < T; j++) {
				long max = 0;
				long max2 = 0;
				int arraylength = in.nextInt();
				long[] continous = new long[arraylength];
				long noncontinous = 0;
				for (int i = 0; i < arraylength; i++) {
					if (i == 0) {
						int temp2 = in.nextInt();
						noncontinous += temp2;
						continous[i] = temp2;
						max = temp2;
						max2 = temp2;
					} else {
						int temp = in.nextInt();
						if (temp >= 0) {
							if (noncontinous >= 0) {
								noncontinous += temp;
							} else {
								noncontinous = temp;
							}
						} else {
							if (temp > max2) {
								max2 = temp;
							}
						}
						if ((continous[i - 1] + temp) >= temp) {
							continous[i] = continous[i - 1] + temp;
							if (continous[i] > max) {
								max = continous[i];
							}
						} else {
							continous[i] = temp;
							if (continous[i] > max) {
								max = temp;
							}
						}
					}
				}
				if (max2 > noncontinous) {
					noncontinous = max2;
				}
				System.out.println(max + " " + noncontinous);
			}
		}

	}

//	static long[] maxSubarray(List<Long> arr, int n) {
//		long[] result = new long[2];
//
//		long sumIndices = 0;
//		long sumValues = 0;
//		Iterator<Long> list = arr.iterator();
//		while (list.hasNext()) {
//			Long number = list.next();
//			if (number < 0) {
//				list.remove();
//			}
//		}
//		if (arr.size() > 0) {
//			for (long i = 0; i < arr.size(); i++) {
//				sumIndices = sumIndices + i + 1;
//				sumValues = sumValues + arr.get((int) i);
//			}
//			result[0] = sumIndices;
//			result[1] = sumValues;
//		} else {
//			result[0] = -1;
//			result[1] = -1;
//		}
//		return result;
//	}
//
//	private static final Scanner scanner = new Scanner(System.in);
//
//	public static void main(String[] args) {
//
//		int t = scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		String print = "";
//		for (int tItr = 0; tItr < t; tItr++) {
//			int n = scanner.nextInt();
//			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//			List<Long> arr = new ArrayList<Long>();
//			String[] arrItems = scanner.nextLine().split(" ");
//			for (long i = 0; i < n; i++) {
//				arr.add(Long.parseLong(arrItems[(int) i]));
//			}
//			long[] result = maxSubarray(arr, n);
//			for (int i = 0; i < result.length; i++) {
//				print = print + result[i] + " ";
//			}
//			print = print + "\n";
//		}
//		System.out.println(print);
//		scanner.close();
//	}
}
