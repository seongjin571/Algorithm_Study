package week10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Bee {
	int x, y, beeSize;

	Bee(int x, int y, int beeSize) {
		this.x = x;
		this.y = y;
		this.beeSize = beeSize;
	}
}

public class Solution_2115_벌꿀채취 {
	static int[][] map = null;
	static int beeCnt = 0;
	static int maxBee = 0;
	static int[] beeArr = null;
	static int maxNum = 0;
	static List<Bee> list = new ArrayList<>();
	static List<Integer> beeList = new ArrayList<>();
	static int[] arr = new int[2];
	
	static void doDFSBee(int idx, int cnt) {
		if(cnt == 2) {
			Bee bee1 = list.get(arr[0]);
			Bee bee2 = list.get(arr[1]);
			int yDis = Math.abs(bee1.y - bee2.y);
			if(bee1.x != bee2.x || yDis >= beeCnt) {
				beeList.add(bee1.beeSize + bee2.beeSize);
			}
			return;
		}
		for(int i = idx; i < list.size(); i++) {
			arr[cnt] = i;
			doDFSBee(i + 1, cnt + 1);
			arr[cnt] = 0;
		}
	}
	
	static void doDFS(int x, int y, int size, int idx, int cnt) {
		if(cnt == size) {
			int sum = 0;
			for(int i = 0; i < cnt; i++) {
				sum += map[x][y + beeArr[i]];
			}
			int num = 0;
			if(sum <= maxBee) {
				for(int i = 0; i < cnt; i++) {
					num += map[x][y + beeArr[i]] * map[x][y + beeArr[i]];
					if(num > maxNum) maxNum = num;
				}
			}
			return;
		}
		for(int i = idx; i < beeCnt; i++) {
			beeArr[cnt] = i;
			doDFS(x, y, size, i + 1, cnt + 1);
			beeArr[cnt] = 0;
		}
	}
	
	static void getMaxBee(int x, int y) {
		int sum = 0;
		maxNum = 0;
		for (int i = 0; i < beeCnt; i++) {
			sum += map[x][y + i];
		}
		
		if (sum <= maxBee) {
			for (int i = 0; i < beeCnt; i++) {
				maxNum += map[x][y + i] * map[x][y + i];
			}
			list.add(new Bee(x, y, maxNum));
		}
		else {
			for(int i = 0; i < beeCnt; i++) {
				int num = map[x][y + i] * map[x][y + i];
				if(maxNum < num) maxNum = num;
			}
			
			for(int i = 2; i < beeCnt; i++) {
				beeArr = new int[i];
				doDFS(x, y, i, 0, 0);
			}
			list.add(new Bee(x, y, maxNum));
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			list.clear();
			beeList.clear();
			int mapSize = scan.nextInt();
			map = new int[mapSize][mapSize];
			beeCnt = scan.nextInt();
			maxBee = scan.nextInt();
			for (int j = 0; j < mapSize; j++) {
				for (int k = 0; k < mapSize; k++) {
					map[j][k] = scan.nextInt();
				}
			}
			for (int x = 0; x < mapSize; x++) {
				for (int y = 0; y < mapSize - beeCnt + 1; y++) {
					getMaxBee(x, y);
				}
			}
			
			doDFSBee(0, 0);
			Collections.sort(beeList);
			System.out.println("#" + i + " " + beeList.get(beeList.size() - 1));
		}
	}
}
