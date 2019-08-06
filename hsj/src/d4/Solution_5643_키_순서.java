package d4;

import java.util.Scanner;

public class Solution_5643_키_순서 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			int result = 0;
			int stuNum = scan.nextInt();
			int compCnt = scan.nextInt();
			int[][] map = new int[stuNum + 1][stuNum + 1];
			for(int j = 1; j <= stuNum; j++) {
				map[j][j] = 2;
			}
			
			for (int j = 0; j < compCnt; j++) {
				int small = scan.nextInt();
				int big = scan.nextInt();
				map[small][big] = -1;
				map[big][small] = 1;
				for(int k = 1; k <= stuNum; k++) {
					if(map[small][k] == 1) {
						map[big][k] = 1;
						map[k][big] = -1;
					}
					if(map[big][k] == -1) {
						map[small][k] = -1;
						map[k][small] = 1;
					}
				}
				
			}
			for (int j = 1; j <= stuNum; j++) {
				boolean flag = true;
				for (int k = 1; k <= stuNum; k++) {
					if(map[j][k] == 0) {
						flag = false;
						break;
					}
				}
				if(flag) result++;
			}
			System.out.println("#" + i + " " + result);
		}
	}
}
