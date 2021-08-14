package desafios.diarios;

import java.util.Scanner;

public class Day19 {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scan.nextInt();
		scan.close();

		AdvancedArithmetic myCalculator = new Calculator();
		int sum = myCalculator.divisorSum(n);
		System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
		System.out.println(sum);
	}
}
