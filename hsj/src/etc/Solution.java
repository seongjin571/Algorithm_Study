package etc;

class Solution {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] landX1 = { 1, 1 };
	static int[] landY1 = { -1, 1 };
	static int[] landX2 = { 1, -1 };
	static int[] landY2 = { -1, -1 };
	static int[] colX1 = { 1, 1 };
	static int[] colY1 = { 1, -1 };
	static int[] colX2 = { -1, 1 };
	static int[] colY2 = { -1, -1 };
	static int mapSize = 0;
	static int[][] map = null;
	static boolean[][] visit1 = null;
	static boolean[][] visit2 = null;
	static int minTime = 10000;

	static void doDFS(int x1, int y1, int x2, int y2, int cnt, boolean shape) {
		if ((x1 == mapSize - 1 && y1 == mapSize - 1) || (x2 == mapSize - 1 && y2 == mapSize - 1)) {
			minTime = minTime < cnt ? minTime : cnt;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int newX1 = x1 + dx[i];
			int newX2 = x2 + dx[i];
			int newY1 = y1 + dy[i];
			int newY2 = y2 + dy[i];
			if (-1 < newX1 && newX1 < mapSize && -1 < newY1 && newY1 < mapSize && -1 < newX2 && newX2 < mapSize
					&& -1 < newY2 && newY2 < mapSize && (!visit1[newX1][newY1] || !visit2[newX2][newY2])
					&& map[newX1][newY1] != 1 && map[newX2][newY2] != 1) {
				doDFS(newX1, newY1, newX2, newX2, cnt + 1, shape);
			}
		}
		for (int i = 0; i < 2; i++) {
			int newX1 = x1 + landX1[i];
			int newY1 = y1 + landY1[i];
			if (-1 < newX1 && newX1 < mapSize && -1 < newY1 && newY1 < mapSize
					&& (!visit1[newX1][newY1] || !visit2[x2][y2]) && map[newX1][newY1] != 1) {
				visit1[newX1][newY1] = true;
				visit2[x2][y2] = true;
				if (i == 0)
					doDFS(newX1, newY1, x2, y2, cnt + 1, !shape);
				else
					doDFS(x2, y2, newX1, newY1, cnt + 1, !shape);
				visit1[newX1][newY1] = false;
				visit2[x2][y2] = false;
			}
		}
		for (int i = 0; i < 2; i++) {
			int newX2 = x2 + landX2[i];
			int newY2 = y2 + landY2[i];
			if (-1 < newX2 && newX2 < mapSize && -1 < newY2 && newY2 < mapSize
					&& (!visit1[newX2][newY2] || !visit2[x1][y1]) && map[newX2][newY2] != 1) {
				visit1[x1][y1] = true;
				visit2[newX2][newY2] = true;
				if (i == 1)
					doDFS(newX2, newY2, x1, y1, cnt + 1, !shape);
				else
					doDFS(x1, y1, newX2, newY2, cnt + 1, !shape);
				visit1[x1][y1] = false;
				visit2[newX2][newY2] = false;
			}
		}
		for (int i = 0; i < 2; i++) {
			int newX1 = x1 + colX1[i];
			int newY1 = y1 + colY1[i];
			if (-1 < newX1 && newX1 < mapSize && -1 < newY1 && newY1 < mapSize
					&& (!visit1[newX1][newY1] || !visit2[x2][y2]) && map[newX1][newY1] != 1) {
				visit1[newX1][newY1] = true;
				visit2[x2][y2] = true;
				if (i == 0)
					doDFS(x2, y2, newX1, newY1, cnt + 1, !shape);
				else
					doDFS(newX1, newY1, x2, x2, cnt + 1, !shape);
				visit1[newX1][newY1] = false;
				visit2[x2][y2] = false;
			}
		}
		for (int i = 0; i < 2; i++) {
			int newX2 = x2 + colX2[i];
			int newY2 = y2 + colY2[i];
			if (-1 < newX2 && newX2 < mapSize && -1 < newY2 && newY2 < mapSize
					&& (!visit1[newX2][newY2] || !visit2[x1][x2]) && map[newX2][newY2] != 1) {
				visit1[x1][y1] = true;
				visit2[newX2][newY2] = true;
				if (i == 0)
					doDFS(newX2, newY2, x1, y1, cnt + 1, !shape);
				else
					doDFS(x1, y1, newX2, newY2, cnt + 1, !shape);
				visit1[x1][y1] = false;
				visit2[newX2][newY2] = false;
			}
		}
	}

	public static int solution(int[][] board) {
		map = board;
		mapSize = board.length;
		System.out.println(mapSize);
		boolean[][] visit1 = new boolean[mapSize][mapSize];
		boolean[][] visit2 = new boolean[mapSize][mapSize];
		visit1[0][0] = true;
		visit2[0][1] = true;
		doDFS(0, 0, 0, 1, 0, true);
		int answer = minTime;
		return answer;
	}

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		solution(board);
	}
}