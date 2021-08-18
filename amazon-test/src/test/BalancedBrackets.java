package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BalancedBrackets {

	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Begin");
		File file = new File(System.getenv("OUTPUT_PATH") + "\\estudo_java.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.nextLine();
			String result = isBalanced(s);
			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		scanner.close();
		bufferedWriter.close();
		System.out.println("End");

	}

	/**
	 * 
	 * {[()]} {[(])} {{[[(())]]}}
	 * 
	 * @param s
	 * @return
	 */
	static String isBalanced(String s) {

		int tam = s.length();
		if (tam % 2 != 0)
			return "NO";

		int n = -1;
		while (s.length() != n) {
			n = s.length();
			s = s.replace("()", "");
			s = s.replace("[]", "");
			s = s.replace("{}", "");
		}
		if (s.length() == 0)
			return "YES";
		else
			return "NO";
	}

}
