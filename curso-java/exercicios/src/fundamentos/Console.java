package fundamentos;

import java.io.*;
import java.util.*;

public class Console {
	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		final List<Integer> ids = null;

		for (int i = 0; i < ar.length; i++) {
			ids.add(ar[i]);
		}
		final Map<Integer, Integer> idQuantidade = new HashMap<>();
		
		for (int i = 0; i < ar.length; i++) {
			idQuantidade.put(ar[i], Collections.frequency(ids, ar[i]));
		}
		
		idQuantidade.values();		
		return 0;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);

		/*
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 */
		scanner.close();
	}
}
