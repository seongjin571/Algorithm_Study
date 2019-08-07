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
			for (long j = start + 1; j <= finish; j++) {
//				long num = Math.abs(j);
//				System.out.println(num);
				cnt++;
//				while (num > 0) {
//					if (num % 10 == 4) {
//						cnt--;
//						break;
//					}
//					num /= 10;
//				}
			}
			long a = finish - 0;
			if(a > 100) {
				long num = a/10;
				long scope = 1;
				long fourNum = 1;
				while(num > 0) {
					if(num/10 > 0) {
						scope *= 10;
						num /= 10;
					}
					fourNum = fourNum*9 + scope; 
				}
				
				for(int i = forNum; i < )
			}
			else {
				
			}
			100 19 19 19
			400 100
			4000 1000
			1000 19*9 +100
			10000 
			int x = 1*9 + 10; 100
			int x = 19*9 +100 1000
			
			
			if(start < 0 && finish > 0) cnt--;
			System.out.println("#" + i + " " + cnt);
		}
	}

}
