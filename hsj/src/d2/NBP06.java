// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
	public int solution(String[] T, String[] R) {
		// write your code in Java SE 8
		int testNum = 0;
		int passCaseCount = 0;
		boolean checkCaseNum = true;
		boolean passCase;
		while (checkCaseNum) {
			passCase = true;
			checkCaseNum = false;
			testNum++;
			for (int i = 0; i < T.length; i++) {
				if (testNum == Integer.parseInt(T[i].replaceAll("[^0-9]", ""))) {
					checkCaseNum = true;
					if (!R[i].equals("OK")) {
						passCase = false;
						break;
					}
				}
			}
			if(passCase) passCaseCount++;
		}
		return (passCaseCount-1)*100/(--testNum);
		
	}
}