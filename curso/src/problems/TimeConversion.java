package problems;

import java.util.*;

public class TimeConversion {
	static void timeConversion(String s) {
		String[] horario = new String[3];
		if (s.indexOf("PM") == -1) {
			horario = s.replace("AM", "").split(":");
			int horarioInteiro = Integer.parseInt(horario[0]);
			if (horarioInteiro >= 12) {
				horario[0] = "" + (Integer.parseInt(horario[0]) - 12);
			}
		} else {
			horario = s.replace("PM", "").split(":");
			int horarioInteiro = Integer.parseInt(horario[0]);
			if (horarioInteiro < 12) {
				horario[0] = "" + (Integer.parseInt(horario[0]) + 12);
			}
		}
		System.out.println((horario[0].equals("0") ? "00" : horario[0]) + ":" + horario[1] + ":" + horario[2]);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String s = scanner.nextLine();
		timeConversion(s);
	}
}
