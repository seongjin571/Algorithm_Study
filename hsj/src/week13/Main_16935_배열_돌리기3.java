package week13;

import java.util.Scanner;

public class Main_16935_배열_돌리기3 {
	static int xSize = 0;
	static int ySize = 0;
	static int operCnt = 0;
	static int[][] map = null;
	static int[][] newMap = null;
	static int halfX = 0;
	static int halfY = 0;
	static int[] arr = new int[10];
	static int[] pointArr = new int[8];
	static void resetArr() {
		halfX = xSize / 2;
		halfY = ySize / 2;
		arr[0] = 0;
		arr[1] = halfY;
		arr[2] = halfX;
		arr[3] = 0;
		arr[4] = 0;
		arr[5] = -halfY;
		arr[6] = -halfX;
		arr[7] = 0;
		arr[8] = 0;
		arr[9] = halfY;
		pointArr[0] = 0;
		pointArr[1] = 0;
		pointArr[2] = 0;
		pointArr[3] = halfY;
		pointArr[4] = halfX;
		pointArr[5] = halfY;
		pointArr[6] = halfX;
		pointArr[7] = 0;
	}
	static void resetMap() {
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				map[x][y] = newMap[x][y];
			}
		}
	}
	
	static void operOne() {
		for (int x = 0; x < xSize / 2; x++) {
			for (int y = 0; y < ySize; y++) {
				int temp = newMap[x][y];
				newMap[x][y] = newMap[xSize - 1 - x][y];
				newMap[xSize - 1 - x][y] = temp;
			}
		}
		resetMap();
	}
	
	static void operTwo() {
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize / 2; y++) {
				int temp = newMap[x][y];
				newMap[x][y] = newMap[x][ySize - 1 - y];
				newMap[x][ySize - 1 - y] = temp;
			}
		}
		resetMap();
	}
	
	static void operThree() {
		newMap = new int[ySize][xSize];
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				newMap[y][xSize - x - 1] = map[x][y];
			}
		}
		map = new int[ySize][xSize];
		int temp = xSize;
		xSize = ySize;
		ySize = temp;
		resetMap();
		resetArr();
	}
	
	static void operFour() {
		newMap = new int[ySize][xSize];
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				newMap[ySize - y - 1][x] = map[x][y];
			}
		}
		map = new int[ySize][xSize];
		int temp = xSize;
		xSize = ySize;
		ySize = temp;
		resetMap();
		resetArr();
	}
	
	static void operFiveSix(int idx) {
		for(int i = 0; i < 8; i += 2) {
			int xPoint = pointArr[i];
			int yPoint = pointArr[i + 1];
			for(int x = xPoint; x < xPoint + halfX; x++) {
				for(int y = yPoint; y < yPoint + halfY; y++) {
					newMap[x + arr[i + idx]][y + arr[i + 1 + idx]] = map[x][y];
				}
			}
		}
		resetMap();
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
		resetArr();
	
		for(int i = 0; i < operCnt; i++) {
			int operNum = scan.nextInt();
			if(operNum == 1) operOne();
			else if(operNum == 2) operTwo();
			else if(operNum == 3) operThree();
			else if(operNum == 4) operFour();
			else if(operNum == 5) operFiveSix(0);
			else operFiveSix(2);
		}
		
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				System.out.print(newMap[x][y] + " ");
			}
			System.out.println("");
		}

	}
}
