package desafios.diarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day6 {

	static void formatWord(List<String> word) {

		String result1 = "";
		String result2 = "";
		for (int i = 0; i < word.size(); i++) {
			result1 = "";
			result2 = "";
			char[] listChars = word.get(i).toCharArray();
			for (int j = 0; j < listChars.length; j++) {
				char c = listChars[j];
				if (j == 0 || j % 2 == 0) {
					result1 += c + "";
				} else {
					result2 += c + "";
				}
			}
			System.out.println(result1 + " " + result2);
		}
	}

	public static void main(String[] args) {
		try (
			/*
			 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
			 * class should be named Solution.
			 */
			Scanner scanner = new Scanner(System.in)) {
			// QTY of word that will be captured
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			List<String> word = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				word.add(scanner.nextLine());
			}

			formatWord(word);
		}

	}
}
