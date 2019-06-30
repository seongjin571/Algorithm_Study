package d2;
//you can also use imports, for example:
//import java.util.*;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution_Coding_Test03 {
	public int solution(int[] A) {
		Queue<Integer> queue = new LinkedList<>();
		int arrayLength = A.length;
		int bigNum = 0;
		int smallNum = 0;
		for (int i = 0; i < arrayLength; i++) {
			for (int j = i + 1; j < arrayLength; j++) {
				if (A[i] > A[j]) {
					bigNum = A[i];
					smallNum = A[j];
				} else {
					bigNum = A[j];
					smallNum = A[i];
				}
				boolean adjacent = true;
				for (int k = smallNum + 1; k < bigNum; k++) {
					boolean checkExist = Arrays.asList(A).contains(k);
					if (checkExist) {
						adjacent = false;
						break;
					}
				}
				if (adjacent) {
					queue.add(i);
					queue.add(j);
				}
			}
		}
		
		int minDist;
		if (queue.isEmpty()) {
			return -2;
		} else {
			int i = queue.poll();
			int j = queue.poll();
			minDist = Math.abs(A[i] - A[j]);

			while (!queue.isEmpty()) {
				i = queue.poll();
				j = queue.poll();
				int dist = Math.abs(A[i] - A[j]);
				minDist = Math.min(minDist, dist);
			}
		}

		if (minDist > 100000000)
			return -1;
		else
			return minDist;
			
	}
}