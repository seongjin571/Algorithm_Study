package week02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution1933 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		List<Integer> numList = new ArrayList<>();
		int checkScope = testNum/2;
		int checkNum = 2;
		numList.add(1);
		numList.add(testNum);
		while(checkScope > checkNum) {
			if(testNum%checkNum == 0) {
				numList.add(checkNum);
				numList.add(testNum / checkNum);
				checkScope = testNum / checkNum;
			}
			checkNum++;
		}
		Collections.sort(numList);
		for (int i : numList)
			System.out.printf("%d ", i);
	}
	
}