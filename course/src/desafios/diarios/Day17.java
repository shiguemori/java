package desafios.diarios;

import java.util.Scanner;

public class Day17 {
	
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {

		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int p = in.nextInt();
			Calculator myCalculator = new Calculator();
			try {
				int ans = myCalculator.power(n, p);
				System.out.println(ans);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		in.close();
	}
}
