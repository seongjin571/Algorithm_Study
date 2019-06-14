package d2;

import java.util.Scanner;

public class Solution_1954_달팽이_숫자 {
	static void getSnail(int snailSize) {
		int[][] snailArray = new int[snailSize][snailSize];
		for (int i = 0; i < snailSize; i++)
			snailArray[0][i] = i + 1;
		int patternNum = snailSize - 1;
		int directionCount = 1;
		int num = snailSize + 1;
		int j = snailSize - 1;
		int i = 0;
		while (patternNum > 0) {
			for (int z = 0; z < 2; z++) {
				directionCount++;
				for (int k = 0; k < patternNum; k++) {
					if (directionCount == 5) directionCount = 1;
					if (directionCount == 1) snailArray[i][++j] = num++;
					if (directionCount == 2) snailArray[++i][j] = num++;
					if (directionCount == 3) snailArray[i][--j] = num++;
					if (directionCount == 4) snailArray[--i][j] = num++;
				}
			}
			patternNum--;
		}
		
		for(int k = 0; k < snailSize; k++) {
			for(int z = 0; z < snailSize; z++) {
				System.out.print(snailArray[k][z] + " ");
			}
			System.out.println("");
		}
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for (int i = 1; i <= testNum; i++) {
			int snailSize = scan.nextInt();
			System.out.println("#" + i + " ");
			getSnail(snailSize);
		}
	}
}
