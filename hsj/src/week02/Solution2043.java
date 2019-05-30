package week02;

import java.util.Scanner;

public class Solution2043{
	public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int keyNum = scan.nextInt();
        int startNum = scan.nextInt();
        int count = 0;
        for(int i=startNum; i <= keyNum; i++)
            count++;
        System.out.print(count);
	}
	
}