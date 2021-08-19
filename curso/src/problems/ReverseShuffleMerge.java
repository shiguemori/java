package problems;

import java.util.*;

public class ReverseShuffleMerge {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String s = scanner.nextLine();
		String result = reverseShuffleMerge(s);
		System.out.println(result);
	}

	static String reverseShuffleMerge(String s) {
		String word = "";
		int length = s.length() / 2;
		SortedMap<Character, Integer> letterMap = new TreeMap<>();
		for (char c : s.toCharArray()) {
			Integer cnt = letterMap.get(c);
			if (cnt == null) {
				cnt = 0;
			}
			letterMap.put(c, cnt + 1);
		}
		int[] lettersForShuffle = new int[26];
		for (Map.Entry<Character, Integer> entry : letterMap.entrySet()) {
			lettersForShuffle[entry.getKey() - 'a'] = entry.getValue() / 2;
		}
		int[] lettersForWord = Arrays.copyOf(lettersForShuffle, lettersForShuffle.length);
		int index = s.length() - 1;
		int minIndex = s.length() - 1;

		int[] tmpLetters = Arrays.copyOf(lettersForShuffle, lettersForShuffle.length);
		while (index >= 0) {
			char ci = s.charAt(index);
			if ((minIndex == -1 || ci < s.charAt(minIndex)) && lettersForWord[ci - 'a'] > 0) {
				minIndex = index;
				tmpLetters = Arrays.copyOf(lettersForShuffle, lettersForShuffle.length);
			}
			index--;
			if (lettersForShuffle[ci - 'a'] == 0) {
				char minChar = s.charAt(minIndex);
				word += minChar;
				lettersForWord[minChar - 'a']--;
				if (word.length() == length) {
					return word;
				}
				s = s.substring(0, minIndex);
				lettersForShuffle = Arrays.copyOf(tmpLetters, tmpLetters.length);
				index = s.length() - 1;
				minIndex = -1;
			} else {
				lettersForShuffle[ci - 'a']--;
			}

		}
		return word;
	}

}
