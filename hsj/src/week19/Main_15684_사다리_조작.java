package week19;

import java.util.Scanner;
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main_15684_사다리_조작 {
	static boolean flag = false;
	static int xLine;
	static int yLine;
	static int[][] arr = null;
	static void doDFS(int idx, int cnt) {
		if(cnt == idx) {
			
		}
		for(int x = 1; x < xLine; x++) {
			for(int y = 1; y < yLine; y++) {
				if(arr[x*2 - 1][yLine + 2] != 1) {
					
				}
			}
		}
		
	}
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		yLine = scan.nextInt();
		int ySize = yLine + 2;
		int lineNum = scan.nextInt();
		xLine = scan.nextInt();
		int xSize = xLine * 2 - 1;
		arr = new int[xSize][ySize];
		for(int i = 0; i < lineNum; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt() * 2 - 1;
			arr[x][y] = 1;
		}
		int totalLine = yLine / 2 * xLine;
		int result = -1;
		int idx = -1;
		while(idx < totalLine - lineNum) {
			idx++;
			doDFS(idx, 0);
			if(flag) {
				result = idx;
				break;
			}
		}
		System.out.println(idx);
	}
}
