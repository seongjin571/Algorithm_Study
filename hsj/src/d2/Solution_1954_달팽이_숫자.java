package d2;

import java.util.Scanner;

public class Solution_1954_달팽이_숫자 {
	static void getSnail(int snailSize) {
		int[][] snailArray = new int[snailSize][snailSize];
		for (int i = 0; i < snailSize; i++)
			snailArray[0][i] = i;
		int patternNum = snailSize - 1;
		int directionCount = 1;
		int count = snailSize + 1;
		while (patternNum > 0) {
			int 
			for (int i = 0; i < 2; i++) {
				directionCount++;
				for (int j = 0; j < patternNum; j++) {
					if (directionCount == 5)
						directionCount = 1;
					if (directionCount == 1) {
						snailArray[i][j] = count;
					}
				}
			}
			patternNum--;

		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for (int i = 1; i < testNum; i++) {
			int snailSize = scan.nextInt();
			System.out.println("#" + i + " ");
			getSnail(snailSize);
		}
	}
}
