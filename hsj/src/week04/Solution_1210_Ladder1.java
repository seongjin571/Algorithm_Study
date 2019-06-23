package week04;

import java.util.Scanner;
import java.util.Stack;

public class Solution_1210_Ladder1 {
	static Scanner scan = new Scanner(System.in);
	static int[][] map = new int[100][100];
	static int[] dx = { 0, 0, 1 };
	static int[] dy = { 1, -1, 0 };
	static boolean[][] visit;
	static int pointY;

	static boolean doLadder(int startY) {
		int x = 0;
		int y = startY;
		while (x < 99) {
			for (int i = 0; i < 3; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if ((-1 < newX && newX < 100) && (-1 < newY && newY < 100)
						&& (map[newX][newY] == 1 && !visit[newX][newY])) {
					if (map[newX][newY] == 2) {
						return true;
					} else {
						visit[newX][newY] = true;
						x = newX;
						y = newY;
						System.out.println(x + " " + y);
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
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
					pointY = z;
					boolean result = doLadder(z);
					if (result)
						break;
				}
			}
			System.out.println("#" + i + " " + 1);
		}
	}
}
