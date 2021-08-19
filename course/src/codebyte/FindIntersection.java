package codebyte;

import java.util.*;

public class FindIntersection {

	public static String findIntersection(String[] strArr) {

		String[] list = strArr[0].split(", ");
		String[] list2 = strArr[1].split(", ");

		List<Integer> result = new ArrayList<Integer>();
		for (String string : list) {
			for (String string2 : list2) {
				if (string.equals(string2)) {
					result.add(Integer.parseInt(string));
					break;
				}
			}
		}
		result.sort(null);
		return result.size() > 0 ? result.toString().replace(", ", ",").replace("[", "").replace("]", "") : "false";
	}

	public static void main(String[] args) {
		// keep this function call here
		Scanner s = new Scanner(System.in);
		System.out.print(findIntersection(new String[] {"5, 6, 9, 11, 12, 16", "4, 6, 7, 11, 16"}));
	}
}
