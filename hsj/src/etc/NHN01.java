package etc;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class NHN01 {
	public static void main(String[] args) throws Exception {
		Map<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		Scanner scan = new Scanner(System.in);
		int cardNum = scan.nextInt();
		int cardTypeCnt = 0;
		int maxCardCnt = 0;
		for (int i = 0; i < cardNum; i++) {
			int setSize = set.size();
			String card = scan.next();
			set.add(card);
			if (setSize != set.size()) {
				cardTypeCnt++;
				map.put(card, 1);
			} else {
				int cnt = map.get(card) + 1;
				map.put(card, cnt);
				maxCardCnt = cnt > maxCardCnt ? cnt : maxCardCnt;
			}
		}
		int cardCnt = 0;
		boolean buy = false;
		boolean result = true;
		for (String card : map.keySet()) {
			int cnt = map.get(card);
			cardCnt += cnt;
			if (cnt < maxCardCnt) {
				if (cnt + 1 == maxCardCnt && !buy) {
					buy = true;
					cardCnt++;
				} else {
					result = false;
					if (buy)
						cardCnt--;
				}
			}
		}
		String resultStr = result ? "Y" : "N";
		System.out.println(resultStr);
		System.out.println(cardCnt);
		System.out.println(cardTypeCnt);
	}
}
