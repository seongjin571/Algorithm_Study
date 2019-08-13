package d4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_3752_가능한_시험_점수 {
	static Set<Integer> set = new HashSet<>();	
	static int[] nCrArr = null;
	static int examCnt = 0;
	static int[] examArr = null;
	
	static void getScore(int idx, int cnt, int size) {
		if(cnt == size) {
			int sum = 0;
			for(int i = 0; i < size; i++) {
				sum += examArr[nCrArr[i]];
			}
			set.add(sum);
			return;
		}
		for(int i = idx; i < examCnt; i++) {
			nCrArr[cnt] = i;
			getScore(i + 1, cnt + 1, size);
			nCrArr[cnt] = 0;
		}
	}
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for(int i = 1; i <= testCnt; i++) {
			examCnt = scan.nextInt();
			examArr = new int[examCnt];
			set.clear();
			int sum = 0;
			set.add(sum);
			for(int j = 0; j < examCnt; j++) {
				examArr[j] = scan.nextInt();
				sum += examArr[j];
				set.add(examArr[j]);
			}
			set.add(sum);
			
			for(int j = 2; j < examCnt; j++) {
				nCrArr = new int[j];
				getScore(0, 0, j);
			}
			System.out.println("#" + i + " " + set.size());
		}
	}
}
