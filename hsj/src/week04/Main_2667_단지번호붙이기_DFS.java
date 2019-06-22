package week04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_2667_단지번호붙이기_DFS {
	static Scanner scan = new Scanner(System.in);
	static int squareSize = scan.nextInt();
	static int[][] map = new int[squareSize][squareSize];
	static boolean[][] visit = new boolean[squareSize][squareSize];
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	static int complexNum = 0;
	static int count = 0;
	static List<Integer> complexCount = new ArrayList<>();
	static void dfs(int i, int j) {
		for(int k = 0; k < 4; k++) {
			int newI = i + di[k];
			int newJ = j + dj[k];
			if((-1<newI && newI<squareSize) && (-1<newJ && newJ<squareSize) && (map[newI][newJ] == 1 && visit[newI][newJ] == false)){
				visit[newI][newJ] = true;
				count++;
				dfs(newI, newJ);
			}
		}
	}
	public static void main(String[]args) {
		for(int i = 0; i < squareSize; i++) {
			String rowNum = scan.next();
			for(int j = 0; j < squareSize; j++) {
				map[i][j] = rowNum.charAt(j) - '0';
			}
		}
		for(int i = 0; i < squareSize; i++) {
			for(int j = 0; j < squareSize; j++) {
				if(map[i][j] == 1 && visit[i][j] == false) {
					visit[i][j] = true;
					complexNum++;
					count = 1;
					dfs(i, j);
					complexCount.add(count);
				}
			}
		}
		Collections.sort(complexCount);
		System.out.println(complexNum);
		for(int i : complexCount)
			System.out.println(i);
	}
}
