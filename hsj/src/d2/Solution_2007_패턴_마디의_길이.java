package d2;

import java.util.Scanner;

public class Solution_2007_패턴_마디의_길이 {
	static boolean checkPattern(char[] charArray, int i, String testString) {
		int count = 0;
		for (int j = i; j < i*2; j++) {
			if (charArray[count++] != testString.charAt(j))
				return false;
		}
		return true;
	}

	static int checkString(String testString) {
		char[] charArray = new char[10];
		boolean check = false;
		charArray[0] = testString.charAt(0);
		for (int i = 1; i < 10; i++) {
			charArray[i] = testString.charAt(i);
			if (charArray[0] == testString.charAt(i+1)) {
				check = checkPattern(charArray, i + 1, testString);
				if(check) return i + 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for (int i = 1; i <= testNum; i++) {
			String testString = scan.next();
			System.out.println("#" + i + " " + checkString(testString));

		}
	}
}
