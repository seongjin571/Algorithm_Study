package d2;

import java.util.Scanner;

public class Solution_1961_숫자_배열_회전_2 {
	static Scanner scan = new Scanner(System.in);
	static int[][] rotateArray(int[][] array, int squareSize){
		int[][] rotateArray = new int[squareSize][squareSize];
		for(int i = 0; i < squareSize; i++) {
			for(int j = 0; j < squareSize; j++) {
				rotateArray[i][j] = array[squareSize-j-1][i];
			}
		}
		return rotateArray;
	}
	
	static void printRotatedArray(int[][] rotateArray90, int[][] rotateArray180, int[][] rotateArray270, int squareSize) {
		for(int i = 0; i < squareSize; i++) {
			for(int j = 0; j < squareSize; j++) {
				System.out.print(rotateArray90[i][j]);
			}
			System.out.print(" ");
			for(int j = 0; j < squareSize; j++) {
				System.out.print(rotateArray180[i][j]);
			}
			System.out.print(" ");
			for(int j = 0; j < squareSize; j++) {
				System.out.print(rotateArray270[i][j]);
			}
			System.out.println("");
		}
	}
	
	public static void main(String[]args) {
		int testNum = scan.nextInt();
		for (int i = 1; i <= testNum; i++) {
			int squareSize = scan.nextInt();
			int[][] array = new int[squareSize][squareSize];
			for (int j = 0; j < squareSize; j++) {
				for (int k = 0; k < squareSize; k++)
					array[j][k] = scan.nextInt();
			}
			System.out.println("#" + i + " ");
			int[][] rotateArray90 = rotateArray(array, squareSize);
			int[][] rotateArray180 = rotateArray(rotateArray90, squareSize);
			int[][] rotateArray270 = rotateArray(rotateArray180, squareSize);
			printRotatedArray(rotateArray90, rotateArray180, rotateArray270, squareSize);
		}
	}
}
