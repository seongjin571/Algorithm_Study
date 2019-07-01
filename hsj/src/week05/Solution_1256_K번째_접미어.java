package week05;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1256_K번째_접미어 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testCount = scan.nextInt();
		for(int i = 1; i <= testCount; i++) {
			int index = scan.nextInt();
			String str = scan.next();
			int strLength = str.length();
			String[] strArray = new String[strLength];
			for(int j = 0; j < strLength; j++) {
				strArray[j] = str.substring(j);
			}
			Arrays.sort(strArray);
			System.out.println("#" + i + " " + strArray[index-1]);
		}
	}
}
