package week03;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208_Flatten {
	static Scanner scan = new Scanner(System.in);
	
	static int doDump(int[] array) {
		array[0]++;
		array[array.length-1]--;
		Arrays.sort(array);
		return  array[array.length-1] - array[0];
	}
	
	static int getHeightDiff(int dumpNum, int[] array) {
		Arrays.sort(array);
		int dumpResult = 0;
		for(int dumpCount = 0; dumpCount < dumpNum; dumpCount++) {
			dumpResult = doDump(array);
			if(dumpResult <= 1)
				return dumpResult;
		}
		return dumpResult;
	}

	public static void main(String[] args) {
		for (int testNum = 1; testNum <= 10; testNum++) {
			int dumpNum = scan.nextInt();
			int[] array = new int[100];
			for(int widthCount = 0; widthCount < 100; widthCount++)
				array[widthCount] = scan.nextInt();
			System.out.println("#" + testNum + " " + getHeightDiff(dumpNum, array));
		}
	}

}
