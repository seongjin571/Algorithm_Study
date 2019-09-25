package etc;

public class Solution_카펫_프로그래머스 {
	public int[] solution(int brown, int red) {
		int totalNum = brown + red;
		int col = 0;
		int row = 0;
		for (int i = 3; i < totalNum; i++) {
			if (totalNum % i == 0) {
				col = i;
				row = totalNum / i;
				if (row >= col) {
					int cnt = row * 2 + col * 2 - 4;
					if (brown == cnt && red == totalNum - cnt) {
						break;
					}
				}
			}
		}
		int[] answer = { row, col };
		return answer;
	}
}
