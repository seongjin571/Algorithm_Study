package week04;

import java.util.Scanner;

public class Solution_1206_view {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int arraySize = scan.nextInt();
			int[] building = new int[arraySize];
			int sum = 0;
			for (int j = 0; j < arraySize; j++) {
				building[j] = scan.nextInt();
			}

			for (int j = 2; j < arraySize - 2; j++) {
				int maxHeight = Math.max(building[j - 1], building[j + 1]);
				maxHeight = Math.max(maxHeight, building[j + 2]);
				maxHeight = Math.max(maxHeight, building[j - 2]);
				if (building[j] - maxHeight > 0)
					sum += building[j] - maxHeight;
			}

			System.out.println("#" + i + " " + sum);
		}
	}
}
