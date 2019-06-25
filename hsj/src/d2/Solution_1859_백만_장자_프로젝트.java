package d2;

import java.util.Scanner;

public class Solution_1859_백만_장자_프로젝트 {
	static Scanner scan = new Scanner(System.in);
	static int[] costArray;
	static int buyingCount;
	static int pay;
	static long benefit;

	static int checkMaxDay(int dayIndex, int day) {
		int maxDayIndex = 0;
		int maxDayCost = costArray[dayIndex];
		for(int i = dayIndex + 1; i < day; i++) {
			if(costArray[i] >= maxDayCost) {
				maxDayCost = costArray[i];
				maxDayIndex = i;
			}
		}
		return maxDayIndex;
	}

	static long getBenefit(int day) {
		benefit = 0L;
		buyingCount = 0;
		pay = 0;
		costArray = new int[day];
		for (int i = 0; i < day; i++) {
			costArray[i] = scan.nextInt();
		}
		int dayIndex = 0;
		while (dayIndex < day) {
			if(dayIndex + 1 == day) {
				benefit += buyingCount * costArray[dayIndex] - pay;
				return benefit;
			}
			else if (costArray[dayIndex] > costArray[dayIndex + 1]) {
				int result = checkMaxDay(dayIndex, day);
				if (result == 0) {
					calBenefit(dayIndex);
					dayIndex++;
				} else {
					for(int i = dayIndex; i <= result; i++) {
						pay += costArray[i];
						buyingCount++;
					}
					calBenefit(result);
					dayIndex = result;
				}
			} 
			else if (costArray[dayIndex] <= costArray[dayIndex + 1]) {
				pay += costArray[dayIndex];
				buyingCount++;
				dayIndex++;
			}
		}
		return benefit;
	}
	static void calBenefit(int result) {
		benefit += buyingCount * costArray[result] - pay;
		pay = 0;
		buyingCount = 0;
	}

	public static void main(String[] args) {
		int testNum = scan.nextInt();
		for (int i = 1; i <= testNum; i++) {
			int day = scan.nextInt();
			System.out.println("#" + i + " " + getBenefit(day));
		}
	}
	

}
