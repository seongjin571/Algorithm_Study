package week08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Cell implements Comparable<Cell> {
	int x, y, hour, value, state;

	Cell(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.hour = value;
		this.value = value;
		this.state = 1;
	}

	@Override
	public int compareTo(Cell cell) {
		if (this.value > cell.value) {
			return 1;
		}
		return 0;
	}
}

public class Solution_5653_줄기세포배양 {
	static List<Cell> list = new ArrayList<>();
	static int totalHour = 0;
	static int[][] map = null;

	static int doBFS() {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		for (int i = 0; i < totalHour; i++) {
			Collections.sort(list);
			int listSize = list.size();
			for(int k = 0; k < listSize; k++) {
				Cell cell = list.get(k);
				cell.hour--;
				if(cell.state == 1 && cell.hour == 0) {
					cell.state = 2;
					cell.hour = cell.value;
				}

				else if(cell.state == 2 && cell.hour >= 0) {
					for(int j = 0; j < 4; j++) {
						int newX = cell.x + dx[j];
						int newY = cell.y + dy[j];
						if(map[newX][newY] == 0) {
							map[newX][newY] = cell.value;
							list.add(new Cell(newX, newY, cell.value));
						}
					}
					if(cell.hour -1 < 0) {
						list.remove(k);
						k--;
						listSize--;
					}
				}
			}
		}
		return list.size();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for (int i = 1; i <= testNum; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			totalHour = scan.nextInt();
			int xSize = x + totalHour;
			int ySize = y + totalHour;
			int xStart = xSize / 2 - x / 2;
			int yStart = ySize / 2 - y / 2;
			map = new int[xSize][ySize];
			for (int j = xStart; j < xStart + x; j++) {
				for (int k = yStart; k < yStart + y; k++) {
					map[j][k] = scan.nextInt();
					if (map[j][k] != 0)
						list.add(new Cell(j, k, map[j][k]));
				}
			}

			System.out.println("#" + i + " " + doBFS());
			list.clear();
		}

	}
}
