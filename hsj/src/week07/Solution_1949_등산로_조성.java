package week07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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

public class Solution_1949_등산로_조성 {
	static int squareSize;
	static int depth;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visit;
	public static int maxCount = 0;
	public static boolean depthFlag = false;

	public static void doDFS(int beforeX, int beforeY, int x, int y, int value, boolean flag, int count) {
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if ((-1 < newX && newX < squareSize) && (-1 < newY && newY < squareSize) && (newX != beforeX || newY != beforeY)) {
				if (map[newX][newY] < value) {
					doDFS(x, y, newX, newY, map[newX][newY], flag, count + 1);
				} else {
					if (flag) {
						if (maxCount < count)
							maxCount = count;
					} else {
						for (int j = 1; j <= depth; j++) {
							if (map[newX][newY] - j < value) {
								// flag = true;
								depthFlag = true;
								doDFS(x, y, newX, newY, map[newX][newY] - j, true, count + 1);
								break;
							}
						}
						if (!depthFlag) {
							if (maxCount < count)
								maxCount = count;
						}
					}
					depthFlag = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for (int i = 1; i <= testNum; i++) {
			Queue<Point> startQueue = new LinkedList<Point>();
			List<Integer> list = new ArrayList<>();
			squareSize = scan.nextInt();
			map = new int[squareSize][squareSize];
			visit = new boolean[squareSize][squareSize];
			depth = scan.nextInt();
			int maxNum = 0;
			boolean flag = false;
			for (int j = 0; j < squareSize; j++) {
				for (int k = 0; k < squareSize; k++) {
					map[j][k] = scan.nextInt();
					if (maxNum < map[j][k])
						maxNum = map[j][k];
				}
			}

			for (int j = 0; j < squareSize; j++) {
				for (int k = 0; k < squareSize; k++) {
					if (map[j][k] == maxNum) {
						startQueue.add(new Point(j, k));
					}
				}
			}

			while (!startQueue.isEmpty()) {
				Point startPoint = startQueue.poll();
				int x = startPoint.x;
				int y = startPoint.y;
				maxCount = 0;
				doDFS(-1, -1, x, y, maxNum, flag, 1);
				list.add(maxCount);
			}
			Collections.sort(list);
			System.out.println("#" + i + " " + list.get(list.size()-1));
		}
	}
}
