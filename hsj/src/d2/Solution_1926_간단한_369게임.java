package d2;

import java.util.Scanner;

public class Solution_1926_간단한_369게임 {
	static String calNum(int num) {
		String stringNum = String.valueOf(num);
		boolean flag = false;
		String result = "";
		int stringLength = stringNum.length();
		for(int i = 0; i < stringLength; i++) {
			if(stringNum.charAt(i) == '3' || stringNum.charAt(i) == '6' || stringNum.charAt(i) == '9') {
				flag = true;
				result += "-";
			}
		}
		if(flag) return result;
		else return stringNum;
	}
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int gameNum = scan.nextInt();
		for(int i = 1; i <= gameNum; i++) {
			System.out.print(calNum(i) + " ");
		}
	}
}
