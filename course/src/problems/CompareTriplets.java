package problems;

import java.util.*;

public class CompareTriplets {

	// Complete the compareTriplets function below.
	static void compareTriplets(List<Integer> a, List<Integer> b) {
		int pontosA = 0;
		int pontosB = 0;

		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == b.get(i)) {
				continue;
			}
			if (a.get(i) > b.get(i)) {
				pontosA++;
			}
			if (a.get(i) < b.get(i)) {
				pontosB++;
			}
		}

		System.out.println(pontosA + " " + pontosB);
	}

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			List<Integer> l1 = new ArrayList<Integer>();
			List<Integer> l2 = new ArrayList<Integer>();
			
			String[] n1 = scan.nextLine().split(" ");
			String[] n2 = scan.nextLine().split(" ");

			for (String string : n1) {
				l1.add(Integer.parseInt(string));
			}
			for (String string : n2) {
				l2.add(Integer.parseInt(string));
			}

			compareTriplets(l1, l2);
		}
	}

}
