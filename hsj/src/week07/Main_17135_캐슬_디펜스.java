package week07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_17135_캐슬_디펜스 {
	static int[] dx = { 0, -1, 0 };
	static int[] dy = { -1, 0, 1 };
	static int row = 0;
	static int cattleWid = 0;
	static int attackRange = 0;
	static int[] archerArr = null;
	static boolean[][] die = null;
	static int[][] map = null;
	static int killCnt = 0;
	static int stageCnt = 0;
	static boolean flag = false;
	static boolean[][] visit = null;
	static Queue<Integer> queue = new LinkedList<>();
	static List<Integer> list = new ArrayList<>();
	static Queue<Integer> dieQueue = new LinkedList<>();

	static void getKillNum() {
		die = new boolean[row][cattleWid];
		killCnt = 0;
		dieQueue.clear();
		for (int i = row; i > 0; i--) {
			while(!dieQueue.isEmpty()) {
				int x = dieQueue.poll();
				int y = dieQueue.poll();
				die[x][y] = true;
			}
			visit = new boolean[row][cattleWid];
			for (int j = 0; j < 3; j++) {
				queue.add(i);
				queue.add(archerArr[j]);
				while (!queue.isEmpty()) {
					flag = false;
					int attackCnt = 0;
					while (!flag) {
						int x = queue.poll();
						int y = queue.poll();
						if (attackCnt == 0) {
							int newX = x - 1;
							int newY = y;
							if ((-1 < newX && newX < i) && (-1 < newY && newY < cattleWid) && map[newX][newY] == 1 && !die[newX][newY]) {
								if (!visit[newX][newY]) {
									killCnt++;
									visit[newX][newY] = true;
									dieQueue.add(newX);
									dieQueue.add(newY);
								}
								flag = true;
							}
						} else {
							for (int k = 0; k < 3; k++) {
								int newX = x + dx[k];
								int newY = y + dy[k];
								if ((-1 < newX && newX < i) && (-1 < newY && newY < cattleWid) && (!die[newX][newY] && map[newX][newY] == 1)) {
									if (!visit[newX][newY]) {
										killCnt++;
										visit[newX][newY] = true;
										dieQueue.add(newX);
										dieQueue.add(newY);
										
									}
									flag = true;
									break;
								}
							}
						}
						if (!flag) {
							attackCnt++;
							if (attackCnt < attackRange) {
								queue.add(i - attackCnt);
								queue.add(archerArr[j]);
							} else {
								flag = true;
							}
						}
					}
				}
			}
		}
		System.out.println(killCnt);
		list.add(killCnt);

	}

	static void getArcherPosi(int idx, int cnt) {
		if (cnt == 3) {
			System.out.print(Arrays.toString(archerArr));
			getKillNum();
			return;
		} else {
			for (int i = idx; i < cattleWid; i++) {
				archerArr[cnt] = i;
				getArcherPosi(i + 1, cnt + 1);
				archerArr[cnt] = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		row = scan.nextInt();
		cattleWid = scan.nextInt();
		attackRange = scan.nextInt();
		map = new int[row + 1][cattleWid];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cattleWid; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		archerArr = new int[3];
		getArcherPosi(0, 0);
		getKillNum();
		Collections.sort(list);
		System.out.println(list.get(list.size() - 1));
	}
}
