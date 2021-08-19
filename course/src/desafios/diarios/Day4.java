package desafios.diarios;

import java.util.*;

public class Day4 {

	static void amIOld(int age) {
		String retorno = "";
		if (age < 13) {
			retorno = "You are young.";
		} else if (age >= 13 && age < 18) {
			retorno = "You are a teenager.";
		} else {
			retorno = "You are old.";
		}
		System.out.println(retorno);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int age = sc.nextInt();
			if (age < 0) {
				System.out.println("Age is not valid, setting age to 0.");
				age = 0;
			}
			for (int j = 0; j < 3; j++) {
				age++;
			}
			amIOld(age);
		}
		sc.close();
	}
}
