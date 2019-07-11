package week06;

import java.util.Scanner;

public class Solution_1218_괄호_짝짓기 {
	static int[] count = null;
	static int getResult() {
		for(int j = 0; j < 4; j++) {
			if(count[j] != count[j+4]) return 0;
		}
		return 1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] bracket = { '{', '(', '[', '<', '}', ')', ']', '>'};
		for (int i = 1; i <= 10; i++) {
			count = new int[8];
			int inputCount = scan.nextInt();
			String inputString = scan.next();
			for (int j = 0; j < inputCount; j++) {
				for (int k = 0; k < 8; k++) {
					if (inputString.charAt(j) == bracket[k]) {
						count[k]++;
						break;
					}
				}
			}
				System.out.println("#" + i + " " + getResult());
		}

	}
}
