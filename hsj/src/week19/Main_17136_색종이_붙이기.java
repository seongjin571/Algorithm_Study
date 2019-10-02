package week19;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main_17136_색종이_붙이기 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map = null;
	static boolean[][] visit = null;
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> paperQueue = new LinkedList<>();
	static void getOnePart(int startX, int startY) {
		int minX = startX;
		int maxX = startX;
		int minY = startY;
		int maxY = startY;
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			int x = point.x;
			int y = point.y;
			for(int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if(-1 < newX && newX < 10 && -1 < newY && newY < 10 && map[newX][newY] == 1 && !visit[newX][newY]) {
					visit[newX][newY] = true;
					queue.add(new Point(newX, newY));
					minX = newX < minX ? newX : minX;
					maxX = newX > maxX ? newX : maxX;
					minY = newY < minY ? newY : minY;
					maxY = newY > maxY ? newY : maxY;
					paperQueue.add(new Point(newX, newY));
				}
			}
		}
		
	}
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		map = new int[10][10];
		visit = new boolean[10][10];
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				map[x][y] = scan.nextInt();
			}
		}
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				if(map[x][y] != 0 && !visit[x][y]) {
					queue.add(new Point(x, y));
					visit[x][y] = true;
					paperQueue.add(new Point(x, y));
					getOnePart(x, y);
					
				}
			}
		}
	}
}
