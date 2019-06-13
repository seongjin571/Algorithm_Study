package D2;

import java.util.Scanner;

public class Solution_1959_두_개의_숫자열 {
	static Scanner scan = new Scanner(System.in);
	
	static int getMaxVal(int[] bigArray, int[] smallArray, int smallSize, int diffSize) {
		int maxVal = 0;
		int multiVal;
		int count = 0;
		int bigArrayCount;
		while(count <= diffSize) {
			multiVal = 0;
			bigArrayCount = count;
			for(int i = 0; i < smallSize; i++) {
				multiVal += smallArray[i] * bigArray[bigArrayCount++];
			}
			
			if(multiVal > maxVal) maxVal = multiVal;
			count++;
		}
		return maxVal;
	}
	
	static int getArrayNum(int sizeA, int sizeB) {
		int[] arrayA = new int[sizeA];
		int[] arrayB = new int[sizeB];
		
		for(int i = 0; i < sizeA; i++) {
			arrayA[i] = scan.nextInt();
		}
		for(int i = 0; i < sizeB; i++) {
			arrayB[i] = scan.nextInt();
		}
		
		int maxVal;
		if(sizeA >= sizeB)
			maxVal = getMaxVal(arrayA, arrayB, sizeB, sizeA-sizeB);
		else
			maxVal = getMaxVal(arrayB, arrayA, sizeA, sizeB-sizeA);
		
		return maxVal;
	}
	
	public static void main(String[]args) {
		int testNum = scan.nextInt();
		for(int i = 1; i <= testNum; i++) {
			int sizeA = scan.nextInt();
			int sizeB = scan.nextInt();
			System.out.println("#" + i + " " + getArrayNum(sizeA, sizeB));
		}
	}
}
