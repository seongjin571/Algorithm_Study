package week06;

import java.util.Scanner;

public class Solution_3143_가장_빠른_문자열_타이핑 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testCount = scan.nextInt();
		for(int i = 1; i <= testCount; i++) {
			String allStr = scan.next();
			String partStr = scan.next();
			int allStrLen = allStr.length();
			int partStrLen = partStr.length();
			int point = 0;
			int partTypeCount = 0;
			boolean flag = true;
			String newStr = allStr;
			
			while(flag) {
				newStr = newStr.substring(point);
				int partStrIndex = newStr.indexOf(partStr);
				if(partStrIndex != -1) {
					point = partStrIndex + partStrLen;
					partTypeCount++;
				}
				else {
					flag = false;
				}
			}
			int oneTypeCount = allStrLen - (partTypeCount*partStrLen);
			int result = oneTypeCount + partTypeCount;
			System.out.println("#" + i + " " + result);
			
		}
	}
}
