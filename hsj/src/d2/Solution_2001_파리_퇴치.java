package d2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
	int x;
	int y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution_2001_파리_퇴치 {
	static Queue<Position> queue = new LinkedList<>();

	static int getMaxFly(int[][] squareArray, int toolSize) {
		int maxFly = 0;
		while (!queue.isEmpty()) {
			Position position = queue.poll();
			int x = position.x;
			int y = position.y;
			int sum = 0;
			for(int i = x; i < toolSize+x; i++) {
				for(int j = y; j < toolSize+y; j++) {
					sum+= squareArray[i][j];
				}
			}
			if(maxFly < sum) maxFly = sum;
		}
		return maxFly;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for (int i = 1; i <= testNum; i++) {
			int squareSize = scan.nextInt();
			int toolSize = scan.nextInt();
			int[][] squareArray = new int[squareSize][squareSize];
			for (int j = 0; j < squareSize; j++) {
				for (int k = 0; k < squareSize; k++) {
					squareArray[j][k] = scan.nextInt();
				}
			}

			for (int j = 0; j < squareSize - toolSize + 1; j++) {
				for (int k = 0; k < squareSize - toolSize + 1; k++) {
					queue.add(new Position(j, k));
				}
			}
			System.out.println("#" + i + " " + getMaxFly(squareArray, toolSize));
		}
	}

}
