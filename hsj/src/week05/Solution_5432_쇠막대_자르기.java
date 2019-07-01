package week05;

import java.util.Scanner;

public class Solution_5432_쇠막대_자르기 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testCount = scan.nextInt();
		for(int i = 1; i <= testCount; i++) {
			String pipe = scan.next();
			int pipeLength = pipe.length();
			int pipeNum = 0;
			int result = 0;
			for(int j = 0; j < pipeLength; j++) {
				if((pipe.charAt(j) == '(') && (pipe.charAt(j + 1) == ')')) {
					result += pipeNum;
					j++;
				}
				else if(pipe.charAt(j) == ')') {
					result += 1;
					pipeNum--;
				}
				else if(pipe.charAt(j) == '(') {
					pipeNum++;
				}
			}
			System.out.println("#" + i + " " + result);
		}
	}
}
