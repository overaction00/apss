package chapter7.question2.quadtree;

import java.util.Scanner;

public class Main {
    
	private static int index;
	public static String solve(char[] tree) {
		
		if (tree[index] == 'w' || tree[index] == 'b') {
			return String.valueOf(tree[index]);
		}
		index++;
		String leftUp = solve(tree);
		index++;
		String rightUp = solve(tree);
		index++;
		String leftDown = solve(tree);
		index++;
		String rightDown = solve(tree);
		return "x" + leftDown + rightDown + leftUp + rightUp;
	}		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String cases = sc.nextLine();
        int T = Integer.parseInt(cases);
        while(T > 0) {
            String string = sc.nextLine();
            System.out.println(solve(string.toCharArray()));
            index = 0;
            T--;
        }
	}
}
