package chapter10.question2.lunchbox;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static final int MAX = 10000;
	private static int[] E = new int[MAX];
	private static int[] M = new int[MAX];
	
	static class Pair<First extends Comparable<First>, Second extends Comparable<Second>> implements Comparable<Pair<First, Second>> {
		public First first;
		public Second second;
		
		public Pair(First first, Second second) {
			this.first = first;
			this.second = second;
		}
		
		@Override
		public int hashCode() {
			return (first.hashCode() ^ second.hashCode()) * 31;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == this) {
				return true;
			}
			if ((o instanceof Pair) == false) {
				return false;
			}
			final Pair<First, Second> pair = (Pair<First, Second>)o;
			if (this.first.equals(pair.first)) {
				return this.second.equals(pair.second);
			}
			return false;
		}

		@Override
		public int compareTo(Pair<First, Second> o) {
			int ret = this.first.compareTo(o.first);
			if (ret == 0) {
				ret = this.second.compareTo(o.second);
			}
			return ret;
		}
		
	}
	static class LunchBox {
		private int noLunchBox;
		private String[] waveTimeArray;
		private String[] eatTimeArray;
		public LunchBox(int noLunchBox, String[] w, String[] e) {
			this.noLunchBox = noLunchBox;
			this.waveTimeArray = w;
			this.eatTimeArray = e;
		}
		private int heat() {
			List<Pair<Integer, Integer>> order = new ArrayList<Pair<Integer, Integer>>();
			for (int i = 0; i < noLunchBox; i++) {
				int microwave = Integer.parseInt(waveTimeArray[i]);
				int eat = Integer.parseInt(eatTimeArray[i]);
				M[i] = microwave;
				E[i] = eat;
				order.add(new Pair<Integer, Integer>(-eat, i));
			}
			Collections.sort(order);
			int ret = 0, beginEat = 0;
			for(int i = 0; i < noLunchBox; i++) {
				int box = order.get(i).second;
				beginEat += M[box];
				ret = Math.max(ret, beginEat + E[box]);
			}
			return ret;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileInputStream("/Users/worms/git/apss/apss/src/chapter10/question2/lunchbox/input.txt"));
		int testCases = Integer.parseInt(sc.nextLine());
		while (testCases-- > 0) {
			int noLunchBox = Integer.parseInt(sc.nextLine());
			String[] waveTimeArray = sc.nextLine().split(" ");
			String[] eatTimeArray = sc.nextLine().split(" ");
			LunchBox lunchBox = new LunchBox(noLunchBox, waveTimeArray, eatTimeArray);
			System.out.println(lunchBox.heat());
		}
		sc.close();
	}
}
