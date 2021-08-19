package problems;

import java.util.*;

public class CamelCase {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String s = scanner.nextLine();
		
		System.out.println(s.length() - s.replaceAll("[A-Z]", "").length() + 1);

		scanner.close();
	}
}
