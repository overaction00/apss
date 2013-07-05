package chapter10.example2.matchorder;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static class MatchOrder {
		
		public int order(Integer[] russians, Integer[] koreans) {
			Arrays.sort(koreans, Collections.reverseOrder());
			
			for (int rus : russians) {
				// 가장 레이팅이 높은 한국선수가 이길수 없다면 가장 레이팅이 낮은 사람을 매칭시킨다.
				
				// 한국 선수가 이길 수 있다면 동일하거나 하나위의 선수를 출선시킨다.
			}
			return 0;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());
		while (testCase-- > 0) {
			int noPlayer = Integer.parseInt(sc.nextLine());
			String[] rusScoresStr = sc.nextLine().split(" ");
			String[] korScoresStr = sc.nextLine().split(" ");
			int[] rusScores = new int[noPlayer];
			int[] korScores = new int[noPlayer];
			for (int i = 0; i < noPlayer; i++) {
				rusScores[i] = Integer.parseInt(rusScoresStr[i]);
				korScores[i] = Integer.parseInt(korScoresStr[i]);
			}
			
			
		}
		sc.close();
	}
}
