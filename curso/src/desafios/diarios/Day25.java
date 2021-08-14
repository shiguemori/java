package desafios.diarios;

import java.util.*;

public class Day25 {

	static void isPrime(int number) {
		boolean isPrime = true;
		if (number == 1) {
			isPrime = false;
		} else {
			for (int i = 2; i <= number / 2; i++) {
				if (number % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		if (isPrime) {
			System.out.println("Prime");
		} else {
			System.out.println("Not prime");
		}
	}

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scan.nextInt();
		List<Integer> numbers = new ArrayList<Integer>();
		while (t-- > 0) {
			numbers.add(scan.nextInt());
		}
		for (Integer number : numbers) {
			isPrime(number);
		}
	}
}
