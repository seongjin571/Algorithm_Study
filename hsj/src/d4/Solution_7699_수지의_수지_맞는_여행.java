package d4;

import java.util.Scanner;

public class Solution_7699_수지의_수지_맞는_여행 {
	static char[][] map = null;
	static int xSize = 0;
	static int ySize = 0;
	static int maxCnt = 0;
	static int cnt = 0;
	static boolean[] visit = null;

	static void doDFS(int x, int y) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if (-1 < newX && newX < xSize && -1 < newY && newY < ySize && !visit[map[newX][newY] - 'A']) {
				visit[map[newX][newY] - 'A'] = true;
				cnt++;
				doDFS(newX, newY);
				cnt--;
				visit[map[newX][newY] - 'A'] = false;
			} 
//			else if (-1 < newX && newX < xSize && -1 < newY && newY < ySize && visit[map[newX][newY] - 'A']) {
//				if (maxCnt < cnt)
//					maxCnt = cnt;
//			}
		}
		if (maxCnt < cnt)
			maxCnt = cnt;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			xSize = scan.nextInt();
			ySize = scan.nextInt();
			map = new char[xSize][ySize];
			visit = new boolean[26];
			maxCnt = 0;
			for (int x = 0; x < xSize; x++) {
				String str = scan.next();
				for (int y = 0; y < ySize; y++) {
					map[x][y] = str.charAt(y);
				}
			}
			cnt = 1;
			visit[map[0][0] - 'A'] = true;
			doDFS(0, 0);
			System.out.println("#" + i + " " + maxCnt);
		}
	}
}
