package week04;

import java.util.Scanner;

public class Solution_1211_Ladder2 {
	static Scanner scan = new Scanner(System.in);
	static int[][] map = new int[100][100];
	static int[] dx = { 0, 0, 1 };
	static int[] dy = { 1, -1, 0 };
	static boolean[][] visit;
	static int maxCountY;
	static int beforeCountY;
	
	static void doLadder(int startY) {
		int count = 1;
		int x = 0;
		int y = startY;
		while (x < 99) {
			for (int i = 0; i < 3; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if ((-1 < newX && newX < 100) && (-1 < newY && newY < 100)
						&& (map[newX][newY] == 1 && !visit[newX][newY])) {
						count++;
						visit[newX][newY] = true;
						x = newX;
						y = newY;
				}
			}
		}
		if(count <= beforeCountY) {
			beforeCountY = count;
			maxCountY = startY;
		}
	}

	public static void main(String[] args) {
		int result = 0;
		for (int i = 1; i <= 10; i++) {
			maxCountY = 0;
			beforeCountY = 10000;
			int testCount = scan.nextInt();
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					map[j][k] = scan.nextInt();
				}
			}
			for (int z = 0; z < 100; z++) {
				visit = new boolean[100][100];
				if (map[0][z] == 1) {
					visit[0][z] = true;
					doLadder(z);
				}
			}
			System.out.println("#" + i + " " + maxCountY);
		}
	}
}
