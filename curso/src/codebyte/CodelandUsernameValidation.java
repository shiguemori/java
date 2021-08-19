package codebyte;

import java.util.*;

public class CodelandUsernameValidation {

	public static String CodelandUsernameValidation(String str) {
		return (str.length() >= 4 && str.length() <= 25) && str.matches("[a-zA-Z][a-zA-Z0-9_]*") && !str.endsWith("_")
				? "true"
				: "false";
	}

	public static void main(String[] args) {
		// keep this function call here
		Scanner s = new Scanner(System.in);
		System.out.print(CodelandUsernameValidation(s.nextLine()));
	}
}
