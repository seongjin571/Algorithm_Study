package week07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_17135_캐슬_디펜스 {
	static int row = 0;
	static int cattleWid = 0;
	static int attackRange = 0;
	static int[] archerArr = null;
	static int[][] map = null;
	static List<Integer> list = new ArrayList<>();

	static void getKillNum() {
		int[] dx = { 0, -1, 0 };
		int[] dy = { -1, 0, 1 };
		Queue<Integer> archerQueue = new LinkedList<>();
		Queue<Integer> dieQueue = new LinkedList<>();
		boolean[][] die = new boolean[row][cattleWid];
		int killCnt = 0;
		for (int i = row; i > 0; i--) { //각 스테이지 별로
			while (!dieQueue.isEmpty()) {
				int x = dieQueue.poll();
				int y = dieQueue.poll();
				die[x][y] = true;
			}
			boolean[][] visit = new boolean[row][cattleWid];
			for (int j = 0; j < 3; j++) { //궁수 한명씩 시작
				archerQueue.add(i);
				archerQueue.add(archerArr[j]);
				int attackLen = 0;
				boolean flag = false;
				while (!archerQueue.isEmpty()) { // 한 궁수가 한명 죽이거나, 거리내에 없으면 탈출
					int x = archerQueue.poll();
					int y = archerQueue.poll();
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
							archerQueue.add(i - attackLen);
							archerQueue.add(archerArr[j]);
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
