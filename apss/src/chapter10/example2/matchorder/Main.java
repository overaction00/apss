package chapter10.example2.matchorder;

import java.util.Scanner;

public class Main {
	
	
	
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
