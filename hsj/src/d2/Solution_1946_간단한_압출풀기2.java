package d2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1946_간단한_압출풀기2 {
	static Scanner scan = new Scanner(System.in);
	static Queue<Object> queue = new LinkedList<>();
	static void printAlpha(int inputCount) {
		int totalCount = 0;
		for(int i = 0; i < inputCount; i++) {
			String alpha = scan.next();
			int count = scan.nextInt();
			queue.add(alpha);
			queue.add(count);
			totalCount += count;
		}
		int whileCount = 0;
		while(totalCount > whileCount) {
			String alpha = (String) queue.poll();
			int count = (int)queue.poll();
			for (int i = 0; i < count; i++) {
				whileCount++;
				System.out.print(alpha);
				if (whileCount % 10 == 0)
					System.out.println("");
			}
		}
		System.out.println("");
	}
	public static void main(String[]args) {
		int testNum = scan.nextInt();
		for(int i = 1; i <= testNum; i ++) {
			int inputCount = scan.nextInt();
			System.out.println("#" + i);
			printAlpha(inputCount);
			
		}
	}

}
