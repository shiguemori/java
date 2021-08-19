/**
 * 
 */
package stream;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author Shiguemori
 *
 */
public class CriandoStreams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Consumer<String> print = System.out::println;

		Stream<String> langs = Stream.of("Java", "Lua", "JS");
		langs.forEach(print);

		String[] maisLangs = { "Python", "PHP", "C#" };
		Stream.of(maisLangs).forEach(print);

	}

}
