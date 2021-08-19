package desafios.diarios;

import java.util.*;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;

	// Constructor
	Person(String firstName, String lastName, int identification) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}

	// Print person data
	public void printPerson() {
		System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber);
	}

}

class Student extends Person {

	private int[] testScores;

	/*
	 * Class Constructor
	 * 
	 * @param firstName - A string denoting the Person's first name.
	 * 
	 * @param lastName - A string denoting the Person's last name.
	 * 
	 * @param id - An integer denoting the Person's ID number.
	 * 
	 * @param scores - An array of integers denoting the Person's test scores.
	 */
	Student(String firstName, String lastName, int identification, int[] testScores) {
		super(firstName, lastName, identification);
		this.setTestScores(testScores);
	}

	public int[] getTestScores() {
		return testScores;
	}

	public void setTestScores(int[] testScores) {
		this.testScores = testScores;
	}

	/*
	 * Method Name: calculate
	 * 
	 * @return A character denoting the grade.
	 */
	public char calculate() {

		int soma = 0;
		for (int i = 0; i < this.getTestScores().length; i++) {
			soma = soma + this.getTestScores()[i];
		}

		double media = soma / this.getTestScores().length;

		if (media >= 90) {
			return 'O';
		} else if (media < 90 && media >= 80) {
			return 'E';
		} else if (media < 80 && media >= 70) {
			return 'A';
		} else if (media < 70 && media >= 55) {
			return 'P';
		} else if (media < 55 && media >= 40) {
			return 'D';
		} else {
			return 'T';
		}
	}
}

public class Day12 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for (int i = 0; i < numScores; i++) {
			testScores[i] = scan.nextInt();
		}
		scan.close();

		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate());
	}
}