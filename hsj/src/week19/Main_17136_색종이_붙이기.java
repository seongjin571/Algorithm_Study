package week19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Position {
	int x, y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class ColorState implements Comparable<ColorState> {
	int useNum;
	int[] useArr = new int[5];

	ColorState(int useNum) {
		this.useNum = useNum;
	}

	@Override
	public int compareTo(ColorState colorState) {
		if (this.useNum > colorState.useNum)
			return 1;
		return -1;
	}
}

public class Main_17136_색종이_붙이기 {
	static int[][][] colorPaper = { { { 1 } }, { { 1, 1 }, { 1, 1 } }, { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } },
			{ { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } },
			{ { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 } } };
	static int[] colorPaperCnt = new int[5];
	static int result = 0;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map = null;
	static int checkCnt = 0;
	static int size = 0;
	static int maxX = 0;
	static int maxY = 0;
	static int minX = 0;
	static int minY = 0;
	static int cnt = 0;
	static boolean[][] visit = null;
	static Queue<Position> queue = new LinkedList<>();
	static List<ColorState> list = new ArrayList<>();

	static void checkArr(int result, int num) {
//		System.out.println(result + " " + cnt + " " + num);
		if (result == cnt) {
			list.add(new ColorState(num));
			ColorState colorState = list.get(list.size() - 1);
			for (int i = 0; i < 5; i++) {
				colorState.useArr[i] = colorPaperCnt[i];
			}
			return;
		}
		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				if (map[x][y] == 1) {
					for (int i = size - 1; i >= 0; i--) {
						boolean flag = false;
//						System.out.println(x+ " " + y + " " + i);
						if (colorPaperCnt[i] > 4)
							continue;
						if (x + i <= maxX && y + i <= maxY) {
							for (int j = x; j <= x + i; j++) {
								if (flag)
									break;
								for (int k = y; k <= y + i; k++) {
									if (colorPaper[i][j - x][k - y] != map[j][k]) {
										flag = true;
										break;
									}
								}
							}

							if (!flag) {
								for (int j = x; j <= x + i; j++) {
									for (int k = y; k <= y + i; k++) {
										if (map[j][k] == 1) {
											result++;
											map[j][k] = num + 2;
										}
									}
									
								}
								colorPaperCnt[i]++;
//								System.out.println("");
//								for(int a = 0; a < 10; a++) {
//									for(int b = 0; b < 10; b++) {
//										System.out.print(map[a][b] + " ");
//									}
//									System.out.println("");
//								}
								checkArr(result, num + 1);
								colorPaperCnt[i]--;
								for (int j = x; j <= x + i; j++) {
									for (int k = y; k <= y + i; k++) {
										if (map[j][k] == num + 2) {
											map[j][k] = 1;
											result--;
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	static int getOnePart(int startX, int startY) {
		minX = startX;
		maxX = startX;
		minY = startY;
		maxY = startY;
		cnt = 1;
		checkCnt = 0;
		list.clear();
		while (!queue.isEmpty()) {
			Position position = queue.poll();
			int x = position.x;
			int y = position.y;
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if (-1 < newX && newX < 10 && -1 < newY && newY < 10 && map[newX][newY] == 1 && !visit[newX][newY]) {
					visit[newX][newY] = true;
					cnt++;
					queue.add(new Position(newX, newY));
					minX = newX < minX ? newX : minX;
					maxX = newX > maxX ? newX : maxX;
					minY = newY < minY ? newY : minY;
					maxY = newY > maxY ? newY : maxY;
				}
			}
		}
		int xSize = maxX - minX + 1;
		int ySize = maxY - minY + 1;
		size = xSize < ySize ? xSize : ySize;
		size = 5 < size ? 5 : size;
//		System.out.println(minX + " " + maxX + " " + minY + " " + maxY)
		checkArr(0, 0);
		if (list.size() == 0)
			return -1;
		else {
			Collections.sort(list);
			ColorState colorState = list.get(0);
			result += colorState.useNum;
			for (int i = 0; i < 5; i++) {
				colorPaperCnt[i] = colorState.useArr[i];
			}
			return 0;
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		map = new int[10][10];
		visit = new boolean[10][10];
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				map[x][y] = scan.nextInt();
			}
		}
		boolean flag = false;
		for (int x = 0; x < 10; x++) {
			if (flag)
				break;
			for (int y = 0; y < 10; y++) {
				if (map[x][y] != 0 && !visit[x][y]) {
					queue.add(new Position(x, y));
					visit[x][y] = true;
					int state = getOnePart(x, y);
					System.out.println(state);
					if (state == -1) {
						flag = true;
						break;
					}
				}
			}
		}

		result = flag ? -1 : result;
		System.out.println(result);
	}
}
