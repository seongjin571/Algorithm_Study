package week15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17144_미세먼지안녕 {
	public static void main(String[]args) {
		Queue<Integer> queue = new LinkedList<>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int[] arr = new int[4];
		Scanner scan = new Scanner(System.in);
		int xSize = scan.nextInt();
		int ySize = scan.nextInt();
		int time = scan.nextInt();
		int[][] map = new int[xSize][ySize];
		int[][] dirtMap = new int[xSize][ySize];
		int arrIdx = 0;
		for(int x = 0; x < xSize; x++) {
			for(int y = 0; y < ySize; y++) {
				map[x][y] = scan.nextInt();
				if(map[x][y] == -1) {
					arr[arrIdx++] = x;
					arr[arrIdx++] = y;
				}
				else if(map[x][y] != 0) {
					queue.add(x);
					queue.add(y);
				}
			}
		}
		for(int t = 0; t < time; t++) {
			while(!queue.isEmpty()) {
				int x = queue.poll();
				int y = queue.poll();
				int cnt = 0;
				int size = map[x][y]/5;
				for(int i = 0; i < 4; i++) {
					int newX = x + dx[i];
					int newY = y + dy[i];
					if(-1 < newX && newX < xSize && -1 < newY && newY < ySize) {
						if(map[newX][newY] == 0) {
							map[newX][newY] = size;
							cnt++;
						}
						else if(map[newX][newY] != -1) {
							dirtMap[newX][newY] += size;
							cnt++;
						}
					}
				}
				map[x][y] = map[x][y] - (size * cnt);
			}
			for(int x = 0; x < xSize; x++) {
				for(int y = 0; y < ySize; y++) {
					if(dirtMap[x][y] != 0) {
						map[x][y] += dirtMap[x][y];
						dirtMap[x][y] = 0;
					}
				}
			}
			
			int newX = arr[0] - 1;
			int newY = arr[1];
			map[newX][newY] = 0;
			int idx = 0;
			while(true) {
				newX += dx[idx];
				newY += dy[idx];
				if(newX == arr[0] && newY == arr[1]) break;
				if(-1 < newX && newX <= arr[0] && -1 < newY && newY < ySize) {
					int beforeX = newX - dx[idx];
					int beforeY = newY - dy[idx];
					map[beforeX][beforeY] = map[newX][newY];
					map[newX][newY] = 0;
				}else {
					newX -= dx[idx];
					newY -= dy[idx];
					idx++;
				}
			}
			
			newX = arr[2] + 1;
			newY = arr[3];
			map[newX][newY] = 0;
			idx = 2;
			while(true) {
				newX += dx[idx];
				newY += dy[idx];
				if(newX == arr[2] && newY == arr[3]) break;
				if(arr[2] <= newX && newX < xSize && -1 < newY && newY < ySize) {
					int beforeX = newX - dx[idx];
					int beforeY = newY - dy[idx];
					map[beforeX][beforeY] = map[newX][newY];
					map[newX][newY] = 0;
				}else {
					newX -= dx[idx];
					newY -= dy[idx];
					idx--;
					idx = idx < 0 ? 3 : idx;
				}
			}
			for(int x = 0; x < xSize; x++) {
				for(int y = 0; y < ySize; y++) {
					if(map[x][y] > 0) {
						queue.add(x);
						queue.add(y);
					}
				}
			}
		}
		
		int sum = 0;
		for(int x = 0; x < xSize; x++) {
			for(int y = 0; y < ySize; y++) {
				if(map[x][y] > 0) sum += map[x][y];
			}
		}
		System.out.println(sum);
	}
}
