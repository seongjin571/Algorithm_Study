package week04;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Practice {
	static int[][] tenByTenMap = new int[10][10];
	static boolean[][] visit = new boolean[10][10];
	static Queue<Integer> queue = new LinkedList<>();

	static void BFS() {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int count = 0;
		while (!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if ((-1 < newX && newX < 10) && (-1 < newY && newY < 10) && visit[newX][newY] == false) {
					count++;
					queue.add(newX);
					queue.add(newY);
					visit[newX][newY] = true;
					tenByTenMap[newX][newY] = count;
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("%3d", tenByTenMap[i][j]);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		visit[0][0] = true;
		queue.add(0);
		queue.add(0);
		BFS();

	}
}
