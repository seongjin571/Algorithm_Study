package d3;

import java.util.ArrayList;
import java.util.List;

public class Solution_3131_100만_이하의_모든소수 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		int num = 1000000;
		list.add(2);
		for (int i = 3; i < num; i++) {
			int point = i;
			boolean flag = false;
			for(int j = 2; j < point; j++) {
				if(i%j != 0) {
					point = i/j;
				}else {
					flag = true;
					break;
				}
			}
			if (!flag) list.add(i);
		}
		System.out.println(list.size());
		for (int i : list) {
			System.out.print(i + " ");
		}
	}
}
