package d2;

import java.util.Scanner;

public class Solution_1976_시각_덧셈 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i = 1; i <= testNum; i++) {
			int firHour = scan.nextInt();
			int firMin = scan.nextInt();
			int secHour = scan.nextInt();
			int secMin = scan.nextInt();
			int finalHour = firHour + secHour;
			int finalMin = firMin + secMin;
			if(finalMin >= 60) {
				finalMin -= 60;
				finalHour++;
			}
			if(finalHour > 12) 
				finalHour -= 12;
			System.out.println("#" + i + " " + finalHour + " " + finalMin);
		}
	}
}
