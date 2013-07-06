package chapter10.example2.matchorder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static class MatchOrder {
		
		private int binarySearchLowerBound(List<Integer> list, int low, int high, int value) {
			
			if (low > high) {
				if (high < 0) {
					return 0;
				}
				while(list.get(high) < value) {
					high++;
				}
				return high;
			}
			
			int mid = (low + high) / 2;
			int midValue = list.get(mid);
			if (midValue == value) {
				return mid;
			} else if (midValue > value) {
				return binarySearchLowerBound(list, low, mid - 1, value);
			} else {
				return binarySearchLowerBound(list, mid + 1, high, value);
			}
		}
		
		public int order(int[] russians, int[] koreans) {
			List<Integer> koreanList = new ArrayList<Integer>();
			for (int korean : koreans) {
				koreanList.add(korean);
			}
			Collections.sort(koreanList);
			
			int wins = 0;
			for (int rus : russians) {
				int listSize = koreanList.size();
				if (koreanList.get(listSize - 1) < rus) {
					// 최고점수인 사람이 이길 수 없다면 최저점을 내보낸다.
					koreanList.remove(0);
				} else {
					// 최고점수 보다 낮다면 검색을 통해서 동점이나 가장 근접한 선수를 출전시킨다.
					int player = binarySearchLowerBound(koreanList, 0, listSize - 1, rus);
					koreanList.remove(player);
					wins += 1;
				}
			}
			return wins;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("/Users/worms/git/apss/apss/src/chapter10/example2/matchorder/input.txt"));
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
			System.out.println(new MatchOrder().order(rusScores, korScores));
		}
		sc.close();
	}
}
