package d4;

import java.util.Scanner;

public class Solution4530_극한의_청소_작업 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			long cnt = 0;
			long start = scan.nextLong();
			long finish = scan.nextLong();
			if(finish > 0) {
				long finishClone = finish;
				long finishClone2 = finish;
				int cnt2 = 1;
				int cnt3 = 0;
				while(true) {
					cnt2 *= 10;
					
					long num = 0;
					if(finishClone / 10 > 0) {
						num = finishClone%cnt2;
					}
				}
			}
			long a = finish - 0;

			100 19 19 19
			400 100
			4000 1000
			1000 19*9 +100
			10000 
			7610
			4 < (19*9 +100)*3;
			4 = (19*9 +100)*3 + 나머지;
			4 > 8 (19*9 + 100)*6 + 1000;
			int y = x*9 + y/10;
			int x = 1 + 0;
			int x = 1*9 + 10; 100
			int x = 19*9 +100 1000
			
			
			if(start < 0 && finish > 0) cnt--;
			System.out.println("#" + i + " " + cnt);
		}
	}

}
