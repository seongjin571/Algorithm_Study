package etc;

import java.util.LinkedList;
import java.util.Queue;

class Programmers {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		Queue<Object> queue = new LinkedList<>();
		int treesLength = skill_trees.length;
		int count = 0;
		while (treesLength > count) {
			boolean answerCheck = true;
			int standard = -1;
			boolean[] classFinish = new boolean[skill.length()];
			for (int i = 0; i < skill.length(); i++) {
				queue.add(skill.charAt(i));
			}
			int stringLength = skill_trees[count].length();
			
			for (int i = 0; i < skill.length(); i++) {
				char keyWord = (char) queue.poll();
				for (int j = 0; j < stringLength; j++) {
					if (skill_trees[count].charAt(j) == keyWord) {
						classFinish[i] = true;
						if (j > standard && (i == 0 || classFinish[i-1] == true)) {
							standard = j;
						} else {
							answerCheck = false;
							break;
						}
					}
				}
			}
			if (answerCheck) answer++;
			count++;
		}
		return answer;
	}
}

public class Solution_프로그래머스 {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		Programmers so = new Programmers();
		
	}

}
