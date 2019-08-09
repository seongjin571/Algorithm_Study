package week11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_15686_치킨_배달 {
	static int totalStoreNum = 0; 
	static int storeNum = 0;
	static int mapSize = 0;
	static int[] arr = null;
	static int[][] map = null;
	static List<Integer> list = new ArrayList<>();
	static Queue<Integer> queue = new LinkedList<>();
	static boolean[][] visit = null;
	static int minRoad = 10000;
	static int roadDistance = 0;
	
	static void findStore() {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		while(!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			int distance = queue.poll();
			for(int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if(-1 < newX && newX < mapSize && -1 < newY && newY < mapSize && !visit[newX][newY]) {
					if(map[newX][newY] == 2) {
						roadDistance += distance + 1;
						return;
					}
					else {
						visit[newX][newY] = true;
						queue.add(newX);
						queue.add(newY);
						queue.add(distance+1);
					}
					
				}
			}
		}
	}
	
	static void nCr(int idx, int cnt) {
		if(cnt == storeNum) {
			for(int i = 0; i < storeNum; i++) {
				int x = list.get(arr[i]*2);
				int y = list.get(arr[i]*2 + 1);
				map[x][y] = 2;
			}
			roadDistance = 0;
			for(int x = 0; x < mapSize; x++) {
				for(int y = 0; y < mapSize; y++) {
					if(map[x][y] == 1) {
						visit[x][y] = true;
						queue.add(x);
						queue.add(y);
						queue.add(0);
						findStore();
						visit = new boolean[mapSize][mapSize];
						queue.clear();
					}
				}
			}
			if(roadDistance < minRoad) minRoad = roadDistance;
			
			for(int i = 0; i < storeNum; i++) {
				int x = list.get(arr[i]*2);
				int y = list.get(arr[i]*2 + 1);
				map[x][y] = 0;
			}
			return;
			
		}
		for(int i = idx; i < totalStoreNum; i++) {
			arr[cnt] = i;
			nCr(i + 1, cnt + 1);
			arr[cnt] = 0;
		}
	}
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		mapSize = scan.nextInt();
		storeNum = scan.nextInt();
		map = new int[mapSize][mapSize];
		visit = new boolean[mapSize][mapSize];
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				map[i][j] = scan.nextInt();
				if(map[i][j] == 2) {
					map[i][j] = 0;
					list.add(i);
					list.add(j);
				}
			}
		}
		arr = new int[storeNum];
		totalStoreNum = list.size()/2;
		nCr(0, 0);
		System.out.println(minRoad);
		
	}
}
