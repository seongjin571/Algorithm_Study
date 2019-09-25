package etc;

public class Solution_모의고사_프로그래머스 {
	public int[] solution(int[] answers) {
		int[][] stuPatturn = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
		int[] correctArr = new int[3];
		int answersNum = answers.length;
		int maxCnt = 0;
		for (int i = 0; i < 3; i++) {
			int patturnLength = stuPatturn[i].length;
			int idx = 0;
			int cnt = 0;
			for (int j = 0; j < answersNum; j++) {
				idx = idx == patturnLength ? 0 : idx;
				cnt = answers[j] == stuPatturn[i][idx] ? cnt + 1 : cnt;
				idx++;
			}
			maxCnt = maxCnt < cnt ? cnt : maxCnt;
			correctArr[i] = cnt;
		}
		int answerSize = 0;
		for (int i = 0; i < 3; i++) {
			if (maxCnt == correctArr[i])
				answerSize++;
			else
				correctArr[i] = -1;
		}
		int[] answer = new int[answerSize];
		int idx = 0;
		for (int i = 0; i < 3; i++) {
			if (correctArr[i] > -1)
				answer[idx++] = i + 1;
		}
		return answer;
	}
}
