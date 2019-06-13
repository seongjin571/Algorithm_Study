package d2;

import java.util.Scanner;

public class Solution_1948_날짜_계산기 {
	static int [] dayOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
	static int getDiffOfDay(int firstMon, int firstDay, int secondMon, int secondDay) {
		int diffOfDay = dayOfMonth[firstMon-1] - firstDay;
		for(int i = firstMon; i < secondMon-1; i++) {
			diffOfDay += dayOfMonth[i];
		}
		diffOfDay += secondDay+1;
		return diffOfDay;
	}
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i = 1; i <= testNum; i++) {
			int firstMon = scan.nextInt();
			int firstDay = scan.nextInt();
			int secondMon = scan.nextInt();
			int secondDay = scan.nextInt();
			System.out.print("#" + i + " ");
			if(firstMon == secondMon) System.out.println(secondDay - firstDay + 1);
			else System.out.println(getDiffOfDay(firstMon, firstDay, secondMon, secondDay));
		}
	}
}
