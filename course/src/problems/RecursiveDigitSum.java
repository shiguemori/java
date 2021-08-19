package problems;

import java.util.*;
import java.util.stream.Collectors;

public class RecursiveDigitSum {

	// Melhor forma
    static int superDigit(String n, int k) {

        int sum = 0;
        for(int i = 0; i < n.length(); i++ ) {
            sum += (n.charAt(i) - '0');
            if(sum > 9) {
                sum -= 9;
            }
        }
        sum = sum * k;
        sum = sum % 9;
        if(sum == 0) {
            return 9;
        }
        return sum;
    }
    
	static String superDigit(String n, List<Integer> myList) {
		myList = Arrays.stream(n.split("")).map(Integer::parseInt).collect(Collectors.toList());
		n = myList.stream().reduce((c1, c2) -> c1 + c2).map(num -> Integer.toString(num)).get();
		myList.clear();
		if (n.length() > 1) {
			n = superDigit(n, myList);
		}
		return n;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] nk = scanner.nextLine().split(" ");
		String n = nk[0];
		int k = Integer.parseInt(nk[1]);

		String p = n;
		for (int i = 1; i < k; i++) {
			p = p + n;
		}

		List<Integer> myList = new ArrayList<Integer>();
		String result = superDigit(p, myList);
		System.out.println(result);

		scanner.close();
	}
}
