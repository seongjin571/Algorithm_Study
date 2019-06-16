package d2;

import java.util.Scanner;

public class Solution_1204_최빈수_구하기 {
	static Scanner scan = new Scanner(System.in);
	static int getFreqNum() {
		int[] scoreArray = new int[101];
		int freqNum = 0;
		int freqCount = 0;
		for(int i = 0; i < 1000; i++) {
			int score = scan.nextInt();
			scoreArray[score]++;
		}
		for(int i = 99; i >= 0; i--) {
			if(scoreArray[i] > freqCount) {
				freqCount = scoreArray[i];
				freqNum = i;
			}
		}
		return freqNum;
	}
	
	public static void main(String[]args) {
		int testNum = scan.nextInt();
		for(int i = 0; i < testNum; i++) {
			int testCount = scan.nextInt();
			System.out.println("#" + testCount + " " + getFreqNum());
		}
	}
}
