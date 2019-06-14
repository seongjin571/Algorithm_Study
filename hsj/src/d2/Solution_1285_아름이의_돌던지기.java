package d2;

import java.util.Scanner;

public class Solution_1285_아름이의_돌던지기 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i = 1; i <= testNum; i++) {
			int tryNum = scan.nextInt();
			int highScore = 100000;
			int count = 0;
			for(int j = 0; j < tryNum; j++) {
				int tryResult = scan.nextInt();
				int tryScore = Math.abs(tryResult);
				if(tryScore < highScore) {
					count = 1;
					highScore = tryScore;
				}
				else if(tryScore == highScore)
					count++;
			}
			System.out.println("#" + i + " " + highScore + " " + count);
		}
	}

}
