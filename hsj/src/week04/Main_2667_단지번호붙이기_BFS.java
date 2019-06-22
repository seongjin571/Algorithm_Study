package week04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_2667_단지번호붙이기_BFS {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Scanner scan = new Scanner(System.in);
	static final int squareSize = scan.nextInt();
	static boolean[][] visit = new boolean[squareSize][squareSize];
	static int[][] house = new int[squareSize][squareSize];
	static Queue<Integer> queue = new LinkedList<>();
	static int count;

	static void checkPosition(int iRoad, int jRoad) {
		if (house[iRoad][jRoad] == 1 && !visit[iRoad][jRoad]) {
			visit[iRoad][jRoad] = true;
			queue.add(iRoad);
			queue.add(jRoad);
			count++;
		}
	}

	static void getOneComplex(List<Integer> houseList) {
		count = 1;
		while (!queue.isEmpty()) {
			int iRoad = queue.poll();
			int jRoad = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextI = iRoad + dx[i];
				int nextJ = jRoad + dy[i];
				if((-1<nextI && nextI<squareSize) && (-1<nextJ && nextJ<squareSize))
					checkPosition(nextI, nextJ);
			}
		}
		houseList.add(count);
	}

	static void searchComplex() {
		List<Integer> houseList = new ArrayList<>();
		int totalComplexNum = 0;
		for (int iRoad = 0; iRoad < squareSize; iRoad++) {
			for (int jRoad = 0; jRoad < squareSize; jRoad++) {
				if (house[iRoad][jRoad] == 1 && !visit[iRoad][jRoad]) {
					visit[iRoad][jRoad] = true;
					queue.add(iRoad);
					queue.add(jRoad);
					totalComplexNum++;
					getOneComplex(houseList);
				}
			}
		}
		System.out.println(totalComplexNum);
		Collections.sort(houseList);
		for (int i : houseList)
			System.out.println(i);
	}

	public static void main(String[] args) {
		for (int i = 0; i < squareSize; i++) {
			String rowNum = scan.next();
			for (int j = 0; j < squareSize; j++) {
				house[i][j] = rowNum.charAt(j) - '0';
			}
		}
		searchComplex();
	}
}
