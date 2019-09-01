package week15;

import java.util.Scanner;

public class Main_14503_로봇_청소기 {
	public static void main(String[]args) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		Scanner scan = new Scanner(System.in);
		int result = 0;
		int xSize = scan.nextInt();
		int ySize = scan.nextInt();
		int xPosi = scan.nextInt();
		int yPosi = scan.nextInt();
		int direct = scan.nextInt();
		boolean[][] visit = new boolean[xSize][ySize];
		int[][] map = new int[xSize][ySize];
		for(int x = 0; x < xSize; x++) {
			for(int y = 0; y < ySize; y++) {
				map[x][y] = scan.nextInt();
			}
		}
		visit[xPosi][yPosi] = true;
		result++;
		
		while(true) {
			boolean flag = false;
			for(int i = 0; i < 4; i++) {
				direct--;
				direct = direct < 0 ? 3: direct;
				int newX = xPosi + dx[direct];
				int newY = yPosi + dy[direct];
				if(-1 < newX && newX < xSize && -1 < newY && newY < ySize && map[newX][newY] != 1 && !visit[newX][newY]) {
					xPosi = newX;
					yPosi = newY;
					visit[xPosi][yPosi] = true;
					result++;
					flag = true;
					break;
				}
			}
			if(!flag) {
				int newX = xPosi - dx[direct];
				int newY = yPosi - dy[direct];
				if(-1 < newX && newX < xSize && -1 < newY && newY < ySize && map[newX][newY] != 1) {
					xPosi = newX;
					yPosi = newY;
				}
				else {
					break;
				}
			}
		}
		System.out.println(result);
	}
}
