package week11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_15683_감시 {
	static int[][][] dx = { 
			{ { -1 }, { 0 }, { 1 }, { 0 } }, 
			{ { 1, -1 }, { 0, 0 } },
			{ { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }, 
			{ { -1, 0, 0 }, { -1, 0, 1 }, { 0, 1, 0 }, { 1, 0, -1 } },
			{ { -1, 0, 1, 0} } 
			};
	static int[][][] dy = { 
			{ { 0 }, { 1 }, { 0 }, { -1 } }, 
			{ { 0, 0 }, { 1, -1 } },
			{ { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }, 
			{ { 0, 1, -1 }, { 0, 1, 0 }, { 1, 0, -1 }, { 0, -1, 0 } },
			{ { 0, 1, 0, -1} }
			};

	static int[][] stateMap = null;
	static int[][] map = null;
	static int xSize = 0;
	static int ySize = 0;
	static int noCctvCnt = 0;
	static int minCctvCnt = 64;
	static int cctvNum = 0;
	static List<Integer> list = new ArrayList<>();

	static void doMove(int x, int y, int cctv, int j, int k) {
		System.out.println("x: " + x + " y: " + y);
		int newX = x + dx[cctv - 1][j][k];
		int newY = y + dy[cctv - 1][j][k];
		if(-1 < newX && newX < xSize && -1 < newY && newY < ySize && map[newX][newY] != 6) {
			if(stateMap[newX][newY] != 2 && cctv != 5) stateMap[newX][newY] = 3;
			else if(stateMap[newX][newY] != 2 && cctv == 5) stateMap[newX][newY] = 5;
			doMove(newX, newY, cctv, j, k);
		}else {
			return;
		}
	}
	
	static void doDFS(int cnt, int idx) {
		if (cnt == cctvNum) {
			int noCctvCnt = 0;
			for (int x = 0; x < xSize; x++) {
				for (int y = 0; y < ySize; y++) {
					if(stateMap[x][y] == 0) {
						noCctvCnt++;
					}
				}
			}
			System.out.println("aa " + noCctvCnt);
			for (int x = 0; x < xSize; x++) {
				for (int y = 0; y < ySize; y++) {
					if(stateMap[x][y] == 3) stateMap[x][y] = 0;
				}
			}
			if(minCctvCnt > noCctvCnt) minCctvCnt = noCctvCnt;
			return;
		}
		
		for(int i = idx; i < cctvNum; i++) {
			int x = list.get(i*2);
			int y = list.get(i*2 + 1);
			
			int cctv = map[x][y];
			System.out.println(cctv);
			for(int j = 0; j < dx[cctv - 1].length; j++) {
				for(int k = 0; k < dx[cctv - 1][0].length; k++) {
					doMove(x, y, cctv, j, k);
				}
				doDFS(i + 1, cnt + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		xSize = scan.nextInt();
		ySize = scan.nextInt();
		map = new int[xSize][ySize];
		stateMap = new int[xSize][ySize];
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				map[x][y] = scan.nextInt();
				if (map[x][y] != 0 && map[x][y] != 6) {
					list.add(x);
					list.add(y);
					stateMap[x][y] = 2;
				}
				if (map[x][y] == 6) {
					stateMap[x][y] = 6;
				}
			}
		}

		cctvNum = list.size()/2;
		for(int i = 0; i < cctvNum; i++) {
			int x = list.get(i*2);
			int y = list.get(i*2 + 1);
			if(map[x][y] == 5) {
				for(int j = 0; j < 4; j++) {
					doMove(x, y, 5, 0, j);
				}
				list.remove(i*2);
				list.remove(i*2);
				i--;
				cctvNum--;
			}

		}
		for(int i: list) {
			System.out.println(i);
		}
		doDFS(0, 0);
		System.out.println(minCctvCnt);
	}
}
