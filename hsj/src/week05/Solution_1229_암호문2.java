package week05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1229_암호문2 {
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
				int inputCount = scan.nextInt();
				if (modifyString.equals("I")) {
					for (int k = 0; k < inputCount; k++) {
						numList.add(index, scan.nextInt());
						index++;
					}
				}else {
					for(int k = 0; k < inputCount; k++)
						numList.remove(index);
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
