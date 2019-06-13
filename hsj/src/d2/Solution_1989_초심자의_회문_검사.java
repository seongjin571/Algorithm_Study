package d2;

import java.util.Scanner;

public class Solution_1989_초심자의_회문_검사 {
	static int checkString(String testStr) {
		int strLength = testStr.length();
		int countS = strLength/2 - 1;
		int countB;
		
		if(strLength%2 == 0) 
			countB = strLength/2;
		else 
			countB = strLength/2 + 1;
		
		while(countS >= 0) {
			if(testStr.charAt(countS) != testStr.charAt(countB)) return 0;
			countS--;
			countB++;
		}
		return 1;
	}
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i = 1; i <= testNum; i++) {
			String testStr = scan.next();
			System.out.println("#" + i + " " + checkString(testStr));
		}
	}

}
