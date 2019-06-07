package week03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_5431_민석이의_과제_체크하기 {
	private static Scanner scan = new Scanner(System.in);
	
	static void printNoSubmitStu(int totalStuNum, int totalSubmitNum) {
		List<Integer> studentList = new ArrayList<>();
		for(int i = 1; i <= totalStuNum; i++) 
			studentList.add(i);
		
		for(int i = 0; i < totalSubmitNum; i++) {
			int submitStu = scan.nextInt();
			studentList.remove((Integer)submitStu);
		}
		for(int noSubmitStu : studentList)
			System.out.print(" " + noSubmitStu);
		 System.out.println("");
	}
	
	public static void main(String[]args) {
		int testCount = scan.nextInt();
		for(int i = 1; i <= testCount; i++) {
			int totalStuNum = scan.nextInt();
			int totalSubmitNum = scan.nextInt();
			System.out.print("#" + i);
			printNoSubmitStu(totalStuNum, totalSubmitNum);
			
		}
	}
}
