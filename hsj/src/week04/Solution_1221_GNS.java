package week04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1221_GNS {

	public static void main(String[]args) {
		String compareStr = "ZROONETWOTHRFORFIVSIXSVNEGTNIN";
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		List<String> stringList = new ArrayList<>();
		List<String> removeList = new ArrayList<>();
		for(int i = 1; i <= testNum; i++) {
			String testPoint = scan.next();
			System.out.println(testPoint);
			int inputNum = scan.nextInt();
			for(int j = 0; j < inputNum; j++) { //리스트에 모든 입력값 추가.
				String strValue = scan.next();
				stringList.add(strValue);
			}
			
			for(int k = 0; k < 10; k++) { // 0~9(ZEO~NIN) 비교하기 위한 for문
				removeList.add(compareStr.substring(k*3, k*3+3)); 
				for(String str : stringList) { 
					if(k == (compareStr.indexOf(str)/3)) //list의 해당 문자열이 compareStr에서 몇번째 인덱스 위치인지 즉, 몇번째 숫자인지와 for문의 인덱스와 비교 
						System.out.print(str + " ");
				}
				stringList.removeAll(removeList); //방금 전 전부 출력한 문자(for문의 인덱스에 해당하는 문자를 (ex)1이면 ONE)를 리스트에서 삭제 
				removeList.clear(); 
			}
		}
	}
}
