package d2;

import java.util.Scanner;

public class Solution_1983_조교의_성적_매기기 {
	static Scanner scan = new Scanner(System.in);
	static String getGrade(int totalStuNum, int stuNum) {
		String[] typeOfGrade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
		int count = 0;
		int[] stuScoreArray = new int[totalStuNum];
		for(int i = 0; i < totalStuNum; i++) {
			int midScore = scan.nextInt();
			int finalScore = scan.nextInt();
			int assignScore = scan.nextInt();
			stuScoreArray[i] = midScore*35 + finalScore*45 + assignScore*20;
		}
		for(int i = 0; i < totalStuNum; i++) {
			if(stuScoreArray[i] > stuScoreArray[stuNum-1])
				count++;
		}
		double stuRanking = count+1;
		int stuGradeNum = (int) (Math.ceil(stuRanking/(totalStuNum/10))-1);
		return typeOfGrade[stuGradeNum];
	}
	
	public static void main(String[]args) {
		int testNum = scan.nextInt();
		for(int i = 1; i<= testNum; i++) {
			int totalStuNum = scan.nextInt();
			int stuNum = scan.nextInt();
			System.out.println("#" + i + " " + getGrade(totalStuNum, stuNum));
		}
	}

}
