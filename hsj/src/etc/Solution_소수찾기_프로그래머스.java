package etc;

import java.util.Set;
import java.util.HashSet;

public class Solution_소수찾기_프로그래머스 {
	static int[] arr = null;
	static int[] pickArr = null;
	static int resultCnt = 0;
	static int strLen;
	static boolean[] pickVisit = null;
	static Set<Integer> set = new HashSet<>();

	public static void doDFS(int num, int cnt) {
		int result = 0;
		int mulNum = 1;
		if (cnt == num) {
			int size = set.size();
			for (int i = num - 1; i >= 0; i--) {
				result += pickArr[i] * mulNum;
				mulNum *= 10;
			}
			set.add(result);
			if (size == set.size() || result == 1 || result == 0)
				return;
			if (result == 2 || result == 3) {
				resultCnt++;
				return;
			}
			for (int i = 2; i < result / 2 + 1; i++) {
				if (result % i == 0)
					return;
			}
			resultCnt++;
			return;
		}
		for (int i = 0; i < strLen; i++) {
			if (!pickVisit[i]) {
				pickVisit[i] = true;
				pickArr[cnt] = arr[i];
				doDFS(num, cnt + 1);
				pickVisit[i] = false;
			}
		}
	}

	public int solution(String numbers) {
		strLen = numbers.length();
		arr = new int[strLen];
		for (int i = 0; i < strLen; i++) {
			arr[i] = numbers.charAt(i) - '0';
		}
		for (int i = 1; i <= strLen; i++) {
			pickVisit = new boolean[strLen];
			pickArr = new int[i];
			doDFS(i, 0);
		}
		return resultCnt;
	}
}