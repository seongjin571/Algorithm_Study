package d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_3499_퍼펙트_셔플 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for(int i = 1; i <= testCnt; i++) {
			List<String> list = new ArrayList<>();
			int inputCnt = scan.nextInt();
			for(int j = 0; j < inputCnt; j++) {
				list.add(scan.next());
			}
			int mid;
			if(inputCnt %2 == 0) mid = inputCnt/2;
			else mid = inputCnt/2 + 1;
			int idx = -1;
			for(int j = mid; j < inputCnt; j++) {
				idx += 2;
				String str = list.get(j);
				list.add(idx, str);
				list.remove(j+1);
			}
			System.out.print("#" + i + " ");
			for(String str : list) {
				System.out.print(str + " ");
			}
			System.out.println("");
		}
	}
}
