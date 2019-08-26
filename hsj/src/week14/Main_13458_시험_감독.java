package week14;

import java.util.Scanner;

public class Main_13458_시험_감독 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int roomNum = scan.nextInt();
		int[] arr = new int[roomNum];
		for (int i = 0; i < roomNum; i++) {
			arr[i] = scan.nextInt();
		}
		int chefCareNum = scan.nextInt();
		int subCareNum = scan.nextInt();
		
		long cnt = roomNum;
		for (int i = 0; i < roomNum; i++) {
			arr[i] -= chefCareNum;
			if(arr[i] <= 0) continue;
			cnt += (arr[i] % subCareNum == 0) ? arr[i] / subCareNum : arr[i] / subCareNum + 1;
		}
		System.out.println(cnt);
	}
}
