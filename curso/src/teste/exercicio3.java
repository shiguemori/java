package test;

import java.util.Scanner;

public class exercicio3 {

	public static String SearchingChallenge(String str) {
		if (str.indexOf("(") == -1) {
			return "1";
		}
		str = str.replace("/[A-Za-z0-9\s]/g", str);
		return str.equals("") ? "1" : "0";
	}

	public static void main(String[] args) {
		// keep this function call here
		Scanner s = new Scanner(System.in);
		System.out.println(SearchingChallenge("(coder)(byte))"));
		System.out.print(SearchingChallenge("(c(oder)) b(yte)"));
	}
}
