package week18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x, y;
	int[] arr;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void getIdx(int idx) {
		this.arr = new int[idx];
	}
}

public class Solution_1767_프로세서_연결하기 {
	static List<Point> list = new ArrayList<>();
	static Queue<Integer> queue = new LinkedList<>();
	static int[][] map = null;
	static int[][] visit = null;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int processNum = 0;
	static int mapSize = 0;
	static int maxProCnt = 0;
	static int minLineCnt = 0;

	public static void getRoute(int cnt, int lineCnt, int processCnt) {
		if (cnt == processNum) {
			if (maxProCnt < processCnt) {
				maxProCnt = processCnt;
				minLineCnt = lineCnt;
			} else if (maxProCnt == processCnt) {
				minLineCnt = minLineCnt > lineCnt ? lineCnt : minLineCnt;
			}
			return;
		}
		int x = list.get(cnt).x;
		int y = list.get(cnt).y;
		int[] arr = list.get(cnt).arr;
		if (arr.length == 0)
			getRoute(cnt + 1, lineCnt, processCnt);
		for (int i = 0; i < arr.length; i++) {
			boolean flag = false;
			int newX = x;
			int newY = y;
			while (true) {
				newX += dx[arr[i]];
				newY += dy[arr[i]];
				if (map[newX][newY] == 0) {
					if (newX == 0 || newY == 0 || newX == mapSize - 1 || newY == mapSize - 1) {
						flag = true;
						queue.add(newX);
						queue.add(newY);
						processCnt++;
						while (!queue.isEmpty()) {
							lineCnt++;
							int moveX = queue.poll();
							int moveY = queue.poll();
							map[moveX][moveY] = 2;
						}
						break;
					} else {
						queue.add(newX);
						queue.add(newY);
					}
				} else {
					queue.clear();
					break;
				}
			}
			
			getRoute(cnt + 1, lineCnt, processCnt);

			if (flag) { 
				newX = x;
				newY = y;
				while (true) {
					lineCnt--;
					newX += dx[arr[i]];
					newY += dy[arr[i]];
					map[newX][newY] = 0;
					if (newX == 0 || newY == 0 || newX == mapSize - 1 || newY == mapSize - 1) {
						break;
					}
				}
				processCnt--;
			}
		}
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			list.clear();
			maxProCnt = 0;
			processNum = 0;
			mapSize = scan.nextInt();
			map = new int[mapSize][mapSize];
			visit = new int[mapSize][mapSize];
			minLineCnt = mapSize * mapSize;
			for (int x = 0; x < mapSize; x++) {
				for (int y = 0; y < mapSize; y++) {
					map[x][y] = scan.nextInt();
					if (map[x][y] == 1) {
						if (x != 0 && y != 0 && x != mapSize - 1 && y != mapSize - 1) {
							list.add(new Point(x, y));
							processNum++;
						}
					}
				}
			}
			List<Integer> pointList = new ArrayList<>();
			for (Point point : list) {
				pointList.clear();
				int idx = 0;
				int x = point.x;
				int y = point.y;
				for (int j = 0; j < 4; j++) {
					int newX = x;
					int newY = y;
					while (true) {
						newX += dx[j];
						newY += dy[j];
						if (map[newX][newY] == 0) {
							if (newX == 0 || newY == 0 || newX == mapSize - 1 || newY == mapSize - 1) {
								idx++;
								pointList.add(j);
								break;
							}
						} else {
							break;
						}
					}
				}
				point.getIdx(idx);
				for (int j = 0; j < idx; j++) {
					point.arr[j] = pointList.get(j);
				}
			}
			getRoute(0, 0, 0);
			System.out.println("#" + i + " " + minLineCnt);
		}
	}
}
