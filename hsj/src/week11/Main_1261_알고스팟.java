package week11;

import java.util.Scanner;

public class Main_1261_알고스팟 {
	static int[][] map = null;
	static boolean[][] visit = null;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int xSize = 0;
	static int ySize = 0;
	static int minCnt = 0;
	
	static void getMinNum(int x, int y, int cnt) {
		if(minCnt <= cnt) return;
		for(int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(-1 < newX && newX < xSize && -1 < newY && newY < ySize && !visit[newX][newY]) {
				int newCnt = (map[newX][newY] == 1) ? cnt+1 : cnt;
				if(minCnt <= newCnt) continue;
				if(newX != xSize - 1 || newY != ySize - 1) {
					visit[newX][newY] = true;
					getMinNum(newX, newY, newCnt);
					visit[newX][newY] = false;
				}
				
				else{
					if(cnt < minCnt) minCnt = cnt;
				}
			}
		}
	}
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		ySize = scan.nextInt();
		xSize = scan.nextInt();
		minCnt = ySize * xSize;
		map = new int[xSize][ySize];
		visit = new boolean[xSize][ySize];
		for(int x = 0; x < xSize; x++) {
			String str = scan.next();
			for(int y = 0; y < ySize; y++) {
				map[x][y] = str.charAt(y) - '0';
			}
		}
		visit[0][0] = true;
		getMinNum(0, 0, 0);
		System.out.println(minCnt);
	}
}
