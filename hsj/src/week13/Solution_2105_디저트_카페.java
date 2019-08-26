package week13;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_2105_디저트_카페 {
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	static int[] visit = new int[4];
	static int[][] map = null;
	static int mapSize = 0;
	static int startX, startY;
	static int maxCnt = 0;
	static Set<Integer> set = new HashSet<>();

	static void doDFS(int x, int y, int idx, int cnt) {
		if(idx > 3) return;
		int size = set.size();
		int newX = x + dx[idx];
		int newY = y + dy[idx];
		if (newX == startX && newY == startY) {
			if (idx == 3) {
				maxCnt = maxCnt > cnt ? maxCnt : cnt;
			} else
				return;
		}
		if (-1 < newX && newX < mapSize && -1 < newY && newY < mapSize) {
			set.add(map[newX][newY]);
			if (size != set.size()) {
				doDFS(newX, newY, idx, cnt + 1);
			} else {
				doDFS(newX, newY, idx + 1, cnt + 1);
			}
		}else {
			doDFS(newX, newY, idx + 1, cnt + 1);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			maxCnt = 0;
			mapSize = scan.nextInt();
			map = new int[mapSize][mapSize];
			for (int x = 0; x < mapSize; x++) {
				for (int y = 0; y < mapSize; y++) {
					map[x][y] = scan.nextInt();
				}
			}
			for (int x = 0; x < mapSize - 1; x++) {
				for (int y = 0; y < mapSize - 1; y++) {
					set.clear();
					startX = x;
					startY = y;
					set.add(map[x][y]);
					doDFS(x, y, 0, 1);
				}
			}
			maxCnt = maxCnt == 0 ? -1 : maxCnt;
			System.out.println("#" + i + " " + maxCnt);
		}
	}
}
