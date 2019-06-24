package d2;

import java.util.Scanner;

public class Solution_1859_백만_장자_프로젝트 {
	static Scanner scan = new Scanner(System.in);

	static int check(int i, int day, int[] costArray) {
		for(int j = i; j < day; j++) {
			if()
		}
	}

	static long getBenefit(int day) {
		int maxDay;
		long benefit = 0;
		int buyingCount = 0;
		int pay = 0;
		int[] costArray = new int[day];
		for (int i = 0; i < day; i++) {
			costArray[i] = scan.nextInt();
		}

		for (int i = 0; i < day; i++) {
			if (i + 1 == day || costArray[i] > costArray[i + 1]) {
				int result = check(i, day, costArray);
				if (result == 1) {
					pay += costArray[i];
					buyingCount++;
				} else {
					benefit += buyingCount * costArray[i] - pay;
					pay = 0;
					buyingCount = 0;
				}
			} else if (costArray[i] <= costArray[i + 1]) {
				pay += costArray[i];
				buyingCount++;
			}
		}
		return benefit;
	}

	public static void main(String[] args) {
		int testNum = scan.nextInt();
		for (int i = 1; i <= testNum; i++) {
			int day = scan.nextInt();
			System.out.println("#" + i + " " + getBenefit(day));
		}
	}
}
