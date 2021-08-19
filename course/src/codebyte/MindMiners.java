package codebyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MindMiners {

	public static void recursiva(int i) {
		int result = (int) Math.pow(2, i);
		if (result <= 256) {
			System.out.println(result);
			recursiva(++i);
		}
	}

	public static String removeAcento(String s) {
		s = s.replaceAll("[èéêë]", "e");
		s = s.replaceAll("[ûù]", "u");
		s = s.replaceAll("[ïî]", "i");
		s = s.replaceAll("[àâ]", "a");
		s = s.replaceAll("Ô", "o");
		s = s.replaceAll("[ÈÉÊË]", "E");
		s = s.replaceAll("[ÛÙ]", "U");
		s = s.replaceAll("[ÏÎ]", "I");
		s = s.replaceAll("[ÀÂ]", "A");
		s = s.replaceAll("Ô", "O");
		return s;
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
		list.sort(Entry.comparingByValue());

		Map<K, V> result = new LinkedHashMap();
		for (Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}

	public static void frequencia(String text) {
		List<String> list = new ArrayList<String>();
		text = removeAcento(text);
		Pattern pt = Pattern.compile("[^a-zA-Z]");
		Matcher match = pt.matcher(text);
		while (match.find()) {
			String s = match.group();
			text = text.replaceAll("\\" + s, " ");
		}
		text = text.replaceAll("  ", " ");
		for (String string : text.split(" ")) {
			list.add(string.toLowerCase());
		}
		Map<String, Long> collect = list.stream().filter(s -> s.length() > 1)
				.collect(Collectors.groupingBy(numero -> numero, Collectors.counting()));
		for (Map.Entry<String, Long> entry : collect.entrySet()) {
			collect.put(entry.getKey(), entry.getValue() * -1);
		}
		collect = sortByValue(collect);
		for (Map.Entry<String, Long> entry : collect.entrySet()) {
			System.out.println(entry.getKey() + " : " + Math.abs(entry.getValue()));
		}
	}

	public static void main(String[] args) {
//		recursiva(1);
		frequencia("Um dois tres, vinte e quatro, vinte e cinco, trinta e três.");
	}
}
