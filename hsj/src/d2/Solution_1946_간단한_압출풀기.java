package d2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Alpha {
	String alpha;
	int count;

	Alpha(String alpha, int count) {
		this.alpha = alpha;
		this.count = count;
	}
}

public class Solution_1946_간단한_압출풀기 {
	static Scanner scan = new Scanner(System.in);
	static Queue<Alpha> queue = new LinkedList<>();

	static void printAlpha(int inputCount) {
		int totalCount = 0;
		for (int i = 0; i < inputCount; i++) {
			String alpha = scan.next();
			int count = scan.nextInt();
			queue.add(new Alpha(alpha, count));
			totalCount += count;
		}
		int whileCount = 0;
		while (totalCount > whileCount) {
			Alpha alpha = queue.poll();
			String alphabet = alpha.alpha;
			int alphaCount = alpha.count;
			for (int i = 0; i < alphaCount; i++) {
				whileCount++;
				System.out.print(alphabet);
				if (whileCount % 10 == 0)
					System.out.println("");
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int testNum = scan.nextInt();
		for (int i = 1; i <= testNum; i++) {
			int inputCount = scan.nextInt();
			System.out.println("#" + i);
			printAlpha(inputCount);

		}
	}

}
