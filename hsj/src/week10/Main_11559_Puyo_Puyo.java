package week10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_11559_Puyo_Puyo {
	static char[][] map = null;
	static boolean[][] visit = null;
	static List<Integer> list = new ArrayList<>();
	static Queue<Integer> queue = new LinkedList<>();
	static int puyoCnt = 0;

	static int doFindColor(char color) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		while (!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if (-1 < newX && newX < 12 && -1 < newY && newY < 6 && map[newX][newY] == color && !visit[newX][newY]) {
					queue.add(newX);
					queue.add(newY);
					visit[newX][newY] = true;
					puyoCnt++;
					list.add(newX);
					list.add(newY);
				}
			}
		}

		return puyoCnt;
	}

	static void doDown() {
		while (!queue.isEmpty()) {
			int newX = queue.poll() + 1;
			int newY = queue.poll();
			if (-1 < newX && newX < 12 && -1 < newY && newY < 6 && map[newX][newY] == '.') {
					map[newX][newY] = map[newX - 1][newY];
					map[newX - 1][newY] = '.';
					queue.add(newX);
					queue.add(newY);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		map = new char[12][6];
		for (int x = 0; x < 12; x++) {
			String str = scan.next();
			for (int y = 0; y < 6; y++) {
				map[x][y] = str.charAt(y);
			}
		}
		int cnt = -1;
		while (true) {
			visit = new boolean[12][6];
			cnt++;
			boolean flag = false;
			for (int x = 11; x >= 0; x--) {
				for (int y = 5; y >= 0; y--) {
					if (map[x][y] != '.' && !visit[x][y]) {
						visit[x][y] = true;
						puyoCnt++;
						queue.add(x);
						queue.add(y);
						list.add(x);
						list.add(y);
						if (doFindColor(map[x][y]) >= 4) {
							flag = true;
							for (int j = 0; j < list.size(); j += 2) {
								map[list.get(j)][list.get(j + 1)] = '.';
							}
						}
						list.clear();
						puyoCnt = 0;
					}
				}
			}
			if (!flag)
				break;
			for (int x = 11; x >= 0; x--) {
				for (int y = 5; y >= 0; y--) {
					if (map[x][y] != '.') {
						queue.add(x);
						queue.add(y);
						doDown();
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
