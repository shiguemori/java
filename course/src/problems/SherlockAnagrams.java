package problems;

import java.util.*;

public class SherlockAnagrams {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = in.nextInt();
		in.nextLine();
		for (int i = 0; i < testCases; i++) {
			String text = in.nextLine();
			ArrayList<String> list = new ArrayList<>();
			int len = text.length();
			int counter = 0;
			for (int j = 0; j < len; j++) {
				for (int sub = 1; sub <= len - j; sub++) {
					String subPart = text.substring(j, j + sub);
					list.add(subPart);
				}
			}
			for (int j = 0; j < list.size(); j++) {
				String element = list.get(j);
				for (int k = j + 1; k < list.size(); k++) {
					if (isAnagram(list.get(k), element)) {
						counter++;
					}
				}
			}
			System.out.println(counter);
		}
	}

	public static boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		int[] lettermap = new int[26];
		for (int j = 0; j < a.length(); j++) {
			char ch = a.charAt(j);
			lettermap[ch - 'a']++;
			ch = b.charAt(j);
			lettermap[ch - 'a']--;
		}
		
		for (int j = 0; j < lettermap.length; j++) {
			if (lettermap[j] != 0) {
				return false;
			}
		}
		return true;
	}

}
