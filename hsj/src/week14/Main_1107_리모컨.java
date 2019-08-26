package week14;

import java.util.Scanner;

public class Main_1107_리모컨 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int targetChannel = scan.nextInt();
		int brokenCnt = scan.nextInt();
		boolean[] arr = new boolean[10];
		for (int i = 0; i < brokenCnt; i++) {
			arr[scan.nextInt()] = true;
		}
		int upDownResult = Math.abs(targetChannel - 100);
		int cnt = -1;
		int downChannel = targetChannel;
		int upChannel = targetChannel;
		boolean upFlag = false, downFlag = false;
		int numResult;
		int upCnt = 0;
		int downCnt = 0;

		while (true) {
			if (cnt >= upDownResult) {
				numResult = upDownResult;
				break;
			}
			cnt++;
			upChannel = targetChannel + cnt;
			upFlag = true;
			upCnt = 0;
			if (upChannel == 0) {
				if(arr[0] == true) upFlag = false;
				else upChannel = 1;
			}
			while (upChannel > 0) {
				upCnt++;
				int num = upChannel % 10;
				if (arr[num] == true) {
					upFlag = false;
					break;
				}
				upChannel /= 10;
			}

			downChannel = targetChannel - cnt;
			if (downChannel >= 0) {
				downFlag = true;
				downCnt = 0;
				if (downChannel == 0) {
					if(arr[0] == true) downFlag = false;
					else downCnt = 1;
				}
				while (downChannel > 0) {
					downCnt++;
					int num = downChannel % 10;
					if (arr[num] == true) {
						downFlag = false;
						break;
					}
					downChannel /= 10;
				}
			}

			if (downFlag || upFlag) {
				if (downFlag && !upFlag) {
					numResult = cnt + downCnt;
				} else if (!downFlag && upFlag) {
					numResult = cnt + upCnt;
				} else {
					int smallCnt = upCnt < downCnt ? upCnt : downCnt;
					numResult = cnt + smallCnt;
				}
				break;
			}
		}
		int result = numResult < upDownResult ? numResult : upDownResult;
		System.out.println(result);
	}
}
