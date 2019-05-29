package week02;

import java.util.Scanner;

public class Solution2072{
    static Scanner scan = new Scanner(System.in);
    static double calAvg(){
    	int sum = 0;
        for(int i = 0; i < 10; i++){
        	int num = scan.nextInt();
            sum += num;
        }
        double avg = sum/10.0;
        return avg;
    }
    
	public static void main(String[]args){
        int testCount = scan.nextInt();
        for(int i = 1; i <= testCount; i++)
        	System.out.printf("#%d %d\n", i, Math.round(calAvg()));
    }
    
}