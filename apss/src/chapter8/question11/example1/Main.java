package chapter8.question11.example1;

import java.util.Scanner;

public class Main {
	
	static class Tiling {
		
		public static final int MAX = 100;
		public static final int MOD = 1000000007;
		private int cache[] = new int[MAX + 1];
		
		public Tiling() {
			for (int i = 0; i < cache.length; i++) {
				cache[i] = -1;
			}
		}
		
		public int tiling(int width) {
			if (width <= 1) {
				return 1;
			}
			
			if (cache[width] != -1) {
				return cache[width];
			}
			
			int t2 = tiling(width-2);
			int t1 = tiling(width-1);
			
			if ((width - 2) >= 0) {
				cache[width-2] = t2;
			}
			if ((width - 1) >= 0) {
				cache[width-1] = t1;
			}
			
			return (t2 + t1) % MOD;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = Integer.parseInt(sc.nextLine());
		
		while (cases > 0) {
			int noTile = Integer.parseInt(sc.nextLine());
			System.out.println(new Tiling().tiling(noTile));
			cases--;
		}
		sc.close();
	}
}
