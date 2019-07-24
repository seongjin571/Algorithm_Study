package d3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_4676_늘어지는_소리_만들기 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(scan.next());
			int inputCnt = scan.nextInt();
			int[] idxArr = new int[inputCnt];
			for (int j = 0; j < inputCnt; j++) {
				idxArr[j] = scan.nextInt();
			}
			Arrays.sort(idxArr);
			
			for (int j = inputCnt - 1; j >= 0; j--) {
				sb.insert(idxArr[j], '-');
			}
			System.out.println("#" + i + " " + sb.toString());
		}
	}
}
