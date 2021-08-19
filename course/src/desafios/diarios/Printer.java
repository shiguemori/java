package desafios.diarios;

public class Printer<T> {

	public void printArray(T[] array) {
		for (T value : array) {
			System.out.println(value);
		}
	}
}
