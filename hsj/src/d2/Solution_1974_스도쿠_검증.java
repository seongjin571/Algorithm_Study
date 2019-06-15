package d2;

import java.util.Scanner;

public class Solution_1974_스도쿠_검증 {
	static boolean checkAll(int[][] sudoku, int i, int j, boolean[] exist, boolean[] existSquare, int arrayControlNum) {
		if (exist[sudoku[i][j]] == true || exist[sudoku[j][i] + 10] == true)
			return false;
		else {
			exist[sudoku[i][j]] = true;
			exist[sudoku[j][i] + 10] = true;
		}
		if (existSquare[sudoku[i][j] + arrayControlNum] == true)
			return false;
		else {
			existSquare[sudoku[i][j] + arrayControlNum] = true;
			return true;
		}
	}

	static int checkSudoku(int[][] sudoku) {
		boolean check = false;
		boolean[] existSquare = new boolean[30];
		for (int i = 0; i < 9; i++) {
			boolean[] exist = new boolean[20];
			if (i == 3 || i == 6) {
				existSquare = new boolean[30];
			}
			
			for (int j = 0; j < 3; j++) {
				check = checkAll(sudoku, i, j, exist, existSquare, 0);
				if (check == false)
					return 0;
			}
			for (int j = 3; j < 6; j++) {
				check = checkAll(sudoku, i, j, exist, existSquare, 10);
				if (check == false)
					return 0;
			}
			for (int j = 6; j < 9; j++) {
				check = checkAll(sudoku, i, j, exist, existSquare, 20);
				if (check == false)
					return 0;
			}
			
		}
		return 1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for (int i = 1; i <= testNum; i++) {
			int[][] sudoku = new int[9][9];
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++)
					sudoku[j][k] = scan.nextInt();
			}
			System.out.println("#" + i + " " + checkSudoku(sudoku));
		}
	}

}
