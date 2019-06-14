package d2;

import java.util.Scanner;

public class Solution_1979_어디에_단어가_들어갈수_있을까 {
	static int count;
	
	static void checkRow(int[][] squareArray, int squareSize, int wordSize, int i, int j) {
		if(j+wordSize > squareSize) return;
		for(int k = j+1; k < wordSize+j; k++) {
			if(squareArray[i][k] != 1)
				return;
		}
		if(j+wordSize == squareSize || squareArray[i][j+wordSize] == 0)
			count++;
	}
	
	static void checkCol(int[][] squareArray, int squareSize, int wordSize, int i, int j) {
		if(i+wordSize > squareSize) return;
		for(int k = i+1; k < wordSize+i; k++) {
			if(squareArray[k][j] != 1)
				return;
		}
		if(i+wordSize == squareSize || squareArray[i+wordSize][j] == 0)
			count++;
	}
	
	static int getWordCount(int[][] squareArray, int squareSize, int wordSize) {
		count = 0;
		for(int i = 0; i < squareSize; i++) {
			for(int j = 0; j < squareSize; j++) {
				
				if(j == 0) {
					if(squareArray[i][j] == 1)
						checkRow(squareArray, squareSize, wordSize, i, j);
				}
				else if(squareArray[i][j-1] == 0 && squareArray[i][j] == 1)
					checkRow(squareArray, squareSize, wordSize, i , j);
				
				if(i == 0) {
					if(squareArray[i][j] == 1)
						checkCol(squareArray, squareSize, wordSize, i, j);
				}
				else if(squareArray[i-1][j] == 0 && squareArray[i][j] == 1)
					checkCol(squareArray, squareSize, wordSize, i ,j);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for (int i = 1; i <= testNum; i++) {
			int squareSize = scan.nextInt();
			int wordSize = scan.nextInt();
			int[][] squareArray = new int[squareSize][squareSize];

			for (int j = 0; j < squareSize; j++) {
				for (int k = 0; k < squareSize; k++)
					squareArray[j][k] = scan.nextInt();
			}
			System.out.println("#" + i + " " + getWordCount(squareArray, squareSize, wordSize));
		}
	}

}
