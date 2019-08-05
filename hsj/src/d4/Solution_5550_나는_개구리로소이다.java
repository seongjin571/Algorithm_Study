package d4;

import java.util.Scanner;

public class Solution_5550_나는_개구리로소이다 {
	static int flogNum = 0;
	static String str = "";
	static int idx = 0;
	static int strLength = 0;
	static char[] charArr = { 'c', 'r', 'o', 'a', 'k' };
	static boolean flag = true;
	static void doDFS(int flogIdx) {
			int j = idx;
			while (j < strLength) {
				if (str.charAt(j) != charArr[flogIdx] && str.charAt(j) == 'c') {
					doDFS(0);
					flogNum++;
				}
				else if(str.charAt(j) != charArr[flogIdx] && str.charAt(j) != 'c') {
					flag = false;
					return;
				}
				if (!flag) return;
				flogIdx++;
				if(flogIdx == 5) flogIdx = 0;
				idx++;
				j = idx;
				System.out.println(j + " " + str.charAt(j));
			
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			str = scan.next();
			strLength = str.length();
			doDFS(0);
			flogNum++;
			if(!flag) flogNum =  -1;
			System.out.println("#" + i + " " + flogNum);
		}

	}

}
