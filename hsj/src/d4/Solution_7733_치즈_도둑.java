package d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_7733_치즈_도둑 {
	static int[][] map = null;
	static boolean[][] visit = null;
	static Queue<Integer> queue = new LinkedList<>();
	static int piece;
	static int squareSize;

	static void doBFS() {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		while(!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			for(int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if(-1 < newX && newX < squareSize && -1 < newY && newY < squareSize && map[newX][newY] != 0 && !visit[newX][newY]) {
					visit[newX][newY] = true;
					queue.add(newX);
					queue.add(newY);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			int maxPiece = 0;
			squareSize = scan.nextInt();
			map = new int[squareSize][squareSize];
			int maxNum = 0;
			for (int x = 0; x < squareSize; x++) {
				for (int y = 0; y < squareSize; y++) {
					map[x][y] = scan.nextInt();
					if (maxNum < map[x][y])
						maxNum = map[x][y];
				}
			}
			int cnt = 0;
			while (cnt < maxNum) {
				visit = new boolean[squareSize][squareSize];
				piece = 0;
				cnt++;
				for (int x = 0; x < squareSize; x++) {
					for (int y = 0; y < squareSize; y++) {
						if (map[x][y] == cnt)
							map[x][y] = 0;
					}
				}
				for (int x = 0; x < squareSize; x++) {
					for (int y = 0; y < squareSize; y++) {
						if (map[x][y] != 0 && !visit[x][y]) {
							visit[x][y] = true;
							queue.add(x);
							queue.add(y);
							piece++;
							doBFS();
						}
					}
				}
				if(maxPiece < piece) maxPiece = piece;
				if(maxPiece == 0) maxPiece = 1;
			}
			System.out.println("#" + i + " " + maxPiece);
		}
	}
}
