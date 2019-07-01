package week05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1230_암호문3 {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int originCount = scan.nextInt();
			for (int j = 0; j < originCount; j++)
				numList.add(scan.nextInt());

			int modifyCount = scan.nextInt();
			
			for (int j = 0; j < modifyCount; j++) {
				String modifyString = scan.next();
				int index = scan.nextInt();
				if (modifyString.equals("I")) {
					int inputCount = scan.nextInt();
					for (int k = 0; k < inputCount; k++) {
						numList.add(index, scan.nextInt());
						index++;
					}
				} 
				else if(modifyString.equals("D")) {
					int inputCount = scan.nextInt();
					for (int k = 0; k < inputCount; k++)
						numList.remove(index);
				}else {
					for(int k = 0; k < index; k++) 
						numList.add(scan.nextInt());
				}
			}
			
			System.out.print("#" + i);
			for (int j = 0; j < 10; j++)
				System.out.print(" " + numList.get(j));
			numList.clear();
			System.out.println("");
		}
	}
}