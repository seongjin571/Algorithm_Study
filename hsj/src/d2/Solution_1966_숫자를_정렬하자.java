package d2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1966_숫자를_정렬하자 {
	static Scanner scan = new Scanner(System.in);
	static void doSort(int[] numArray) {
		int arrayLength = numArray.length;
		for(int i = 0; i < arrayLength; i++) {
			numArray[i] = scan.nextInt();
		}
		Arrays.sort(numArray);
		for(int i = 0; i < arrayLength; i++)
			System.out.print(" " + numArray[i]);
		System.out.println("");
	}
	public static void main(String[]args) {
		int testNum = scan.nextInt();
		for(int i = 1; i <= testNum; i++) {
			int arraySize = scan.nextInt();
			int[] numArray = new int[arraySize];
			System.out.print("#" + i);
			doSort(numArray);
		}
	}
}
