package chapter8.question11.tripathcnt;

import java.util.Scanner;

public class Main {
	
	public static final int MAX = 100;
	
	private static int[][] triangle = new int[MAX + 1][MAX + 1];
	private static int[][] cache = new int[MAX + 1][MAX + 1];
	private static int[][] countCache = new int[MAX + 1][MAX + 1];
	
	static class TriPathCnt {
		
		private int n;
		
		public TriPathCnt(int n) {
			this.n = n;
		}
		
		public int path(int y, int x) {
			if (y == n - 1) {
				return triangle[y][x];
			}
			int down = path(y+1, x);
			int rightDown = path(y+1, x+1);
			cache[y+1][x] = down;
			cache[y+1][x+1] = rightDown;
			return Math.max(down, rightDown) + triangle[y][x];
		}
		
		public int count(int y, int x) {
			if (y == n - 1) {
				return 1;
			}
			
			if (countCache[y][x] != -1) {
				return countCache[y][x];
			}
			int ret = 0;
			int rightDown = path(y+1, x+1);
			int down = path(y+1, x);
			if (rightDown >= down) {
				ret += count(y+1, x+1);
				countCache[y+1][x+1] = countCache[y][x] + 1;
			}
			if (rightDown <= down) {
				ret += count(y+1, x);
				countCache[y+1][x] = countCache[y][x] + 1;
			}
			
			return ret;
		}
	}
	
	public static void clearVariable() {
		for (int i = 0; i < MAX + 1; i++) {
			for (int j = 0; j < MAX + 1; j++) {
				triangle[i][j] = 0;
				countCache[i][j] = -1;
				cache[i][j] = -1;
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cases = Integer.parseInt(sc.nextLine());
//		System.out.println("Cases: " + cases);
		while (cases > 0) {
			clearVariable();
			int noLine = Integer.parseInt(sc.nextLine());
//			System.out.println("no Line: " + noLine);
			for (int i = 0; i < noLine; i++) {
				String[] line = sc.nextLine().split(" ");
//				System.out.println("each Line: " + Arrays.toString(line));
				for (int j = 0; j < line.length; j++) {
					triangle[i][j] = Integer.parseInt(line[j]);
				}
			}
			TriPathCnt tpc = new TriPathCnt(noLine);
			System.out.println(tpc.count(0, 0));
			cases--;
		}
		sc.close();
	}

}
