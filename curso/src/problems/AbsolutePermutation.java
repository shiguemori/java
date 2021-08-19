package problems;

import java.util.*;

public class AbsolutePermutation {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			for (int a0 = 0; a0 < t; a0++) {
				int n = in.nextInt();
				int k = in.nextInt();
				boolean flag = false;
				boolean[] b = new boolean[n + 1];
				String ans = "";
				for (int i = 1; i <= n; i++) {
					int x = i + k;
					int y = i - k;
					if (y > 0 && y <= n && b[y] == false) {
						ans += y + " ";
						b[y] = true;
					} else if (x > 0 && x <= n && b[x] == false) {
						ans += x + " ";
						b[x] = true;
					} else {
						flag = true;
						break;
					}
				}
				if (!flag) {
					System.out.println(ans);
				} else {
					System.out.println(-1);
				}
			}
		}
	}

}
