package d2;

import java.util.Scanner;

public class Solution_2005_파스칼의_삼각형 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i = 1; i <= testNum; i++) {
			int triangleSize = scan.nextInt();
			int[][] triangleArray = new int[triangleSize][triangleSize];
			System.out.println("#" + i);
			for(int j = 0; j < triangleSize; j++) {
				for(int k = 0 ; k < j+1; k++) {
					if(k == 0 || k == j) {
						triangleArray[j][k] = 1;
						System.out.print("1 ");
					}
					else {
						triangleArray[j][k] = triangleArray[j-1][k-1] + triangleArray[j-1][k];
						System.out.print(triangleArray[j][k] + " ");
					}
				}
				System.out.println("");
			}
		}
	}
}
