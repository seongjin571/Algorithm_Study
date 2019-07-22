package week08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_12100_2048_easy {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int squareSize = 0;
	static int[][] map = null;
	static int[][] newMap = null;
	static boolean[][] visit = null;
	static int resultNum = 0;
	static int maxNum = 0;
	static List<Integer> combiList = new ArrayList<>();
	static List<Integer> list = new ArrayList<>();

	private static void do2048(int x, int y, int i) {
		int newX = x + dx[combiList.get(i)];
		int newY = y + dy[combiList.get(i)];
		if (-1 < newX && newX < squareSize && -1 < newY && newY < squareSize) {
			if (newMap[newX][newY] == newMap[x][y] && !visit[newX][newY] && !visit[x][y]) {
				newMap[newX][newY] *= 2;
				visit[newX][newY] = true;
				newMap[x][y] = 0;
				if (resultNum < newMap[newX][newY])
					resultNum = newMap[newX][newY];

			} else if (newMap[newX][newY] == 0) {
				newMap[newX][newY] = newMap[x][y];
				newMap[x][y] = 0;
				do2048(newX, newY, i);
			}
		}
	}

	private static void getCombi() {
		if (combiList.size() == 5) {
			for (int z = 0; z < squareSize; z++) {
				for (int l = 0; l < squareSize; l++) {
					newMap[z][l] = map[z][l];
				}
			}
			resultNum = maxNum;
			for (int i = 0; i < 5; i++) {
				visit = new boolean[squareSize][squareSize];

				if (combiList.get(i) == 0 || combiList.get(i) == 3) {
					for (int j = 0; j < squareSize; j++) {
						for (int k = 0; k < squareSize; k++) {
							if (newMap[j][k] != 0)
								do2048(j, k, i);
						}
					}
				} else {
					for (int j = squareSize - 1; j >= 0; j--) {
						for (int k = squareSize - 1; k >= 0; k--) {
							if (newMap[j][k] != 0)
								do2048(j, k, i);
						}
					}
				}
				list.add(resultNum);
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			combiList.add(i);
			getCombi();
			combiList.remove(combiList.size() - 1);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		squareSize = scan.nextInt();
		map = new int[squareSize][squareSize];
		newMap = new int[squareSize][squareSize];
		for (int i = 0; i < squareSize; i++) {
			for (int j = 0; j < squareSize; j++) {
				map[i][j] = scan.nextInt();
				if (maxNum < map[i][j])
					maxNum = map[i][j];
			}
		}
		getCombi();
		Collections.sort(list);
		System.out.println(list.get(list.size() - 1));
	}
}
