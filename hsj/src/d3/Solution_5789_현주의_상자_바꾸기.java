package d3;

import java.util.Scanner;

public class Solution_5789_현주의_상자_바꾸기 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for(int i = 1; i <= testCnt; i++) {
			int boxNum = scan.nextInt();
			int tryCnt = scan.nextInt();
			int[] boxArr = new int[boxNum];
			for(int j = 1; j <= tryCnt; j++) {
				int start = scan.nextInt();
				int finish = scan.nextInt();
				for(int k = start-1; k <= finish-1; k++)
					boxArr[k] = j;
			}
			System.out.print("#" + i + " ");
			for(int j = 0; j < boxNum; j++)
				System.out.print(boxArr[j] + " ");
			System.out.println("");
		}
	}
}
