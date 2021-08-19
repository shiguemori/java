package problems;

import java.util.*;

public class BirthdayCakeCandles {

	public static void birthdayCakeCandles(List<Long> candles) {

		candles.sort(null);
		long maior = candles.get(candles.size() - 1);
		int contador = 0;
		for (Long candle : candles) {
			if (candle == maior) {
				contador++;
			}
		}
		System.out.println(contador);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int candlesCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String[] arrItems = scanner.nextLine().split(" ");
		List<Long> arr = new ArrayList<Long>();

		for (int i = 0; i < candlesCount; i++) {
			arr.add(Long.parseLong(arrItems[i]));
		}

		birthdayCakeCandles(arr);

	}
}
