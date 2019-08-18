package week13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point{
	int x, y, rotateIdx, order;
	Point(int x, int y, int rotateIdx, int order){
		this.x = x;
		this.y = y;
		this.rotateIdx = rotateIdx;
		this.order = order;
	}
}

public class Main_16927_배열_돌리기2 {
	static List<Point> list = new ArrayList<>();
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[][] map = null;
	static int[][] newMap = null;
	static int[][] visit = null;
	static int xSize = 0;
	static int ySize = 0;
	static int rotateCnt = 0;
	static int[] arr = null;

	static void doMove(int x, int y, int idx, int i) {
		int rotateNum = rotateCnt % arr[i];
		int newX = x;
		int newY = y;
		while (rotateNum > 0) {
			int plusX = newX + dx[idx];
			int plusY = newY + dy[idx];
			if (-1 < plusX && plusX < xSize && -1 < plusY && plusY < ySize && visit[plusX][plusY] == i) {
				newX = plusX;
				newY = plusY;
				rotateNum--;
			} else {
				idx++;
				if (idx == 4)
					idx = 0;
			}
		}
		newMap[newX][newY] = map[x][y];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		xSize = scan.nextInt();
		ySize = scan.nextInt();
		map = new int[xSize][ySize];
		newMap = new int[xSize][ySize];
		visit = new int[xSize][ySize];
		rotateCnt = scan.nextInt();
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				map[x][y] = scan.nextInt();
				newMap[x][y] = map[x][y];
			}
		}
		int size = xSize > ySize ? xSize / 2 : ySize / 2;
		arr = new int[size];
		for (int i = 0; i < size; i++) {
			for (int x = i; x < xSize - i; x++) {
				for (int y = i; y < ySize - i; y++) {
					if (x == i && y != i) {
						arr[i]++;
						visit[x][y] = i;
						list.add(new Point(x, y, 0, i));
					} 
					else if (y == i) {
						arr[i]++;
						visit[x][y] = i;
						list.add(new Point(x, y, 1, i));
					} 
					else if (x == xSize - 1 - i && y != ySize - 1 - i) {
						arr[i]++;
						visit[x][y] = i;
						list.add(new Point(x, y, 2, i));
					} 
					else if (y == ySize - 1 - i) {
						arr[i]++;
						visit[x][y] = i;
						list.add(new Point(x, y, 3, i));
					}
				}
			}
		}
		
		for(Point point : list) {
			doMove(point.x, point.y, point.rotateIdx, point.order);
		}

		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				System.out.print(newMap[x][y] + " ");
			}
			System.out.println("");
		}
	}
}
