package desafios.diarios;

import java.util.*;

public class Day8 {
	public static void main(String[] argh) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		HashMap<String, Integer> contacts = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String name = in.next();
			int phone = in.nextInt();
			contacts.put(name, phone);
		}

		String result = "";
		while (in.hasNext()) {
			String s = in.next();
			if (contacts.get(s) != null) {
				result = s + "=" + contacts.get(s);
			} else {
				result = "Not found";
			}
			System.out.println(result);
		}
		in.close();
	}
}
