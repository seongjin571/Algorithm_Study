package week04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1227_미로2 {
	static int[][] map = new int[100][100];
	static boolean[][] visit;
	static Queue<Integer> queue = new LinkedList<>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int doBFS() {
		while (!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if ((-1 < x && x < 100) && (-1 < y && y < 100) && (map[newX][newY] != 1 && visit[newX][newY] == false)) {
					if (map[newX][newY] == 3) {
						return 1;
					} else {
						queue.add(newX);
						queue.add(newY);
						visit[newX][newY] = true;
					}
				}
			}
			
		}
		
		return 0;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int count = scan.nextInt();
			queue.clear();
			visit = new boolean[100][100];
			for(int j = 0; j < 100; j++) {
				String rowString = scan.next();
				for(int k = 0; k < 100; k++) {
					map[j][k] = rowString.charAt(k) - '0';
				}
			}
			visit[1][1] = true;
			queue.add(1);
			queue.add(1);
			System.out.println("#" + i + " " + doBFS());
		}
	}
}
