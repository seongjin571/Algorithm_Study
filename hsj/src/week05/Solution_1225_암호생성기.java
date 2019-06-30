package week05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1225_암호생성기 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> numList = null;
		for(int i = 1; i <= 10; i++) {
			numList = new ArrayList<>();
			int testCount = scan.nextInt();
			for(int j = 0; j < 8; j++) {
				numList.add(scan.nextInt());
			}
			int flag = 0;
			int minusCount = 0;
			while(flag == 0) {
				minusCount++;
				if(minusCount == 6) minusCount = 1;
				int firstNum = numList.get(0);
				numList.remove(0);
				if(firstNum - minusCount <= 0) {
					flag = 1;
					firstNum = 0;
				}else {
					firstNum -= minusCount;
				}
				numList.add(firstNum);
			}
			System.out.print("#" + i);
			for(int num : numList) {
				System.out.print(" " + num);
			}
			System.out.println("");
		}
	}
}
