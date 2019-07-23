package d3;

import java.util.Scanner;

public class Solution_7964_부먹왕국의_차원_관문 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for(int i = 1; i <= testCnt; i++) {
			int cityNum = scan.nextInt();
			int[] city = new int[cityNum+2];
			int dist = scan.nextInt();
			city[0] = 1;
			city[cityNum+1] = 1;
			for(int j = 1; j < cityNum+1; j++) {
				city[j] = scan.nextInt();
			}
			int cnt = 0;
			int idx = 0;
			while(idx != cityNum+1) {
				for(int j = idx + 1; j < cityNum+2; j++) {
					if(city[j] == 1) {
						if(j - idx > dist) {
							cnt++;
							idx += dist;
						}
						else {
							idx = j;
						}
						break;
					}
				}	
			}
			System.out.println("#" + i + " " + cnt);
		}
	}
}
