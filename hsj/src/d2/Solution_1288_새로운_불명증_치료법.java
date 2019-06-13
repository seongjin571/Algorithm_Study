package d2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_1288_새로운_불명증_치료법 {
	static Set<Integer> setNum = new HashSet<>();
	
	static int getMinTime(int multiNum) {
		int count = 0;
		int result = multiNum;
		while(setNum.size() != 10) {
			count++;
			result =  multiNum * count;
			String stringResult = Integer.toString(result);
			for(int i = 0; i < stringResult.length(); i++) {
				setNum.add(stringResult.charAt(i)-'0');
			}
		}
		setNum.clear();
		return result;
	}
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int testCount = 1; testCount <= testNum; testCount++) {
			int multiNum = scan.nextInt();
			System.out.println("#"+testCount+" "+getMinTime(multiNum));	
		}
	}

}
