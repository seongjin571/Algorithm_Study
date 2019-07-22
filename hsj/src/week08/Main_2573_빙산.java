package week08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Point2 {
	int x, y;

	Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_2573_빙산 {
	static Queue<Integer> queue = new LinkedList<>();
	static List<Point2> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int iceCount = 0;
		int year = 0;
		boolean flag = false;
		int xSize = scan.nextInt();
		int ySize = scan.nextInt();
		int[][] map = new int[xSize][ySize];
		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				map[i][j] = scan.nextInt();
				if (map[i][j] != 0) {
					list.add(new Point2(i, j));
				}
			}
		}
		while (true) {
			boolean[][] icePosi = new boolean[xSize][ySize];
			year++;
			int listSize = list.size();
			for (int i = 0; i < listSize; i++) {
				Point2 point = list.get(i);
				int x = point.x;
				int y = point.y;
				icePosi[x][y] = true;
				for (int j = 0; j < 4; j++) {
					int newX = x + dx[j];
					int newY = y + dy[j];
					if (-1 < newX && newX < xSize && -1 < newY && newY < ySize && map[newX][newY] == 0 && !icePosi[newX][newY]) {
						map[x][y]--;
						if (map[x][y] <= 0) {
							list.remove(i);
							i--;
							listSize--;
							break;
						}
					}
				}
			}
			boolean[][] visit = new boolean[xSize][ySize];
			if (list.size() == 0) {
				System.out.println(0);
				flag = true;
				break;
			} else {
				Point2 point = list.get(0);
				int x = point.x;
				int y = point.y;
				visit[x][y] = true;
				queue.add(x);
				queue.add(y);
				iceCount = 1;
				while (!queue.isEmpty()) {
					int xStart = queue.poll();
					int yStart = queue.poll();
					for (int j = 0; j < 4; j++) {
						int newX = xStart + dx[j];
						int newY = yStart + dy[j];
						if (-1 < newX && newX < xSize && -1 < newY && newY < ySize && map[newX][newY] != 0
								&& !visit[newX][newY]) {
							iceCount++;
							visit[newX][newY] = true;
							queue.add(newX);
							queue.add(newY);
						}
					}
				}
				if (iceCount != list.size())
					break;
			}
		}
		if (!flag)
			System.out.println(year);
	}
}
