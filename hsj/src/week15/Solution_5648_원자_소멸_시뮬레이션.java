package week15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cell {
	int x, y, direct, size, idx;
	boolean die, trash, move;

	Cell(int x, int y, int direct, int size, int idx) {
		this.x = x;
		this.y = y;
		this.direct = direct;
		this.size = size;
		this.idx = idx;
		this.die = false;
		this.move = false;
		this.trash = false;
	}
}

public class Solution_5648_원자_소멸_시뮬레이션 {
	static int[][] map = null;
	static boolean[][] visit = null;
	static List<Cell> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		for (int i = 1; i <= testCnt; i++) {
			int result = 0;
			list.clear();
			int cellNum = scan.nextInt();
			int maxNum = -1000;
			int minNum = 1000;
			for (int j = 1; j <= cellNum; j++) {
				int y = scan.nextInt();
				int x = scan.nextInt();
				int direct = scan.nextInt();
				int size = scan.nextInt();
				int bigNum = x > y ? x : y;
				int smallNum = x < y ? x : y;
				maxNum = maxNum < bigNum ? bigNum : maxNum;
				minNum = minNum > smallNum ? smallNum : minNum;
				list.add(new Cell(x, y, direct, size, j));
			}
			int maxDistance = Math.abs(maxNum - minNum);
			int rotateNum = maxDistance % 2 == 0 ? maxDistance / 2 : maxDistance / 2 + 1;
			map = new int[maxDistance + 1][maxDistance + 1];
			for (Cell cell : list) {
				cell.x -= minNum;
				cell.y -= minNum;
				map[cell.x][cell.y] = cell.idx;
			}
			int dieCellCnt = 0;
			for (int time = 0; time < rotateNum * 2; time++) {

				if (dieCellCnt + 1 >= cellNum)
					break;
				dieCellCnt = 0;
				for(int a = 0; a < maxDistance + 1; a++) {
					for(int b = 0; b < maxDistance + 1; b++) {
						System.out.print(map[a][b] + " ");
					}
					System.out.println("");
				}
				System.out.println("");
				for (Cell cell : list) {
					if (!cell.die && !cell.trash) {
						int newX = cell.x + dx[cell.direct];
						int newY = cell.y + dy[cell.direct];
						if (0 > newX || newX > maxDistance || 0 > newY || newY > maxDistance) {
							cell.trash = true;
							continue;
						}

						if (time % 2 == 0) {
							if (map[newX][newY] != 0) {
								int reverseDirect = cell.direct % 2 == 0 ? cell.direct + 1 : cell.direct - 1;
								Cell existCell = list.get(map[newX][newY] - 1);
								if (reverseDirect == existCell.direct) {
									map[cell.x][cell.y] = 0;
									map[newX][newY] = 0;
									existCell.die = true;
									cell.die = true;
								}
							}

						} else {
							if (map[cell.x][cell.y] == cell.idx)
								map[cell.x][cell.y] = 0;
							cell.x = newX;
							cell.y = newY;
							cell.move = true;
							if (map[cell.x][cell.y] != 0) {
								Cell existCell = list.get(map[cell.x][cell.y] - 1);
								if (!existCell.move) {
									map[cell.x][cell.y] = cell.idx;
								} else {
									existCell.die = true;
									cell.die = true;
								}
							} else {
								map[cell.x][cell.y] = cell.idx;
							}

						}
					} else {
						dieCellCnt++;
					}

				}
				if (time % 2 != 0) {
					for (Cell cell : list) {
						if (!cell.die) {
							cell.move = false;
						} else {
							if (map[cell.x][cell.y] == cell.idx)
								map[cell.x][cell.y] = 0;
						}
					}
				}

			}
			for (Cell cell : list) {
				System.out.println(cell.die);
				if (cell.die)
					result += cell.size;
			}
			System.out.println("#" + i + " " + result);
		}
	}

}
