package chapter9.question2.packing;

import java.util.Stack;


public class Main {
	
	public static final int MAX = 100;
	
	private static String[] name = new String[MAX + 1];
	private static int[] volume = new int[MAX + 1];
	private static int[] need = new int[MAX + 1];
	private static int[][] cache = new int[MAX + 1][MAX + 1];
	
	
	static class Packing {
		
		private int n;
		
		public int pack(int capacity, int item) {
			if (item == n) {
				return 0;
			}
			
			if (cache[capacity][item] != -1) {
				return cache[capacity][item];
			}
			
			int nPick = pack(capacity, item + 1);
			
			if (item < n) {
				cache[capacity][item + 1] = nPick;
			}
			
			int pick = 0;
			if (capacity >= volume[item]) {
				pick = pack(capacity - volume[item], item + 1) + need[item];
				if (item < n) {
					int c = cache[capacity - volume[item]][item + 1];
					cache[capacity - volume[item]][item + 1] = c == 1 ? pick : Math.min(pick, c);
				}
			}
			return Math.max(pick, nPick);
		}
		
		public void reconstruct(int capacity, int item, Stack<String> needStack) {
			if (item == n) return;
			
			if (pack(capacity, item) == pack(capacity, item + 1)) {
				reconstruct(capacity, item, needStack);
			} else {
				needStack.push(name[item]);
				reconstruct(capacity - volume[item], item + 1, needStack);
			}
		}
	}
	
	public static void clearVariables() {
		for (int i = 0; i < MAX + 1; i++) {
			name[i] = "";
			volume[i] = 0;
			need[i] = 0;
			for (int j = 0; j < MAX + 1; j++) {
				cache[i][j] = -1;
			}
		}
	}

	public static void main(String[] args) {
		clearVariables();
		Packing p = new Packing();
		p.n = 6;
		name = new String[]{"laptop", "camera", "xbox", "grinder", "dumbell", "encyclopedia"};
		volume = new int[]{ 4, 2, 6, 4, 2, 10};
		need = new int[]{7, 10, 6, 7, 5, 4};
		Stack<String> s = new Stack<String>();
		System.out.println(p.pack(10, 0));
		p.reconstruct(10, 0, s);
		System.out.println(s);
	}

}
