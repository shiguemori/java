package teste;

import java.util.HashMap;
import java.util.Scanner;

public class exercicio2 {

	public static String SearchingChallenge(String[] strArr) {
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		for (int i = 0; i < strArr.length; i++) {
			String[] aux = strArr[i].split(":");
			int value = Integer.parseInt(aux[1]);
			if (list.containsKey(aux[0])) {
				value = value + list.get(aux[0]);
			}
			if (value == 0) {
				list.remove(aux[0]);
			} else {
				list.put(aux[0], value);
			}
		}
		return list.toString().replace("{", "").replace("}", "").replaceAll("=", ":").replaceAll(" ", "");
	}

	public static void main(String[] args) {
		// keep this function call here
		Scanner s = new Scanner(System.in);
		System.out.print(SearchingChallenge(new String[] { "X:-1", "Y:1", "X:-4", "B:3", "X:5" }));
	}
}
