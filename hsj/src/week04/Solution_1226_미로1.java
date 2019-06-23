package week04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution_1226_미로1 {
	static int[][] map = new int[16][16];
	static boolean[][] visit;
	static Queue<Point> queue = new LinkedList<>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int doBFS() {
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int x = point.x;
			int y = point.y;
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if ((-1 < x && x < 16) && (-1 < y && y < 16) && (map[newX][newY] != 1 && visit[newX][newY] == false)) {
					if (map[newX][newY] == 3) {
						return 1;
					} else {
						queue.add(new Point(newX, newY));
						visit[newX][newY] = true;
					}
				}
			}
			
		}
		
		return 0;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int count = scan.nextInt();
			queue.clear();
			visit = new boolean[16][16];
			for(int j = 0; j < 16; j++) {
				String rowString = scan.next();
				for(int k = 0; k < 16; k++) {
					map[j][k] = rowString.charAt(k) - '0';
				}
			}
			visit[1][1] = true;
			queue.add(new Point(1, 1));
			System.out.println("#" + i + " " + doBFS());
		}
	}
}
