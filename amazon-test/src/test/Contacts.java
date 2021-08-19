package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Contacts {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numQueries = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < numQueries; i++) {
			String[] data = br.readLine().split(" ");

			if (data[0].equals("add")) {
				for (int j = 1; j <= data[1].length(); j++) {
					String sub = data[1].substring(0, j);
					if (map.get(sub) == null) {
						map.put(sub, 1);
					} else {
						map.put(sub, map.get(sub) + 1);
					}
				}
			} else { // query matches
				if (map.get(data[1]) == null) {
					System.out.println(0);
				} else {
					System.out.println(map.get(data[1]));
				}

			}
		}
	}

}
