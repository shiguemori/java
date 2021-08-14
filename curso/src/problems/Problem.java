package problems;

import java.util.*;

@SuppressWarnings("resource")

public class Problem {

	public static void main(String[] args) {
		System.out.println("Starting program");
		System.out.println("Select the problem you want to see");
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt();
		while (op != -1) {
			System.out.println();
			System.out.println("Starting problem : " + op);
			System.out.println();
			select(op);
			System.out.println();
			System.out.println("Problem finished");
			System.out.println();
			System.out.println("If you want to finish insert -1");
			op = scan.nextInt();
		}
		System.out.println("Stopping program");
		scan.close();
	}

	public static void select(int op) {
		switch (op) {
		case 1:
			problem1();
			break;
		case 2:
			problem2();
			break;
		case 3:
			problem3();
			break;
		case 4:
			problem4();
			break;
		case 5:
			problem5();
			break;
		case 6:
			problem6();
			break;
		case 7:
			problem7();
			break;
		case 8:
			problem8();
			break;
		case 9:
			problem9();
			break;
		case 10:
			problem10();
			break;
		case 11:
			problem11();
			break;
		case 12:
			problem12();
			break;
		case 13:
			problem13();
			break;
		case 14:
			problem14();
			break;
		case 15:
			problem15();
			break;
		case 16:
			problem16();
			break;
		case 17:
			problem17();
			break;
		case 18:
			problem18();
			break;
		case 19:
			problem19();
			break;
		default:
			break;
		}
	}

	public static void problem19() {
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			arr1.add(rand.nextInt(25));
			arr2.add(rand.nextInt(25));
		}

		System.out.println("Original first array : " + arr1.toString());
		System.out.println("Original second array : " + arr2.toString());

		arr3 = arr2;
		arr2 = arr1;
		arr1 = arr3;

		System.out.println("Modified first array : " + arr1.toString());
		System.out.println("Modified second array : " + arr2.toString());
	}

	public static void problem18() {

		Scanner scan = new Scanner(System.in);
		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();

		System.out.println("Populate the array :");
		for (int i = 0; i < 10; i++) {
			arr1.add(scan.next());
		}

		for (String ch : arr1) {
			if (ch.equalsIgnoreCase("a") || ch.equalsIgnoreCase("e") || ch.equalsIgnoreCase("i")
					|| ch.equalsIgnoreCase("o") || ch.equalsIgnoreCase("u")) {
				arr2.add(ch);
			}
		}

		System.out.println("The number of vowels is : " + arr2.size());
		System.out.println(arr2.toString());
	}

	public static void problem17() {

		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		ArrayList<Integer> arr3 = new ArrayList<Integer>();

		System.out.println("Populate the first array :");
		for (int i = 0; i < 10; i++) {
			arr1.add(scan.nextInt());
		}
		System.out.println("Populate the second array :");
		for (int i = 0; i < 10; i++) {
			arr2.add(scan.nextInt());
		}

		for (int i = 0; i < arr1.size(); i++) {
			if (arr2.contains(arr1.get(i))) {
				if (!arr3.contains(arr1.get(i))) {
					arr3.add(arr1.get(i));
				}
			}
		}

		System.out.println("The intersection of both array is  : " + arr3.toString());
		
	}

	public static void problem16() {

		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();

		System.out.println("Input the values");
		for (int i = 0; i < 10; i++) {
			arr.add(scan.nextInt());
		}

		System.out.print("Num 1 : ");
		int a = scan.nextInt();
		System.out.print("Num 2 : ");
		int b = scan.nextInt();

		int indexA = arr.indexOf(a);
		int indexB = arr.indexOf(b);
		if (indexA != -1 && indexB != -1) {

			arr.remove(indexA);
			arr.add(indexA, b);

			arr.remove(indexB);
			arr.add(indexB, a);

		} else {
			System.out.println("The substitution was not possible");
		}

		System.out.println("The array is  : " + arr.toString());
		
	}

	public static void problem15() {

		ArrayList<Integer> a1 = new ArrayList<Integer>();
		Random rand = new Random();
		int count = 0;
		while (a1.size() < 50) {
			int r = rand.nextInt(30);
			a1.add(r);
		}

		System.out.print("Search :");
		Scanner scan = new Scanner(System.in);
		int search = scan.nextInt();

		System.out.println(a1.toString());
		if (a1.contains(search)) {
			System.out.print("The number " + search + " was found in index : ");
			for (int i = 0; i < a1.size(); i++) {
				if (a1.get(i) == search) {
					System.out.print(i + " ");
					count++;
				}
			}
			System.out.println();
			System.out.print("The number index that number was found was " + count);
		} else {
			System.out.print("The number " + search + " was not found");
		}

		
	}

	public static void problem14() {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		Random rand = new Random();

		while (a1.size() < 10) {
			int r = rand.nextInt(30);
			if (!a1.contains(r)) {
				a1.add(r);
			}
		}

		a1.sort(null);

		System.out.println("My second lowest value is " + a1.get(1));
		System.out.println("My second largest value is " + a1.get(8));
		System.out.println("My random array is " + a1.toString());

	}

	public static void problem13() {

		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		ArrayList<Integer> a3 = new ArrayList<Integer>();

		for (int i = 1; i <= 10; i++) {
			a1.add(i);
			a2.add(i + 10);
		}

		for (int i = 0; i < a1.size(); i++) {
			a3.add(a1.get(i));
			a3.add(a2.get(i));
		}

		System.out.println("My first array : " + a1.toString());
		System.out.println("My second array : " + a2.toString());
		System.out.println("My third array : " + a3.toString());
	}

	public static void problem12() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Number : ");
		int qtd = scan.nextInt();

		while (qtd <= 0) {
			System.out.print("input a number bigger then 0 : ");
			qtd = scan.nextInt();
		}

		boolean isPrime = true;
		int count = 1;
		int countPrime = 0;
		int sum = 0;

		System.out.print("The prime numbers are ");
		while (countPrime < qtd) {
			isPrime = true;
			count++;
			for (int j = 2; j < count; j++) {
				if (count % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime && count >= 2) {
				System.out.print(count + " ");
				sum += count;
				countPrime++;
			}
		}

		System.out.println();
		System.out.println("The sum is : " + sum);
		
	}

	public static void problem11() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Number : ");
		int number = scan.nextInt();
		int count = 0, large = 0;
		boolean isPrime = true;

		System.out.print("Prime numbers :  ");
		for (int i = 1; i < number; i++) {
			isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime && i >= 2) {
				count++;
				large = i;
				System.out.print(i + " ");
				isPrime = false;
			}
		}

		System.out.println();
		System.out.println("Qtd : " + count + " and the largest : " + large);
		
	}

	public static void problem10() {

		Scanner scan = new Scanner(System.in);
		System.out.print("Number 1: ");
		int n1 = scan.nextInt();
		System.out.print("Number 2: ");
		int n2 = scan.nextInt();
		int sum = 0;
		int mult = 1;

		if (n1 < n2) {
			for (int i = n1 + 1; i < n2; i++) {
				sum = sum + i;
				mult = mult * i;
			}
		} else {
			for (int i = n2 + 1; i < n1; i++) {
				sum = sum + i;
				mult = mult * i;
			}
		}

		System.out.println("The sum between the numbers " + n1 + " and " + n2 + " is: " + sum);
		System.out.println("Mutiplication : " + mult);
		

	}

	public static void problem9() {

		Scanner scan = new Scanner(System.in);
		System.out.print("Number : ");
		int number = scan.nextInt();
		int result = 1;
		int q = number / 10;

		do {
			q = q / 10;
			result++;
		} while (q != 0);
		System.out.println(result);

		System.out.print("Number 2: ");
		Integer num = scan.nextInt();
		System.out.println(num.toString().length());
		
	}

	public static void problem8() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Number : ");
		int number = scan.nextInt();
		boolean isPrime = true;

		for (int i = 2; i < number / 2; i++) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}

		if (isPrime) {
			System.out.println(number + " is prime");
		} else {
			System.out.println(number + " is not prime");
		}
		
	}

	public static void problem7() {

		// Dollar pyramid
		for (int i = 6; i >= 1; i--) {
			// empty triangle
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 6; j >= i; j--) {
				System.out.print("$");
			}
			for (int j = 6; j >= i; j--) {
				System.out.print("$");
			}
			System.out.println();
		}

		System.out.println("      #");
		for (int i = 6; i >= 1; i--) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			System.out.print("#");
			for (int j = 6; j >= i; j--) {
				System.out.print(" ");
			}
			for (int j = 6; j >= i; j--) {
				System.out.print(" ");
			}
			System.out.println("#");
		}
		System.out.println("# # # # # # # #");

		System.out.println("      @");
		for (int i = 6; i >= 1; i--) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			System.out.print("@");
			for (int j = 6; j >= i; j--) {
				System.out.print(" ");
			}
			for (int j = 6; j >= i; j--) {
				System.out.print(" ");
			}
			System.out.println("@");
		}

		for (int i = 6; i >= 1; i--) {
			for (int j = 6; j > i; j--) {
				System.out.print(" ");
			}
			System.out.print("@");
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			System.out.println("@");
		}
		System.out.println("      @");

	}

	public static void problem6() {
		int even = 0, odd = 1;
		for (int i = 1; i <= 20; i += 2) {
			odd = odd * i;
		}

		for (int i = 2; i <= 100; i += 2) {
			even = even + i;
		}

		System.out.println("Even : " + even);
		System.out.println("Odd : " + odd);
	}

	public static void problem5() {
		Scanner scan = new Scanner(System.in);

		System.out.print("Base : ");
		int base = scan.nextInt();

		System.out.print("Exponent : ");
		int exponent = scan.nextInt();

		System.out.println(Math.pow(base, exponent));
		
	}

	public static void problem4() {
		Scanner scan = new Scanner(System.in);
		int i = 2, small = 0, large = 0;
		System.out.print("Num 1: ");
		int a = scan.nextInt();
		small = a;
		large = a;

		while (i <= 10) {
			System.out.print("Num " + i + ": ");
			int b = scan.nextInt();

			if (b < small) {
				small = i;
			}

			if (large < b) {
				large = b;
			}

			i++;
		}

		System.out.println("Smallest :" + small);
		System.out.println("Largest :" + large);
		
	}

	public static void problem3() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Insert rows ");
		int rows = scan.nextInt();
		while (rows <= 0) {
			System.out.println("Insert rows ");
			rows = scan.nextInt();
		}

		System.out.println("Insert cols ");
		int cols = scan.nextInt();
		while (cols <= 0) {
			System.out.println("Insert cols ");
			cols = scan.nextInt();
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print("B ");
			}
			System.out.println();
		}
	}

	public static void problem2() {

		for (int a = 1, b = 10, c = 11, d = 20, e = 21, f = 30; a <= 10; a++, b--, c++, d--, e++, f--) {
			System.out.println(a + "\t" + b + "\t" + c + "\t" + d + "\t" + e + "\t" + f);
		}
	}

	public static void problem1() {

		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			for (int k = 6; k > i; k--) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();
		for (int i = 6; i >= 1; i--) {
			for (int j = 1; j < i; j++) {
				System.out.print(j);
			}
			for (int k = 6; k >= i; k--) {
				System.out.print("&");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("@");
		for (int i = 5; i >= 1; i--) {
			System.out.print("@");
			for (int j = 5; j >= i; j--) {
				System.out.print(" ");
			}
			System.out.print("@");
			System.out.println();
		}
		System.out.println("@ @ @ @ @");
	}

}
