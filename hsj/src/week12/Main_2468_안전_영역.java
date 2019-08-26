package week12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2468_안전_영역 {
	static int[][] map = null;
	static boolean[][] visit = null;
	static int mapSize = 0;
	static Queue<Integer> queue = new LinkedList<>();
	
	static void findArea() {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		while(!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			for(int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if(-1 < newX && newX < mapSize && -1 < newY && newY < mapSize && map[newX][newY] > 0 && !visit[newX][newY]) {
					visit[newX][newY] = true;
					queue.add(newX);
					queue.add(newY);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		mapSize = scan.nextInt();
		map = new int[mapSize][mapSize];
		int maxArea = 1;
		int maxNum = 0;
		for (int x = 0; x < mapSize; x++) {
			for (int y = 0; y < mapSize; y++) {
				map[x][y] = scan.nextInt();
				if (map[x][y] > maxNum)
					maxNum = map[x][y];
			}
		}

		for (int i = 1; i < maxNum; i++) {
			int area = 0;
			visit = new boolean[mapSize][mapSize];
			for (int x = 0; x < mapSize; x++) {
				for (int y = 0; y < mapSize; y++) {
					map[x][y]--;
				}
			}
			for (int x = 0; x < mapSize; x++) {
				for (int y = 0; y < mapSize; y++) {
					if(map[x][y] > 0 && !visit[x][y]) {
						queue.add(x);
						queue.add(y);
						visit[x][y] = true;
						area++;
						findArea();
					}
				}
			}
			if(area > maxArea) maxArea = area;
		}
		System.out.println(maxArea);
	}
}
