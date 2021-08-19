package problems;

import java.io.*;
import java.util.*;

public class StringSimilarity {

	static void stringSimilarity(String str) {
		long c = str.length();
		int L = 0, R = 0, n = str.length();
		char[] s = str.toCharArray();
		int[] z = new int[n];
		for (int i = 1; i < n; i++) {
			if (i > R) {
				L = R = i;
				while (R < n && s[R - L] == s[R])
					R++;
				z[i] = R - L;
				R--;
				c += z[i];
			} else {
				int k = i - L;
				if (z[k] < R - i + 1) {
					z[i] = z[k];
					c += z[i];
				} else {
					L = i;
					while (R < n && s[R - L] == s[R])
						R++;
					z[i] = R - L;
					c += z[i];
					R--;
				}
			}
		}
		System.out.println(c);
	}
	
	static void stringSimilarity(List<String> list) {
		for (String s : list) {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				String aux = s.substring(i, s.length());
				if (s.startsWith(aux)) {
					count += aux.length();
					continue;
				}
				if (s.charAt(0) != aux.charAt(0)) {
					continue;
				}
				for (int j = 1; j < aux.length(); j++) {
					String aux2 = aux.substring(0, aux.length() - j);
					if (s.startsWith(aux2)) {
						count += aux2.length();
						break;
					}
				}
			}
			System.out.println(count);
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);

		int t = in.nextInt();
		in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		List<String> list = new ArrayList<String>();
		for (int tItr = 0; tItr < t; tItr++) {
			list.add(in.nextLine());
			stringSimilarity(in.nextLine());
		}
//		stringSimilarity(list);
		in.close();
	}

}
