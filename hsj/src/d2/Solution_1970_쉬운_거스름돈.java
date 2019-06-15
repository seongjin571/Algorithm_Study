package d2;

import java.util.Scanner;

public class Solution_1970_쉬운_거스름돈 {
	static void printChange(int money) {
		int[] moneyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int[] moneyCount = {0, 0, 0, 0, 0, 0, 0, 0};
		int moneyState = 0;
		money /= 10;
		money *= 10;
		while(money > 0) {
			if(money < moneyType[moneyState]) {
				moneyState++;
			}
			else {
				money -= moneyType[moneyState];
				moneyCount[moneyState]++;
			}
		}
		int moneyCountLength = moneyCount.length;
		for(int i = 0; i < moneyCountLength; i++) {
			System.out.print(moneyCount[i] + " ");
		}
	}
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i = 1; i <= testNum; i++) {
			int money = scan.nextInt();
			System.out.println("#" + i);
			printChange(money);
			System.out.println("");
		}
	}
}
