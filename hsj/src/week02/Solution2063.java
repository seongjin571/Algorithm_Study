package week02;

import java.util.Scanner; 
import java.util.Arrays;

public class Solution2063{
	public static void main(String[]args){
    	Scanner scan = new Scanner(System.in);
        int testCount = scan.nextInt();
        int[] array = new int[testCount];
        for(int i = 0; i < testCount; i++){
        	int num = scan.nextInt();
            array[i] = num;
        }
        Arrays.sort(array);
        System.out.print(array[array.length/2]);
    }
	
}