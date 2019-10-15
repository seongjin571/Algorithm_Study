package etc;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class programmers_01_01 {
	public String[] solution(String[] strings, int n) {
		List<Character> list = new ArrayList<>();
		List<String> strList = new ArrayList<>();
		Arrays.sort(strings);
		for (String str : strings) {
			list.add(str.charAt(n));
			strList.add(str);
		}
		Collections.sort(list);
		int cnt = strings.length;
		String[] answer = new String[cnt];
		int idx = 0;
		for (Character ch : list) {
			for (String str : strList) {
				if (str.charAt(n) == ch) {
					answer[idx++] = str;
					strList.remove(str);
					break;
				}
			}
		}
		return answer;
	}
}
