package week02;

import java.util.Scanner;

public class Solution2071{
    static Scanner scan = new Scanner(System.in);
    static float calAvg(){
    	int sum = 0;
        float avg = 0.0f;
        for(int i = 0; i < 10; i++){
        	int num = scan.nextInt();
            sum += num;
        }
        avg = sum/10;
        return avg;
    }
	public static void main(String[]args){
        int testCount = scan.nextInt();
        for(int i = 1; i <= testCount; i++){
        	System.out.printf("#%d %d\n",i,Math.round(calAvg()));
        }
    }
}