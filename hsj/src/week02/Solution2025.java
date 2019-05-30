package week02;

import java.util.Scanner;

public class Solution2025{
	public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int plusNum = scan.nextInt();
        int sum = 0;
        for(int i = 1; i <= plusNum; i++)
    		sum += i;
        System.out.print(sum);
    }
	
}