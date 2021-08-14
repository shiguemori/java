package teste;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;

public class teste1 {
	static long howManySwaps(List<Integer> arr) {
        List<String> aux = Arrays.asList(arr.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "")
                .split(","));

		arr.sort(null);                 
		long count = 0;
		for (int i = 0; i < aux.size(); i++) 
		if(Integer.parseInt(aux.get(i)) == arr.get(arr.size()-1))
		    count = arr.size() - i - 1;        
		
		
		return count;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int arrCount = Integer.parseInt(sc.nextLine());
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
			try {
				return sc.nextLine().replaceAll("\\s+$", "");
			} catch (RuntimeException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		long result = howManySwaps(arr);
		System.out.println(result);

	}
}
