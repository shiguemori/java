package problems;

import java.util.*;

public class GradingStudents {

	public static void gradingStudents(List<Integer> grades) {

		List<Integer> finalgrades = new ArrayList<Integer>();
		for (Integer grade : grades) {
			if (grade < 38) {
				finalgrades.add(grade);
				continue;
			}
			if (grade % 5 > 2) {
				finalgrades.add(((grade / 5) + 1) * 5);
			} else {
				finalgrades.add(grade);
			}
		}

		for (Integer val : finalgrades) {
			System.out.println(val);
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int gradesCount = scanner.nextInt();

		List<Integer> grades = new ArrayList<Integer>();
		for (int i = 0; i < gradesCount; i++) {
			grades.add(scanner.nextInt());
		}

		gradingStudents(grades);
	}
}
