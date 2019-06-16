package d2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1984_중간_평균값_구하기 {
	static Scanner scan = new Scanner(System.in);
	static int getAvg() {
		int[] array = new int[10];
		for(int i = 0; i < 10; i++) {
			array[i] = scan.nextInt();
		}
		Arrays.sort(array);
		double sum = 0.0;
		double avg = 0.0;
		int range = array.length-1;
		for(int i = 1; i < range; i++) {
			sum += array[i];
		}
		avg = sum/8;
		return (int)Math.round(avg);
	}
	
	public static void main(String[]args) {
		int testNum = scan.nextInt();
		for(int i = 1; i <= testNum; i++) {
			System.out.println("#" + i + " " + getAvg());
		}
	}
}
