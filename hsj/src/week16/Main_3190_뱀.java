package week16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Move {
	int time;
	String direct;

	Move(int time, String direct) {
		this.time = time;
		this.direct = direct;
	}
}

class Snake {
	int x;
	int y;

	Snake(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_3190_뱀 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		List<Move> moveList = new ArrayList<>();
		List<Snake> snakeList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		int mapSize = scan.nextInt();
		int appleNum = scan.nextInt();
		int[][] map = new int[mapSize][mapSize];
		for (int i = 0; i < appleNum; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			map[x - 1][y - 1] = 1;
		}
		int moveNum = scan.nextInt();
		for (int i = 0; i < moveNum; i++) {
			int cnt = scan.nextInt();
			String direct = scan.next();
			moveList.add(new Move(cnt, direct));
		}
		map[0][0] = 2;
		snakeList.add(new Snake(0, 0));
		int idx = 3;
		int time = 0;
		int moveListIdx = 0;
		int nextPoint = moveList.get(0).time;
		String nextDirect = moveList.get(0).direct;
		
		while (true) {
			time++;
			Snake snakeHead = snakeList.get(snakeList.size() - 1);
			int newX = snakeHead.x + dx[idx];
			int newY = snakeHead.y + dy[idx];
			snakeList.add(new Snake(newX, newY));
			if (mapSize <= newX || newX < 0 || mapSize <= newY || newY < 0 || map[newX][newY] == 2) {
				break;
			} else if (map[newX][newY] == 1) {
				map[newX][newY] = 2;
			} else {
				map[newX][newY] = 2;
				Snake snakeTail = snakeList.get(0);
				map[snakeTail.x][snakeTail.y] = 0;
				snakeList.remove(0);
			}
			
			if (time == nextPoint) {
				if (nextDirect.equals("L")) idx = (idx + 1) % 4;
				else idx = (idx + 3) % 4;
				moveListIdx++;
				if (moveListIdx < moveList.size()) {
					nextPoint = moveList.get(moveListIdx).time;
					nextDirect = moveList.get(moveListIdx).direct;
				}
			}
		}
		System.out.println(time);
	}
}
