package week02;

import java.util.Scanner;

public class Solution2019{
	public static void main(String[]args0){
    	Scanner scan = new Scanner(System.in);
        int testNum = scan.nextInt();
        int num = 1;
        System.out.print(num +" ");
        for(int i =1; i <= testNum; i++){
        	num *= 2;
            System.out.print(num + " ");
        }
    }
	
}