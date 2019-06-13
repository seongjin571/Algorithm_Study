package d2;

import java.util.Scanner;

public class Solution_1961_숫자_배열_회전 {
	static Scanner scan = new Scanner(System.in);
	
	static void rotateThird(int[][] array, int squareSize) {
		for(int j = 0; j < squareSize; j++) {
			for(int i = squareSize-1; i <= 0; i--) {
				System.out.print(array[i][j]);
				rotateSecond(array, squareSize);
			}
		}
	}
	
	static void rotateSecond(int[][] array, int squareSize) {
		for(int j = 0; j < squareSize; j++) {
			for(int i = squareSize-1; i <= 0; i--) {
				System.out.print(array[i][j]);
				rotateSecond(array, squareSize);
			}
		}
	}
	
	static void rotateArray(int[][] array, int squareSize) {
		for(int j = 0; j < squareSize; j++) {
			for(int i = squareSize-1; i <= 0; i--) {
				System.out.print(array[i][j]);
				rotateSecond(array, squareSize);
			}
		}
	}
	public static void main(String[]args) {
		int testNum = scan.nextInt();
		for(int i = 1; i <= testNum; i++) {
			int squareSize = scan.nextInt();
			int[][] array = new int[squareSize][squareSize];
			for(int j = 0; j < squareSize; j++) {
				for(int k = 0; k < squareSize; k++)
					array[j][k] = scan.nextInt();
			}
			System.out.println("#" + i + " ");
			rotateArray(array, squareSize);
		}
	}
}
