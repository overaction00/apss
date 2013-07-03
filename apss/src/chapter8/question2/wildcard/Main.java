package chapter8.question2.wildcard;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static final int MAX = 100;
    
    static class WildCard {
		private char[] W;
		private char[] S;
		private int[][] cache = new int[MAX + 1][MAX + 1];
		
		public WildCard(String pattern, String string) {
			W = pattern.toCharArray();
			S = string.toCharArray();
			for ( int i = 0; i < MAX + 1; i++) {
				for ( int j = 0; j < MAX + 1; j++) {
					cache[i][j] = -1;
				}
			}
		}
		
		boolean matchMemoized(int w, int s) {
			if (cache[w][s] == 0) {
				return false;
			} else if (cache[w][s] == 1) {
				return true;
			}
			
			if (w < W.length && s < S.length && (W[w] == '?' || W[w] == S[s])) {
				cache[w][s] = 1;
				return matchMemoized(w+1, s+1);
			}
			
			if (w == W.length) {
				return s == S.length;
			}
			
			if (W[w] == '*') {
				if (matchMemoized(w + 1, s)) {
					return true;
				}
				cache[w + 1][s] = 0;
				
				
				if (s < S.length) {
					if (matchMemoized(w, s + 1)) {
						return true;
					}
					cache[w][s + 1] = 0;
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        String cases = sc.nextLine();
        int T = Integer.parseInt(cases);
        while(T > 0) {
            String pattern = sc.nextLine();
            List<String> list = new ArrayList<String>(MAX);
            int noString = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < noString; i++) {
            	String s = sc.nextLine();
            	if (new WildCard(pattern, s).matchMemoized(0, 0)) {
            		list.add(s);
            	}
            }
            Collections.sort(list);
            for (String s : list) {
            	System.out.println(s);
            }
            T--;
        }
        sc.close();
	}
}