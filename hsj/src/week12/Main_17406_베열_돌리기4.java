package week12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_17406_베열_돌리기4 {
	static int[][] map = null;
	static int[][] newMap = null;
	static int[][] cloneMap = null;
	static boolean[] visit = null;
	static List<int[]> list = new ArrayList<>();
	static int rotateCnt = 0;
	static int[] orderArr = null;
	static int xSize, ySize = 0;
	static int minResult = 5000;
	
	static void doMove(int x, int y, int idx) {
		int[] dx = {0, -1, 0, 1};
		int[] dy = {1, 0, -1, 0};
		int newX = x + dx[idx];
		int newY = y + dy[idx];
		newMap[newX][newY] = cloneMap[x][y];
	}
	
	static void getRotateOrder(int cnt) {
		if (cnt == rotateCnt) {
			for(int x = 0; x < xSize; x++) {
				for(int y = 0; y < ySize; y++) {
					newMap[x][y] = map[x][y];
					cloneMap[x][y] = map[x][y];
				}
			}
			
			for(int i = 0; i < rotateCnt; i++) {
				int[] arr = list.get(orderArr[i]);
				int startX = arr[0] - arr[2] - 1;
				int startY = arr[1] - arr[2] - 1;
				int finishX = arr[0] + arr[2] - 1;
				int finishY = arr[1] + arr[2] - 1;
				int newXSize = finishX - startX + 1;
				int newYSize = finishY - finishY + 1;
				int size = newYSize > newXSize ? newYSize/2 : newXSize/2;
				for(int j = 0; j < size; j++) {
					for(int x = startX + j; x <= finishX - j; x++) {
						for(int y = startY + j; y <= finishY - j; y++) {
							if(x == startX + j && y != finishY - j) doMove(x, y, 0);
							else if(x != startX + j && y == startY + j) doMove(x, y, 1);
							else if(x == finishX - j && y != startY + j) doMove(x, y, 2);
							else if(x != finishX - j && y == finishY - j) doMove(x, y, 3);
						}
					}
				}
				for(int x = startX; x <= finishX; x++) {
					for(int y = startY; y <= finishY; y++) {
						cloneMap[x][y] = newMap[x][y];
					}
				}
			}
			
			for(int x = 0; x < xSize; x++) {
				int sum = 0;
				for(int y = 0; y < ySize; y++) {
					sum += newMap[x][y];
				}
				if(minResult > sum) minResult = sum;
			}
			
			return;
		}
		for (int i = 0; i < rotateCnt; i++) {
			if (!visit[i]) {
				visit[i] = true;
				orderArr[cnt] = i;
				getRotateOrder(cnt + 1);
				orderArr[cnt] = 0;
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		xSize = scan.nextInt();
		ySize = scan.nextInt();
		rotateCnt = scan.nextInt();
		map = new int[xSize][ySize];
		newMap = new int[xSize][ySize];
		cloneMap = new int[xSize][ySize];
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				map[x][y] = scan.nextInt();
			}
		}
		for (int i = 0; i < rotateCnt; i++) {
			int[] arr = new int[3];
			for (int j = 0; j < 3; j++) {
				arr[j] = scan.nextInt();
			}
			list.add(arr);
		}
		
		visit = new boolean[rotateCnt];
		orderArr = new int[rotateCnt];
		getRotateOrder(0);
		System.out.println(minResult);
	}
}
