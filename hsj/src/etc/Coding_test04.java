package etc;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution_Coding_Test04 {
    static int arrayLength;
	public boolean checkTemp(int[] T, int index, int winterMaxTemp) {
		for (int i = index + 1; i < arrayLength; i++) {
			if (winterMaxTemp >= T[i])
				return false;
		}
		return true;
	}

	public int solution(int[] T) {
		int result = 0;
		boolean check = false;
		arrayLength = T.length;
		int winterMaxTemp = -1000000000;
		for (int i = 0; i < arrayLength; i++) {
			if (T[i] > winterMaxTemp)
				winterMaxTemp = T[i];

			check = checkTemp(T, i, winterMaxTemp);
			if (check) {
				result = i + 1;
				break;
			}
		}
		return result;
		// write your code in Java SE 8
	}
}