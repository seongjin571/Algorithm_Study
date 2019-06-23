package week04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class MapPoint {
	int x;
	int y;
	int count;

	MapPoint(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class Main_미로탐색 {
	static Scanner scan = new Scanner(System.in);
	static int sizeX = scan.nextInt();
	static int sizeY = scan.nextInt();
	static int[][] map = new int[sizeX][sizeY];
	static Queue<MapPoint> queue = new LinkedList<>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visit = new boolean[sizeX][sizeY];
	static List<Integer> numList = new ArrayList<>();

	static int doBFS() {
		while (!queue.isEmpty()) {
			MapPoint point = queue.poll();
			int x = point.x;
			int y = point.y;
			int count = point.count;
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if ((-1 < newX && newX < sizeX) && (-1 < newY && newY < sizeY) 
						&& (map[newX][newY] == 1 && visit[newX][newY] == false)) {
	
					if (newX == sizeX - 1 && newY == sizeY - 1) {
						return count + 1;
					} else {
						queue.add(new MapPoint(newX, newY, count + 1));
						visit[newX][newY] = true;
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		for (int i = 0; i < sizeX; i++) {
			String rowString = scan.next();
			for (int j = 0; j < sizeY; j++) {
				map[i][j] = rowString.charAt(j) - '0';
			}
		}
		queue.add(new MapPoint(0, 0, 1));
		System.out.print(doBFS());
	}
}
