package problems;

import java.util.*;

public class QueenAttack {

	static void queensAttack(int n, int k, int rowQueen, int colQueen, int[][] obstacles) {

		// u = numero de lados do board menos a posicao da linha da rainha
		int u = n - rowQueen;
		// d = posicao da linha da rainha menos 1
		int d = rowQueen - 1;
		// r = numero de lados do board menos posicao da coluna da rainha
		int r = n - colQueen;
		// l = coluna da rainha menos 1
		int l = colQueen - 1;
		// ru = Menor valor entre "u" ou "r"
		int ru = Math.min(u, r);
		// rd = Menor valor entre "r" ou "d"
		int rd = Math.min(r, d);
		// lu = Menor valor entre "l" ou "u"
		int lu = Math.min(l, u);
		// ld = Menor valor entre "l" ou "d"
		int ld = Math.min(l, d);

		for (int[] o : obstacles) {
			// Verifica se o obstaculo esta na mesma coluna q a rainha
			if (o[1] == colQueen) {
				// Verifica se a posicao do obstaculo e menor q a da rainha na linha
				if (o[0] < rowQueen) {
					d = Math.min(d, rowQueen - 1 - o[0]);
				} else {
					u = Math.min(u, o[0] - rowQueen - 1);
				}
			} else if (o[0] == rowQueen) { // Verifica se o obstaculo esta na mesma linha q a rainha
				if (o[1] < colQueen) {
					l = Math.min(l, colQueen - 1 - o[1]);
				} else {
					r = Math.min(r, o[1] - colQueen - 1);
				}
			} else if (Math.abs(o[0] - rowQueen) == Math.abs(o[1] - colQueen)) { 
				if (o[1] > colQueen) {
					if (o[0] > rowQueen) {
						ru = Math.min(ru, o[1] - colQueen - 1);
					} else {
						rd = Math.min(rd, o[1] - colQueen - 1);
					}
				} else {
					if (o[0] > rowQueen) {
						lu = Math.min(lu, colQueen - 1 - o[1]);
					} else {
						ld = Math.min(ld, colQueen - 1 - o[1]);
					}
				}
			}
		}

		int sum = u + d + r + l + ru + rd + lu + ld;
		System.out.println(sum);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] nk = scanner.nextLine().split(" ");

		int board = Integer.parseInt(nk[0]);

		int numberObstacles = Integer.parseInt(nk[1]);

		String[] queenPosition = scanner.nextLine().split(" ");

		int eixoX = Integer.parseInt(queenPosition[0]);

		int eixoY = Integer.parseInt(queenPosition[1]);

		int[][] obstacles = new int[numberObstacles][2];

		for (int i = 0; i < numberObstacles; i++) {
			String[] obstaclesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			for (int j = 0; j < 2; j++) {
				int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
				obstacles[i][j] = obstaclesItem;
			}
		}

		queensAttack(board, numberObstacles, eixoX, eixoY, obstacles);

		scanner.close();
	}
}
