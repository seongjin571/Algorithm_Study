package week02;

import java.util.Scanner;

public class Solution2029{
	public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int testCount = scan.nextInt();
        for(int i = 1; i <= testCount; i++){
            int numA = scan.nextInt();
            int numB = scan.nextInt();
        	System.out.print("#"+ i +" " + numA/numB + " " + numA%numB+ "\n");
        }
	}
	
}