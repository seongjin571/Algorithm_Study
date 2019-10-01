package etc;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class NHN02 {
	public static void main(String[] args) throws Exception {
		List<Integer> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[101];
		int operNum = scan.nextInt();
		int maxNum = 0;
		for (int i = 0; i < operNum; i++) {
			String operStr = scan.next();
			if (operStr.equals("enqueue")) {
				int num = scan.nextInt();
				list.add(num);
				arr[num]++;
				maxNum = num > maxNum ? num : maxNum;
			} else {
				if (list.size() == 0) {
					System.out.print("-1 ");
				}
				int maxCnt = 0;
				for (int j = 1; j <= maxNum; j++) {
					if (maxCnt < arr[j]) {
						maxCnt = arr[j];
					}
				}
				int listSize = list.size();
				for (int j = 0; j < listSize; j++) {
					if (arr[list.get(j)] == maxCnt) {
						int removeNum = list.get(j);
						list.remove(j);
						arr[removeNum]--;
						System.out.print(removeNum + " ");
						break;
					}
				}
			}
		}
	}
}
