package etc;

public class programmers_02_02 {
	public int solution(int n) {
		int cnt = 1;
		int twoBefore = 0;
		int oneBefore = 1;
		for (int i = 1; i < n; i++) {
			twoBefore %= 1234567;
			oneBefore %= 1234567;
			cnt = twoBefore + oneBefore;
			twoBefore = oneBefore;
			oneBefore = cnt;
		}
		int answer = cnt % 1234567;
		return answer;
	}
}
