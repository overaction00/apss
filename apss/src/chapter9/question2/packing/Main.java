package chapter9.question2.packing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static final int MAX = 100;
	public static final int NEED_MAX = 1000;
	
	private static String[] name = new String[MAX + 1];
	private static int[] volume = new int[MAX + 1];
	private static int[] need = new int[MAX + 1];
	private static int[][] cache = new int[NEED_MAX + 1][MAX + 1];
	static class Packing {
		
		private int n;
		
		public Packing(int n) {
			this.n = n;
		}
		
		public int pack(int capacity, int item) {
			if (item == n) {
				return 0;
			}
			
			if ( cache[capacity][item] != -1) {
				return cache[capacity][item];
			}
			
			int pick = 0;
			int nPick = 0;
			// 물건을 가져가는 경우 (pick)
			if ( capacity >= volume[item] ) {
				pick = pack(capacity - volume[item], item + 1) + need[item];
			}
			
			// 물건을 가져가지 않는 경우 (nPick)
			nPick = pack(capacity, item + 1);
			
			// 두가지 경우에 대해서 더 만족도가 큰 경우를 판단
			int max = Math.max(pick, nPick);
			cache[capacity][item] = max;
			return max;
		}
		
		public void reconstruct(int capacity, int item, List<String> picked) {
			if (item == n) {
				return;
			}
			
			if (pack(capacity, item) == pack(capacity, item + 1)) {
				reconstruct(capacity, item + 1, picked);
			} else {
				picked.add(name[item]);
				reconstruct(capacity - volume[item], item + 1, picked);
			}
		}
	}
	
	public static void clearVariables() {
		for (int i = 0; i < MAX + 1; i++) {
			name[i] = "";
			volume[i] = -1;
			need[i] = -1;
		}
		for (int i = 0; i < NEED_MAX + 1; i++) {
			for (int j = 0; j < MAX + 1; j++) {
				cache[i][j] = -1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("/Users/worms/git/apss/apss/src/chapter9/question2/packing/input.txt"));
		int testCases = Integer.parseInt(sc.nextLine());
		while (testCases-- > 0) {
			clearVariables();
			String[] arr = sc.nextLine().split(" ");
			int noItems = Integer.parseInt(arr[0]);
			int capacity = Integer.parseInt(arr[1]);
			for (int i = 0; i < noItems; i++) {
				arr = sc.nextLine().split(" ");
				name[i] = arr[0];
				volume[i] = Integer.parseInt(arr[1]);
				need[i] = Integer.parseInt(arr[2]);
			}
			Packing p = new Packing(noItems);
			int maxSatisfied = p.pack(capacity, 0);
			List<String> picked = new ArrayList<String>();
			p.reconstruct(capacity, 0, picked);
			System.out.println(maxSatisfied + " " + picked.size());
			for (String item : picked) {
				System.out.println(item);
			}
		
		}
		sc.close();
	}
}
