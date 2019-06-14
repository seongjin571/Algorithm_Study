package d2;

import java.util.Scanner;

public class Solution_1961_숫자_배열_회전 {
	static Scanner scan = new Scanner(System.in);

	static void rotateThird(int[][] array, int squareSize, int loopController) {
		System.out.print(" ");
		for (int i = 0; i < squareSize; i++)
			System.out.print(array[i][loopController]);
		System.out.println("");
	}

	static void rotateSecond(int[][] array, int squareSize, int loopController) {
		System.out.print(" ");
		for (int j = squareSize - 1; j >= 0; j--) {
			System.out.print(array[loopController][j]);
		}
		rotateThird(array, squareSize, loopController);
	}

	static void rotateArray(int[][] array, int squareSize) {
		int loopController = squareSize - 1;
		for (int j = 0; j < squareSize; j++) {
			for (int i = squareSize - 1; i >= 0; i--) { 
				System.out.print(array[i][j]);
			}
			rotateSecond(array, squareSize, loopController--);
		}
	}

	public static void main(String[] args) {
		int testNum = scan.nextInt();
		for (int i = 1; i <= testNum; i++) {
			int squareSize = scan.nextInt();
			int[][] array = new int[squareSize][squareSize];
			for (int j = 0; j < squareSize; j++) {
				for (int k = 0; k < squareSize; k++)
					array[j][k] = scan.nextInt();
			}
			System.out.println("#" + i + " ");
			rotateArray(array, squareSize);
		}
	}
}
