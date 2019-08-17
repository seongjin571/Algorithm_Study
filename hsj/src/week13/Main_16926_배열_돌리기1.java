package week13;

import java.util.Scanner;

public class Main_16926_배열_돌리기1 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[][] map = null;
	static int[][] newMap = null;
	static int[][] visit = null;
	static int xSize = 0;
	static int ySize = 0;
	static int rotateCnt = 0;

	static void doMove(int x, int y, int i, int idx) {
		int rotateNum = rotateCnt;
		int newX = x;
		int newY = y;
		while (rotateNum > 0) {
			int plusX = newX + dx[idx];
			int plusY = newY + dy[idx];
			if (-1 < plusX && plusX < xSize && -1 < plusY && plusY < ySize && visit[plusX][plusY] == i) {
				newX = plusX;
				newY = plusY;
				rotateNum--;
			} else {
				idx++;
				if (idx == 4)
					idx = 0;
			}
		}
		newMap[newX][newY] = map[x][y];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		xSize = scan.nextInt();
		ySize = scan.nextInt();
		map = new int[xSize][ySize];
		newMap = new int[xSize][ySize];
		visit = new int[xSize][ySize];
		rotateCnt = scan.nextInt();
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				map[x][y] = scan.nextInt();
				newMap[x][y] = map[x][y];
			}
		}
		int size = xSize > ySize ? xSize / 2 : ySize / 2;
		for (int i = 0; i < size; i++) {
			for (int x = i; x < xSize - i; x++) {
				for (int y = i; y < ySize - i; y++) {
					if (x == i || y == i || x == xSize - 1 - i || y == ySize - 1 - i) {
						visit[x][y] = i;
					}
				}
			}
		}
		
		
		for (int i = 0; i < size; i++) {
			for (int x = i; x < xSize - i; x++) {
				for (int y = i; y < ySize - i; y++) {
					if(x == i && y != i) doMove(x, y, i, 0);
					else if(y == i) doMove(x, y, i, 1);
					else if(x == xSize - 1 - i && y != ySize - 1 - i) doMove(x, y, i, 2);
					else if(y == ySize - 1 - i) doMove(x, y, i , 3);
				}
			}
		}
		
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				System.out.print(newMap[x][y] + " ");
			}
			System.out.println("");
		}
	}
}
