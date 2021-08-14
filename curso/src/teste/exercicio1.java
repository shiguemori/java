package teste;

import java.util.Arrays;
import java.util.Scanner;

public class exercicio1 {

	public static int ArrayChallenge(int[] arr) {
		Arrays.sort(arr);
		return (arr[arr.length - 1] - arr[0]) - 2;
	}

	public static void main(String[] args) {
		// keep this function call here
		Scanner s = new Scanner(System.in);
		System.out.print(ArrayChallenge(new int[] { 5, 10, 15 }));
	}
}
