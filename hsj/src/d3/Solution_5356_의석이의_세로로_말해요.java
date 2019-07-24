package d3;

import java.util.Scanner;

public class Solution_5356_의석이의_세로로_말해요 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for(int i = 1; i <= testCnt; i++) {
			int maxLength = 0;
			String[] strArr = new String[5];
			for(int j = 0; j < 5; j++) {
				strArr[j] = scan.next();
				if(strArr[j].length() > maxLength) maxLength = strArr[j].length();
			}
			
			System.out.print("#" + i + " ");
			for(int k = 0; k < maxLength; k++) {
				for(int j = 0; j < 5; j++) {
					if(strArr[j].length() > k) {
						System.out.print(strArr[j].charAt(k));
					}
				}
			}
			System.out.println("");
		}
	}
}
