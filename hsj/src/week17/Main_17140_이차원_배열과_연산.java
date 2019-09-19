package week17;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_17140_이차원_배열과_연산 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		int y = scan.nextInt();
		int x = scan.nextInt();
		int value = scan.nextInt();
		int[][] map = new int[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		int xSize = 3;
		int ySize = 3;
		int cnt = 0;
		while(map[x][y] != value || cnt < 100) {
			cnt++;
			if(xSize >= ySize) {
				int[][] mapState = new int[xSize][100];
				int maxSize = 0;
				for(int i = 0; i < xSize; i++) {
					set.clear();
					for(int j = 0; j < ySize; j++) {
						mapState[i][map[i][j]]++;
						set.add(map[i][j]);
					}
					maxSize = set.size() > maxSize ? set.size() : maxSize;
				}
				int[][] map = new int[xSize][maxSize];
				for(int i = 0; i < xSize; i++) {
					for(int j = 0; j < maxSize; i++) {
						
					}
				}
			}else {
				
			}
		}
	}
}
