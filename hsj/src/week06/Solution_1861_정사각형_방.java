package week06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1861_정사각형_방 {
	static Queue<Integer> queue = new LinkedList<>();
	static int[] countArray = null;
	static int[][] map = null;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int squareSize = 0;
	static int count = 0;

	static void doBFS() {
		count = 1;
		while (!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			for (int i = 0; i < 4; i++) {
				int value = map[x][y];
				int newX = x + dx[i];
				int newY = y + dy[i];
				if ((-1 < newX && newX < squareSize) && (-1 < newY && newY < squareSize)
						&& map[newX][newY] == value + 1) {
					queue.add(newX);
					queue.add(newY);
					count++;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCount = scan.nextInt();
		for (int i = 1; i <= testCount; i++) {
			squareSize = scan.nextInt();
			countArray = new int[squareSize * squareSize + 1];
			map = new int[squareSize][squareSize];
			for (int j = 0; j < squareSize; j++) {
				for (int k = 0; k < squareSize; k++) {
					map[j][k] = scan.nextInt();
				}
			}
			for (int j = 0; j < squareSize; j++) {
				for (int k = 0; k < squareSize; k++) {
					queue.add(j);
					queue.add(k);
					doBFS();
					countArray[map[j][k]] = count;
				}
			}
			int resultNum = 0;
			int maxCount = 0;
			for (int j = squareSize * squareSize; j > 0; j--) {
				if (maxCount <= countArray[j]) {
					resultNum = j;
					maxCount = countArray[j];
				}
			}
			System.out.println("#" + i + " " + resultNum + " " + maxCount);
		}
	}

}
