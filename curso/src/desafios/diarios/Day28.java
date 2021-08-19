package desafios.diarios;

import java.util.*;

public class Day28 {

	private static final Scanner scanner = new Scanner(System.in);

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		int N = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		HashMap<String, String> list = new HashMap<String, String>();
		for (int NItr = 0; NItr < N; NItr++) {
			String[] firstNameEmailID = scanner.nextLine().split(" ");
			String name = firstNameEmailID[0];
			String email = firstNameEmailID[1];
			if (email.indexOf("@gmail.com") != -1) {
				list.put(email, name);
			}
		}
		LinkedHashMap<String, String> newList = sortHashMapByValues(list);
		Iterator<?> it = newList.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println(pair.getValue());
		}
		scanner.close();
	}

	static LinkedHashMap<String, String> sortHashMapByValues(HashMap<String, String> list) {
		List<String> mapKeys = new ArrayList<>(list.keySet());
		List<String> mapValues = new ArrayList<>(list.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys);

		LinkedHashMap<String, String> sortedMap = new LinkedHashMap<>();

		Iterator<String> valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			String val = valueIt.next();
			Iterator<String> keyIt = mapKeys.iterator();

			while (keyIt.hasNext()) {
				String key = keyIt.next();
				String comp1 = list.get(key);
				String comp2 = val;

				if (comp1.equals(comp2)) {
					keyIt.remove();
					sortedMap.put(key, val);
					break;
				}
			}
		}
		return sortedMap;
	}
}
