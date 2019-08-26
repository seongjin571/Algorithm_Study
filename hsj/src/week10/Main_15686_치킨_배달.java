package week10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_15686_치킨_배달 {
	static int totalStoreNum = 0; 
	static int storeNum = 0;
	static int mapSize = 0;
	static int[] arr = null;
	static int[][] map = null;
	static List<Integer> list = new ArrayList<>();
	static int minRoad = 10000;
	static int roadDistance = 0;
	static int mapCnt = 2;
	
	static void nCr(int idx, int cnt) {
		if(cnt == storeNum) {
			for(int i = 0; i < storeNum; i++) {
				int x = list.get(arr[i]*2);
				int y = list.get(arr[i]*2 + 1);
				map[x][y] = mapCnt;
			}
			
			roadDistance = 0;
			for(int x = 0; x < mapSize; x++) {
				for(int y = 0; y < mapSize; y++) {
					if(map[x][y] == 1) {
						int minDistance = 1000;
						for(int i = 0; i < storeNum; i++) {
							int storeX = list.get(arr[i]*2);
							int storeY = list.get(arr[i]*2 + 1);
							int distance = Math.abs(storeX - x) + Math.abs(storeY - y);
							if(distance < minDistance) minDistance = distance;
						}
						roadDistance += minDistance;
					}
				}
			}
			mapCnt++;
			if(roadDistance < minRoad) minRoad = roadDistance;
			
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
