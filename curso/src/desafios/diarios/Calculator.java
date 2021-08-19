package desafios.diarios;

public class Calculator implements AdvancedArithmetic {

	public int power(int n, int p) throws Exception {
		if (n < 0 || p < 0) {
			throw new Exception("n and p should be non-negative");

		}
		return (int) Math.pow(n, p);
	}

	@Override
	public int divisorSum(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				sum = sum + i;
			}
		}
		return sum;
	}

}
