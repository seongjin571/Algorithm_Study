package d3;

import java.util.Scanner;

public class Solution_4299_태혁이의_사랑은_타이밍 {
	static int getTimeDist(int day, int hour, int minu) {
		int standMinu = 11*60 + 11;
		if(day < 11) return -1;
		else if (day == 11) {
			int timeDist = hour*60 + minu - standMinu;
			if(timeDist < 0) return -1;
			else return timeDist;
		}
		else {
			int dayDist = day-11;
			hour += dayDist*24;
			return hour*60 + minu - standMinu;
		}
		
	}
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for(int i = 1; i <= testCnt; i++) {
			int day = scan.nextInt();
			int hour = scan.nextInt();
			int minu = scan.nextInt();
			System.out.println("#" + i + " " + getTimeDist(day, hour, minu));
		}
	}
}
