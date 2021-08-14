package desafios.diarios;

import java.util.Scanner;

public class Day16 {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
        String s = in.next();
        try {
            System.out.println(Integer.parseInt(s));
        } catch (Exception e) {
            System.out.println("Bad String");
        }
	}
}
