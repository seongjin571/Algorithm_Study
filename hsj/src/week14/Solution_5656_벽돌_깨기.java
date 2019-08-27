package week14;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Bumb {
	int x, y, size;

	Bumb(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
}

public class Solution_5656_벽돌_깨기 {
	static int attackCnt = 0;
	static int xSize = 0;
	static int ySize = 0;
	static int[][] map = null;
	static int[][] cloneMap = null;
	static int[] position = null;
	static boolean[] visit = null;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<Bumb> queue = new LinkedList<>();
	static int result = 0;
	static int maxResult = 0;
	static int totalBumb = 0;
	static boolean flag = true;

	static void doBumb() {
		while (!queue.isEmpty()) {
			Bumb bumb = queue.poll();
			int x = bumb.x;
			int y = bumb.y;
			int size = bumb.size;
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < size; j++) {
					int newX = x + dx[i] * j;
					int newY = y + dy[i] * j;
					if (-1 < newX && newX < xSize + 1 && -1 < newY && newY < ySize && cloneMap[newX][newY] != 0) {
						queue.add(new Bumb(newX, newY, cloneMap[newX][newY]));
						cloneMap[newX][newY] = 0;
						result++;
					}
				}
			}
		}
		for (int i = xSize - 1; i >= 1; i--) {
			for (int j = ySize - 1; j >= 0; j--) {
				if (cloneMap[i][j] != 0) {
					int cnt = 1;
					while (i + cnt < xSize + 1 && cloneMap[i + cnt][j] == 0) {
						cloneMap[i + cnt][j] = cloneMap[i + cnt - 1][j];
						cloneMap[i + cnt - 1][j] = 0;
						cnt++;
					}
				}
			}
		}
	}

	static void getAttackPosi(int cnt) {
		if(flag) {
		if (cnt == attackCnt) {
			for (int x = 1; x <= xSize; x++) {
				for (int y = 0; y < ySize; y++) {
					cloneMap[x][y] = map[x][y];
				}
			}
			result = 0;
			for (int y : position) {
				int x = 0;
				while (true) {
					int newX = x + 1;
					if(newX > xSize) break;
					if (cloneMap[newX][y] != 0) {
						result++;
						queue.add(new Bumb(newX, y, cloneMap[newX][y]));
						cloneMap[newX][y] = 0;
						doBumb();
						break;
					} else {
						x++;
					}
				}
			}
			maxResult = maxResult > result ? maxResult : result;
			if(maxResult == totalBumb) flag = false;
			return;
		}
		for (int i = 0; i < ySize; i++) {
			position[cnt] = i;
			getAttackPosi(cnt + 1);
			position[cnt] = 0;
		}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			flag = true;
			maxResult = 0;
			attackCnt = scan.nextInt();
			ySize = scan.nextInt();
			xSize = scan.nextInt();
			map = new int[xSize + 1][ySize];
			cloneMap = new int[xSize + 1][ySize];
			totalBumb = 0;
			for (int x = 1; x <= xSize; x++) {
				for (int y = 0; y < ySize; y++) {
					map[x][y] = scan.nextInt();
					if (map[x][y] != 0)
						totalBumb++;
				}
			}
			position = new int[attackCnt];
			getAttackPosi(0);
			System.out.println("#" + i + " " + (totalBumb - maxResult));
		}
	}
}
