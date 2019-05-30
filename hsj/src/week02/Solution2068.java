package week02;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2068 {
	static int getMaxNum(int[] array) {
		Arrays.sort(array);
		return array[array.length-1];
	}
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testCount = scan.nextInt();
		for(int i = 1; i <= testCount; i++) {
			System.out.print("#"+i+" ");
			int[] array = new int[10];
			for(int j = 0; j < 10; j++) {
				int num = scan.nextInt();
				array[j] = num;
			}
			System.out.println(getMaxNum(array));
		}
	}
	
}
