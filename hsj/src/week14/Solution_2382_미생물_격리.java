package week14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Clone {
	int x, y, num, totalNum, direct, idx;
	boolean die;

	Clone(int x, int y, int num, int direct, int idx, boolean die) {
		this.x = x;
		this.y = y;
		this.num = num;
		this.totalNum = num;
		this.direct = direct;
		this.idx = idx;
		this.die = die;
	}
}

public class Solution_2382_미생물_격리 {
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Clone> list = new ArrayList<>();
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			list.clear();
			int mapSize = scan.nextInt();
			int time = scan.nextInt();
			int cloneNum = scan.nextInt();
			for (int j = 1; j <= cloneNum; j++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				int num = scan.nextInt();
				int direct = scan.nextInt();
				list.add(new Clone(x, y, num, direct, j, false));
			}

			for (int t = 0; t < time; t++) {
				int[][] map = new int[mapSize][mapSize];
				for (Clone clone : list) {
					if (!clone.die) {
						int newX = clone.x + dx[clone.direct];
						int newY = clone.y + dy[clone.direct];
						clone.x = newX;
						clone.y = newY;

						if (newX == 0 || newX == mapSize - 1 || newY == 0 || newY == mapSize - 1) {
							map[newX][newY] = clone.idx;
							clone.num /= 2;
							clone.totalNum /= 2;
							clone.die = clone.num > 0 ? false : true;
							clone.direct = clone.direct % 2 == 0 ? clone.direct - 1 : clone.direct + 1;
						}

						else if (map[newX][newY] != 0) {
							Clone existClone = list.get(map[newX][newY] - 1);
							if (existClone.num > clone.num) {
								existClone.totalNum = existClone.totalNum + clone.num;
								clone.die = true;
							} else {
								clone.totalNum = existClone.totalNum + clone.num;
								existClone.die = true;
								map[newX][newY] = clone.idx;
							}
						}

						else {
							map[newX][newY] = clone.idx;
						}
					}
				}
				
				for (Clone clone : list) {
					if (!clone.die) {
						clone.num = clone.totalNum;
					}
				}
			}
			
			int sum = 0;
			for (Clone clone : list) {
				if (!clone.die) {
					sum += clone.num;
				}
			}
			System.out.println("#" + i + " " + sum);
		}
	}
}
