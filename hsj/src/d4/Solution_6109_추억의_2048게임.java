package d4;

import java.util.Scanner;

public class Solution_6109_추억의_2048게임 {
	static int[][] map = null;
	static String oper = "";
	static int squareSize = 0;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visit = null;
	
	static void do2048(int x, int y, int idx) {
		int newX = x + dx[idx];
		int newY = y + dy[idx];
		if(-1 < newX && newX < squareSize && -1 < newY && newY < squareSize) {
			if(map[newX][newY] == map[x][y] && !visit[newX][newY]) {
				map[newX][newY] *= 2;
				map[x][y] = 0;
				visit[newX][newY] = true;
			}
			else if(map[newX][newY] == 0) {
				map[newX][newY] = map[x][y];
				map[x][y] = 0;
				do2048(newX, newY, idx);
			}
		}
	}
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for(int i = 1; i <= testCnt; i++) {
			squareSize = scan.nextInt();
			oper = scan.next();
			map = new int[squareSize][squareSize];
			visit = new boolean[squareSize][squareSize];
			for(int k = 0; k < squareSize; k++) {
				for(int j = 0; j < squareSize; j++) {
					map[k][j] = scan.nextInt();
				}
			}
			if(oper.equals("up") || oper.equals("left")) {
				int idx = 0;
				if(oper.equals("up")) idx = 0;
				else idx = 3;
				for(int k = 0; k < squareSize; k++) {
					for(int j = 0; j < squareSize; j++) {
						if(map[k][j] != 0)
							do2048(k, j, idx);		
					}
				}
			}
			else {
				int idx = 0;
				if(oper.equals("right")) idx = 1;
				else idx = 2;
				for(int k = squareSize - 1; k >= 0; k--) {
					for(int j = squareSize - 1; j >= 0; j--) {
						if(map[k][j] != 0)
							do2048(k, j, idx);
					}
				}
			}
			
			System.out.println("#" + i);
			for(int x = 0; x < squareSize; x++) {
				for(int y = 0; y < squareSize; y++) {
					System.out.print(map[x][y] + " ");
				}
				System.out.println("");
			}
		}
	}
}
