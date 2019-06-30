package week05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1228_암호문1 {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		for(int i = 1; i <= 10; i++) {
			int originCount = scan.nextInt();
			for(int j = 0; j < originCount; j++)
				numList.add(scan.nextInt());
			
			int inputCount = scan.nextInt();
			for(int j = 0; j < inputCount; j++) {
				String section = scan.next();
				int index = scan.nextInt();
				int insertNumCount = scan.nextInt();
				for(int k = 0; k < insertNumCount; k++) {
					numList.add(index, scan.nextInt());
					index++;
				}
			}
			System.out.print("#" + i);
			for(int j = 0; j < 10; j++)
				System.out.print(" " + numList.get(j));
			numList.clear();
			System.out.println("");
		}
	}
}
