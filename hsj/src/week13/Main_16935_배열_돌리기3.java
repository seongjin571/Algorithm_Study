package week13;

import java.util.Scanner;

public class Main_16935_배열_돌리기3 {
	static int xSize = 0;
	static int ySize = 0;
	static int operCnt = 0;
	static int[][] map = null;
	static int[][] newMap = null;

	static void operOne() {
		for (int x = 0; x < xSize / 2; x++) {
			for (int y = 0; y < ySize; y++) {
				int temp = newMap[x][y];
				newMap[x][y] = newMap[xSize - 1 - x][y];
				map[x][y] = map[xSize - 1 - x][y];
				newMap[xSize - 1 - x][y] = temp;
				map[xSize - 1 - x][y] = temp;
			}
		}
	}
	
	static void operTwo() {
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize / 2; y++) {
				int temp = newMap[x][y];
				newMap[x][y] = newMap[x][ySize - 1 - y];
				map[x][y] = map[x][ySize - 1 - y];
				newMap[x][ySize - 1 - y] = temp;
				map[x][ySize - 1 - y] = temp;
			}
		}
	}
	
	static void operThree() {
		newMap = new int[ySize][xSize];
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				newMap[x][y] = map[y][xSize - x - 1];
				System.out.println(newMap[x][y]);
			}
		}
		int temp = xSize;
		xSize = ySize;
		ySize = temp;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		xSize = scan.nextInt();
		ySize = scan.nextInt();
		int operCnt = scan.nextInt();
		map = new int[xSize][ySize];
		newMap = new int[xSize][ySize];
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				map[x][y] = scan.nextInt();
				newMap[x][y] = map[x][y];
			}
		}
		int a = scan.nextInt();
		
		operThree();
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				System.out.print(newMap[x][y] + " ");
			}
			System.out.println("");
		}

	}
}
