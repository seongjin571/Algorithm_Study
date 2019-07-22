package week07;

import java.util.ArrayList;
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
		for (int i = row; i > 0; i--) { // 각 스테이지 별로 게임 진행
			while (!dieQueue.isEmpty()) {  //좀 전의 스테이지에서 죽은 적들 체크
				int x = dieQueue.poll();
				int y = dieQueue.poll();
				die[x][y] = true;
			}
			boolean[][] visit = new boolean[row][cattleWid];
			for (int j = 0; j < 3; j++) { // 궁수 한명씩 시작
				archerQueue.add(i);
				archerQueue.add(archerArr[j]);
				archerQueue.add(0);
				while (!archerQueue.isEmpty()) { // 한 궁수가 한명 죽이거나, 거리내에 없으면 탈출
					int x = archerQueue.poll();
					int y = archerQueue.poll();
					int attackLen = archerQueue.poll();
					for (int k = 0; k < 3; k++) {
						int newX = x + dx[k];
						int newY = y + dy[k];
						if (newX != i && (-1 < newX && -1 < newY && newY < cattleWid)) {
							if (map[newX][newY] == 1 && !die[newX][newY]) { //적이 있는 위치이고 아직 안죽은 적인 경우
								if (!visit[newX][newY]) { //죽었다고 체크되어있지 않고 이번 스테이지에서도 안죽은 적일 경우
									killCnt++;
									visit[newX][newY] = true; //이번판에서 죽음 => 옆에 궁수가 동시에 죽여도 죽인수 늘어나지 않도록 
									dieQueue.add(newX);
									dieQueue.add(newY);
								}
								archerQueue.clear(); //적을 죽였을때 queue초기화 하고 while 탈출 후 다음 궁수 혹은 다음 스테이지 진행
								break;
							} 
							
							else if(attackLen + 1 < attackRange){ // 해당 좌표에 적이 없었을 때 아직 최대 공격범위보다 공격범위가 적을 시 해당 좌표를 큐에 넣어준다.=>공격 범위+1
								archerQueue.add(newX);
								archerQueue.add(newY);
								archerQueue.add(attackLen + 1);
							}
						}
					}
				}
			}
		}
		list.add(killCnt);

	}

	static void getArcherPosi(int idx, int cnt) {
		if (cnt == 3) {
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
