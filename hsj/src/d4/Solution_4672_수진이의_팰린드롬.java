package d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_4672_수진이의_팰린드롬 {
	static int strLen = 0;
	static int lastIdx = 0;
	static int maxCnt = 0;
	static String str = "";
	List<Integer> list = new ArrayList<>();
	static char[] charArr = null;
	static int[] intArr = null;
	static int[] perCheck = null;

	static void getMax() {
		int cnt = 0;
		for (int i = 0; i < strLen; i++) {
			charArr[i] = str.charAt(intArr[i]);
		}

		for (int length = 2; length <= strLen; length++) {
			for (int k = 0; k < strLen - length + 1; k++) {
				boolean check = true;
				String newStr = Arrays.toString(charArr).replace(", ", "").replace("[", "").replace("]", "")
						.substring(k, length + k);
				lastIdx = length - 1;
				for (int j = 0; j < length / 2; j++) {
					if (newStr.charAt(j) != newStr.charAt(lastIdx)) {
						check = false;
						break;
					}
					lastIdx--;
				}
				if (check)
					cnt++;
			}
		}
		cnt += strLen;
		if (cnt > maxCnt)
			maxCnt = cnt;
	}

	static void doDFS(int cnt, int[] perCheck) {
		if (cnt == strLen) {
			getMax();
			return;
		}
		for (int i = 0; i < strLen; i++) {
			if (perCheck[i] == 0) {
				perCheck[i] = 1;
				intArr[cnt] = i;
				doDFS(cnt + 1, perCheck);
				intArr[cnt] = 0;
				perCheck[i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			str = scan.next();
			strLen = str.length();
			charArr = new char[strLen];
			intArr = new int[strLen];
			perCheck = new int[strLen];
			maxCnt = 0;
			doDFS(0, perCheck);

			System.out.println("#" + i + " " + maxCnt);
		}
	}
}
