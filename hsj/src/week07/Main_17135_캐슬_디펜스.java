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
	static boolean flag = false;
	static boolean[][] visit = null;
	static int enemyNum = 0;
	static Queue<Integer> queue = new LinkedList<>();
	static List<Integer> list = new ArrayList<>();
	static Queue<Integer> dieQueue = new LinkedList<>();

	static void getKillNum() {
		die = new boolean[row][cattleWid];
		killCnt = 0;
		dieQueue.clear();
		for (int i = row; i > 0; i--) { //각 스테이지 별로
			while (!dieQueue.isEmpty()) {
				int x = dieQueue.poll();
				int y = dieQueue.poll();
				die[x][y] = true;
			}
			visit = new boolean[row][cattleWid];
			for (int j = 0; j < 3; j++) { //궁수 한명씩 시작
				queue.add(i);
				queue.add(archerArr[j]);
				int attackLen = 0;
				flag = false;
				while (!queue.isEmpty()) { // 한 궁수가 한명 죽이거나, 거리내에 없으면 탈출
					int x = queue.poll();
					int y = queue.poll();
					int newX;
					int newY;
					for (int k = 0; k < 3; k++) {
						if (attackLen == 0) {
							newX = x - 1;
							newY = y;
						} else {
							newX = x + dx[k];
							newY = y + dy[k];
						}
						if (-1 < newX && -1 < newY && newY < cattleWid && map[newX][newY] == 1 && !die[newX][newY]) {
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

					if (!flag) {
						attackLen++;
						if (attackLen < attackRange) {
							queue.add(i - attackLen);
							queue.add(archerArr[j]);
						} 
					}
					
				}
			}
		}
		list.add(killCnt);
		System.out.println(killCnt);
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
		Collections.sort(list);
		System.out.println(list.get(list.size() - 1));
	}
}
