import java.util.*;

public class MainGane {

	public static void main(String[] args) {
		System.out.println("Welcome");

//		Random rand = new Random();
//		int theSecretNumber = rand.nextInt(10);
//		int yourGuess = 0;
//
//		Scanner scan = new Scanner(System.in);
//
//		while (yourGuess != theSecretNumber) {
//			yourGuess = scan.nextInt();
//			if (yourGuess < theSecretNumber) {
//				System.out.println("To low");
//			}
//			if (yourGuess > theSecretNumber) {
//				System.out.println("To large");
//			}
//		}
//		System.out.println("U got it");
//
//		for (int i = 0; i < 10; i++) {
//			System.out.print(i + " ");
//		}
//		System.out.print("\n--------------------\n");
//
//		for (int i = 0; i < 30; i++) {
//			System.out.print(i + " ");
//		}
//		System.out.print("\n--------------------\n");
//		int[] luckNumbers = { 13, 14, 19, 29, 34, 98 };
//
//		for (int i = 0; i < luckNumbers.length; i++) {
//			System.out.print(luckNumbers[i] + " ");
//		}
//		System.out.print("\n----------------------------\nLuckNumbers ");
//
//		for (int number : luckNumbers) {
//			System.out.print(number + " ");
//		}
//
//		ArrayList<Integer> unlyckyNumbers = new ArrayList<>();
//
//		unlyckyNumbers.add(7);
//		unlyckyNumbers.add(17);
//		unlyckyNumbers.add(37);
//		unlyckyNumbers.add(77);
//		unlyckyNumbers.add(79);
//
//		for (int i = 0; i < unlyckyNumbers.size(); i++) {
//			System.out.print(unlyckyNumbers.get(i) + " ");
//		}
//
//		System.out.print("\n----------------------------\nUnlyckyNumbers ");
//
//		for (int number : unlyckyNumbers) {
//			System.out.print(number + " ");
//		}

		Rock r1 = new Rock();
		Rock r2 = new Rock("Red", 88.4f);
		Rock r3 = new Rock("Green", 23.3f);
		Rock r4 = new Rock("Grey", 5.2f);

		ArrayList<Rock> allRocks = new ArrayList<Rock>();
		allRocks.add(r1);
		allRocks.add(r2);
		allRocks.add(r3);
		allRocks.add(r4);

		ArrayList<Rock> someRocks = new ArrayList<Rock>();
		someRocks.add(r1);
		someRocks.add(r2);

		CaveMan caveMan1 = new CaveMan();
		caveMan1.setRockCollection(someRocks);

		CaveMan caveMan2 = new CaveMan("Vini", 25, 104f, allRocks);

		caveMan1.sayHi();
		caveMan2.sayHi();

		System.out.println(caveMan1);
		System.out.println(caveMan2);

		for (Rock rock : someRocks) {
			System.out.println("Some rocks " + rock);
		}
		for (Iterator<Rock> iterator = allRocks.iterator(); iterator.hasNext();) {
			Rock rock = (Rock) iterator.next();
			System.out.println(rock);
		}

	}

}
