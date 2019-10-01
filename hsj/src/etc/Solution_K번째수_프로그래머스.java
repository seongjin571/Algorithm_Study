package etc;

import java.util.List;
import java.util.ArrayList;

public class Solution_K번째수_프로그래머스 {

	public int[] solution(int[] array, int[][] commands) {
		List<Integer> list = new ArrayList<>();
		int arrayLen = array.length;
		for (int i = 0; i < arrayLen; i++) {
			list.add(array[i]);
		}
		for (int i = 0; i < commands.length; i++) {
			int startIdx = commands[i][0];
			int finishIdx = commands[i][1];
			int insertNum = commands[i][2];
			for (int j = startIdx; j <= finishIdx; j++) {
				list.remove(startIdx);
			}
			list.add(startIdx, insertNum);
		}
		for (int i : list) {
			System.out.println(i);
		}
		int listSize = list.size();
		int[] answer = new int[listSize];
		for (int i = 0; i < listSize; i++) {
			// answer[i] = list.get(i);
			// System.out.println(list.get(i));
		}
		return answer;
	}
}
