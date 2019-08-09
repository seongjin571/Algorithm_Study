package week11;

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
	static void getRoad() {
		
	}
	
	static void nCr(int idx, int cnt) {
		if(cnt == storeNum) {
			for(int i = 0; i < storeNum; i++) {
				int x = list.get(arr[i]);
				int y = list.get(arr[i + 1]);
				map[x][y] = 2;
			}
			
			getRoad();
			
			for(int i = 0; i < storeNum; i++) {
				int x = list.get(arr[i]);
				int y = list.get(arr[i + 1]);
				map[x][y] = 0;
			}
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
		
		
	}
}
