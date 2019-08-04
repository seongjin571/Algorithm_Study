package week08;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1244_최대_상금 {
	static int[] arr = null;
	static int numLength = 0;
	static String num;
	static char[] charArr;
	static int maxScore = 0;
	static int totalCnt = 0;
	static boolean flag = true;
	static int maxNum;

	static void getIdx(int idx, int cnt, int changeCnt) {
		if (flag) {
			if (cnt == 2) {
				int arr1 = arr[0];
				int arr2 = arr[1];
				char temp = charArr[arr1];
				char temp2 = charArr[arr2];
				charArr[arr1] = temp2;
				charArr[arr2] = temp;
				int score = Integer.parseInt(new String(charArr));
				if (changeCnt == totalCnt) {
					if (maxScore < score)
						maxScore = score;
					if(maxScore == maxNum) 
						flag = false;
				} else {
					getIdx(0, 0, changeCnt + 1);
				}
				charArr[arr1] = temp;
				charArr[arr2] = temp2;
				return;
			}
			for (int i = idx; i < numLength; i++) {
				arr[cnt] = i;
				getIdx(i + 1, cnt + 1, changeCnt);
				arr[cnt] = 0;
			}
		}
		else {
			return;
		}
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			StringBuilder sb = new StringBuilder();
			flag = true;
			maxScore = 0;
			num = scan.next();
			totalCnt = scan.nextInt();
			charArr = num.toCharArray();
			char[] sortArr = num.toCharArray();
			numLength = num.length();
			Arrays.sort(sortArr);
			for(int j = numLength-1; j >= 0; j--) {
				sb.append(sortArr[j]);
			}
			maxNum = Integer.parseInt(sb.toString());
			arr = new int[2];
			getIdx(0, 0, 1);
			System.out.println("#" + i + " " + maxScore);
		}
	}
}
