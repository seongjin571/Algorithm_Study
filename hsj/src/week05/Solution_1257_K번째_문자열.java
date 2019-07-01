package week05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution_1257_K번째_문자열 {
	public static void main(String[]args) {
		Set<String> strSet = new HashSet<>();
		List<String> strList = null;
		Scanner scan = new Scanner(System.in);
		int testCount =  scan.nextInt();
		for(int i = 1; i <= testCount; i++) {
			int index = scan.nextInt();
			String str = scan.next();
			int strLength = str.length();
			int count = 0;
			while(count <= strLength) {
				count++;
				for(int k = 0; k < strLength - count + 1; k++) {
					String subStr = str.substring(k, k+count);
					strSet.add(subStr);
				}
			}
			strList = new ArrayList<>(strSet);
			Collections.sort(strList);
			
			String result = "";
			if((index-1) >= strList.size()) result = "none";
			else result = strList.get(index-1);
			System.out.println("#" + i + " " + result);
			strList.clear();
			strSet.clear();
		}
	}
}
