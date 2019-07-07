package week06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution_4613_러시아_국기_같은_깃발 {
	static List<int[]> colorDistList = new ArrayList<>();
	static List<Integer> colorChangeList = new ArrayList<>();
	static int[] combiArr = null;
	static int changeCount = 0;
	static int col = 0;
	static int row = 0;
	
	static void reCombination(int[] combiArr, int r, int index, int target) {
		boolean flag = false;
		if (r == 0) {
			for(int k = 0; k < row-2; k++) {
				if(combiArr[k] == 1) {
					flag = true;
					break;
				}
			}
			if(flag) {
				for(int i = 0; i < row-2; i++) {
					changeCount += col - colorDistList.get(i)[combiArr[i]];
				}
				colorChangeList.add(changeCount);
				changeCount = 0;
				return;
			}
			else return;
		}
		
		if (target == 3)
			return;

		combiArr[index] = target;
		reCombination(combiArr, r - 1, index + 1, target);
		reCombination(combiArr, r, index, target + 1);

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCount = scan.nextInt();
		char[] colorArray = { 'W', 'B', 'R' };
		int[] colorCount = new int[3];
		for (int i = 1; i <= testCount; i++) {
			int count = 0;
			row = scan.nextInt();
			col = scan.nextInt();

			for (int j = 0; j < row; j++) {
				String rowString = scan.next();
				for (int k = 0; k < col; k++) {
					if (j == 0) {
						if (rowString.charAt(k) != 'W')
							count++;
					} else if (j == row - 1) {
						if (rowString.charAt(k) != 'R')
							count++;
					} else {
						for (int l = 0; l < 3; l++) {
							if (rowString.charAt(k) == colorArray[l]) {
								colorCount[l]++;
								break;
							}
						}
					}
				}
				colorDistList.add(colorCount);
				colorCount = new int[3];
			}
			
			colorDistList.remove(0); //첫줄 삭제
			colorDistList.remove(colorDistList.size() - 1); //마지막줄 삭제
			int listSize = colorDistList.size();
			combiArr = new int[listSize];
			reCombination(combiArr, listSize, 0, 0);
			Collections.sort(colorChangeList);
			int result = colorChangeList.get(0) + count;
			System.out.println("#" + i + " " + result);
			colorDistList.clear();
			colorChangeList.clear();
			
		}
	}
}
