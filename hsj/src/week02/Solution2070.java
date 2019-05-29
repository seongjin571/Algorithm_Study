package week02;

import java.util.Scanner;

public class Solution2070{
    static String compareNum(int numA, int numB){
    	if(numA > numB) return ">";
        else if (numA < numB) return "<";
        else return "=";
    }
    
	public static void main(String[]args){
    	Scanner scan = new Scanner(System.in);
        int testCount = scan.nextInt();
        for(int i =1; i <= testCount; i++){
            int numA = scan.nextInt();
            int numB = scan.nextInt();
        	System.out.print("#"+i+" "+compareNum(numA, numB)+"\n");
        }
    }
	
}