package chapter10.example2.matchorder;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static class MatchOrder {
		
		public int order(Integer[] russians, Integer[] koreans) {
			Arrays.sort(koreans, Collections.reverseOrder());
			
			for (int rus : russians) {
				// ���� �������� ���� �ѱ������� �̱�� ���ٸ� ���� �������� ���� ����� ��Ī��Ų��.
				
				// �ѱ� ������ �̱� �� �ִٸ� �����ϰų� �ϳ����� ������ �⼱��Ų��.
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
