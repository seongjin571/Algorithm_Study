package d2;

import java.util.Scanner;

public class Solution_1859_백만_장자_프로젝트 {
	static Scanner scan = new Scanner(System.in);
	static long getBenefit(int day) {
		long benefit = 0;
		int buyingCount = 0;
		int pay = 0;
		int[] costArray = new int[day];
		for(int i = 0; i < day; i++) {
			costArray[i] = scan.nextInt(); 
		}
		for(int i = 0; i < day; i++) {
			if(i+1 == day || costArray[i] > costArray[i+1]) {
				benefit += buyingCount*costArray[i] - pay;
				pay = 0;
				buyingCount = 0;
			}
			else if(costArray[i] <= costArray[i+1]) {
				pay += costArray[i];
				buyingCount++;
			}
		}
		return benefit;
	}
	public static void main(String[]args) {
		int testNum = scan.nextInt();
		for(int i = 1; i <= testNum; i++) {
			int day = scan.nextInt();
			System.out.println("#" + i + " " + getBenefit(day));
		}
	}
}
