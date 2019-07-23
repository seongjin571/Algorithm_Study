package d3;

import java.util.Scanner;

public class Solution_3809_화섭이의_정수_나열 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for (int i = 1; i <= testNum; i++) {
			int inputCnt = scan.nextInt();
			int[] arr = new int[inputCnt];
			for (int j = 0; j < inputCnt; j++) {
				arr[j] = scan.nextInt();
			}

			int cnt = -1;
			int check = 0;
			int check2 = 0;
			loop: while (true) {
				cnt++;
				check = cnt;
				check2 = cnt;
				int numSize = 0;
				while (true) {
					numSize++;
					if (check / 10 > 0)
						check /= 10;
					else
						break;
				}
				int[] num = new int[numSize];
				for (int k = numSize-1; k >= 0; k--) {
					num[k] = check2 % 10;
					check2 /= 10;
				}
				boolean flag = false;
				for (int l = 0; l < inputCnt; l++) {
					if (arr[l] == num[0]) {
						flag = true;
						for (int k = 1; k < numSize; k++) {
							flag = false;
							if (l+k < inputCnt && arr[l + k] == num[k]) {
								flag = true;
							}
						}
						if(flag) {
							break;
						}
					}
				}
				if (!flag) {
					break loop;
				}
			}
			System.out.println("#" + i + " " + cnt);
		}
	}
}
