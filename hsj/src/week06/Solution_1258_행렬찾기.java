package week06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Matrix implements Comparable<Matrix> {
	int x;
	int y;
	int size;
	Matrix(int x, int y) {
		this.x = x;
		this.y = y;
		this.size = x * y;
	}

	@Override
	public int compareTo(Matrix matrix) {
		if (this.size > matrix.size) {
			return 1; //행렬 크기에 따라 내림차순 정렬
		} else if (this.size == matrix.size) {
			if (this.x > matrix.x) { //행렬 크기가 같을 시 x(열) 사이즈에 따라 내림차순 정렬
				return 1;
			}
		}
		return -1;
	}
}

public class Solution_1258_행렬찾기 {
	static List<Matrix> list = new ArrayList<>();
	static int[][] map = null;
	static boolean[][] visit = null;
	static Queue<Integer> queue = new LinkedList<>();
	static int mapSize = 0;

	static void doBFS(int startX, int startY) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int maxX = startX;
		int maxY = startY;
		while (!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if ((-1 < newX && newX < mapSize) && (-1 < newY && newY < mapSize)
						&& (map[newX][newY] != 0 && !visit[newX][newY])) {
					queue.add(newX);
					queue.add(newY);
					visit[newX][newY] = true;
					if (newX > maxX)
						maxX = newX;
					if (newY > maxY)
						maxY = newY;
				}
			}
		}
		int row = maxX - startX + 1;
		int col = maxY - startY + 1;
		list.add(new Matrix(row, col));
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCount = scan.nextInt();
		for (int i = 1; i <= testCount; i++) {
			int totalCount = 0;
			mapSize = scan.nextInt();
			map = new int[mapSize][mapSize];
			visit = new boolean[mapSize][mapSize];
			for (int j = 0; j < mapSize; j++) {
				for (int k = 0; k < mapSize; k++) {
					map[j][k] = scan.nextInt();
				}
			}
			for (int j = 0; j < mapSize; j++) {
				for (int k = 0; k < mapSize; k++) {
					if (map[j][k] != 0 && !visit[j][k]) {
						visit[j][k] = true;
						queue.add(j);
						queue.add(k);
						doBFS(j, k);
						totalCount++;
					}
				}
			}
			Collections.sort(list);
			System.out.print("#" + i + " " + totalCount);
			for(Matrix matrix : list) {
				System.out.print(" " + matrix.x + " " + matrix.y);
			}
			System.out.println("");
			list.clear();
		}
	}
}
