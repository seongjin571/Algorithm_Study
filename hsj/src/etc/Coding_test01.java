package etc;

// you can also use imports, for example:
// import java.util.*;
import java.util.ArrayList;
import java.util.List;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution_Coding_Test01{
	public int solution(int[] A) {
	    
		List<Integer> borderList = new ArrayList<>();
		for (int i : A) {
			if (!borderList.contains(i))
				borderList.add(i);
		}
		int listSize = borderList.size();
		int cattleNum = 0;

		if (listSize == 1) 
			return 1;
			
		if (borderList.get(0) != borderList.get(1))
			cattleNum++;

		if (borderList.get(listSize - 1) != borderList.get(listSize - 2))
			cattleNum++;

		for (int i = 1; i < listSize - 1; i++) {
			if ((borderList.get(i) < borderList.get(i - 1) && borderList.get(i) < borderList.get(i + 1))
					|| (borderList.get(i + 1) < borderList.get(i) && borderList.get(i - 1) < borderList.get(i))){
				cattleNum++;
			}
		}

		return cattleNum;
		
	}
}