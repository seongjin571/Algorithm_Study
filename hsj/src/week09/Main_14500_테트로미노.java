package week09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_14500_테트로미노 {
	static int[][] map = null;
	static boolean [][] visit = null;
	static int xSize = 0;
	static int ySize = 0;
	static List<Integer> list = new ArrayList<>();
	static int[] dx = {0, 1, 0};
	static int[] dy = {1, 0, -1};
	static void getSpecCase(int x, int y) {
		int sum = 0;
		if(x + 1 < xSize && y + 2 < ySize) {
			sum = map[x][y] + map[x+1][y+1] + map[x][y+1] + map[x][y+2];
			list.add(sum);
		}
		if(x - 1 >= 0 && y + 2 < ySize) {
			sum = map[x][y] + map[x-1][y+1] + map[x][y+1] + map[x][y+2];
			list.add(sum);
		}
		if(x + 2 < xSize && y + 1 < ySize) {
			sum = map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y+1];
			list.add(sum);
		}
		if(x + 2 < xSize && y - 1 >= 0) {
			sum = map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y-1];
			list.add(sum);
		}
		
	}
	
	static void doDFS(int x, int y, int cnt, int sum) {
		if(cnt == 4) {
			list.add(sum);
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(-1 < newX && newX < xSize && -1 < newY && newY < ySize && !visit[newX][newY]) {
				visit[newX][newY] = true;
				doDFS(newX, newY, cnt+1, sum + map[newX][newY]);
				visit[newX][newY] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		xSize = scan.nextInt();
		ySize = scan.nextInt();
		map = new int[xSize][ySize];
		visit = new boolean[xSize][ySize];
		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				getSpecCase(i, j);
				visit[i][j] = true;
				doDFS(i, j, 1, map[i][j]);
				visit[i][j] = false;
			}
		}
		
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
	}
}
