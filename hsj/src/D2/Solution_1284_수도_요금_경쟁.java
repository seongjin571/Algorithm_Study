package D2;

import java.util.Scanner;

public class Solution_1284_수도_요금_경쟁 {
	static int printLowCost(int aCopCost, int basicL, int bCopCost, int bExtraCost, int useWater) {
		int lowCost;
		int aCost = aCopCost*useWater;
		int bCost;
		if(basicL >= useWater) {
			bCost = bCopCost; 
		}else {
			bCost = bCopCost + bExtraCost * (useWater - basicL); 
		}
		if(bCost >= aCost) return aCost;
		else return bCost;
	}
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i = 1; i <= testNum; i++) {
			int aCopCost = scan.nextInt();
			int bCopCost = scan.nextInt();
			int basicL = scan.nextInt();
			int bExtraCost = scan.nextInt();
			int useWater = scan.nextInt();
			System.out.println("#" + i + " " + printLowCost(aCopCost, basicL, bCopCost, bExtraCost, useWater));
		}
	}
}
