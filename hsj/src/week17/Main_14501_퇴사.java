package week17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Work{
	int workSize, pay;
	Work(int workSize, int pay){
		this.workSize = workSize;
		this.pay = pay;
	}
}
public class Main_14501_퇴사 { 
	static int maxPay = 0;
	static int totalDay = 0;
	static List<Work> list = new ArrayList<>();
	static void doDFS(int day, int paySum) {
		int workSize = list.get(day).workSize;
		int pay = list.get(day).pay;
		if(day + workSize >= totalDay) {
			paySum = workSize + day == totalDay ? paySum + pay : paySum; 
			maxPay = paySum > maxPay ? paySum : maxPay;
			return;
		}else {
			paySum += pay;
			for(int i = day + workSize; i < totalDay; i++) {
				doDFS(i, paySum);
			}
		}
		
	}
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		totalDay = scan.nextInt();
		for(int i = 0; i < totalDay; i++) {
			int workSize = scan.nextInt();
			int pay = scan.nextInt();
			list.add(new Work(workSize, pay));
		}
		for(int i = 0; i < totalDay; i++) {
			doDFS(i, 0);
		}
		System.out.println(maxPay);
	}
}
