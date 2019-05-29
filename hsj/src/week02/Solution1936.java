package week02;

import java.util.Scanner;

public class Solution1936{
    static String checkMatch(int numA, int numB){
        int[] array = {1,3,2,1,3,2};
        int arrayLength = array.length;
        for(int i = 0; i < arrayLength; i += 2){
            if(array[i] == numA && array[i+1] == numB)
                return "A";
        }
        return "B";
    }
	public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int numA = scan.nextInt();
        int numB = scan.nextInt();
        System.out.print(checkMatch(numA, numB));
    }
	
}