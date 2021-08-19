package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

	/**
	 * @param sides
	 * @return
	 */
	public static long nearlySimilarRectangles(List<List<Long>> sides) {
		double[] mod = {};
		sides.forEach(lista -> {

			lista.forEach(val -> {
				System.out.println(val);
			});
		});
		return 0;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int sidesRows = Integer.parseInt(bufferedReader.readLine().trim());
		int sidesColumns = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Long>> sides = new ArrayList<>();

		IntStream.range(0, sidesRows).forEach(i -> {
			try {
				sides.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong)
						.collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		long result = nearlySimilarRectangles(sides);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
