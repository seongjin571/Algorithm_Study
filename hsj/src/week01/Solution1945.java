package week01;

import java.util.Scanner;

public class Solution1945{
    static void calNumFunc(int calNum){
        int[] divNumArray = {2, 3, 5, 7, 11};
        int divNumArrayLength = divNumArray.length;
        for(int i = 0; i < divNumArrayLength; i++){
            int count = 0;
            while((calNum%divNumArray[i])==0){
                    count++;
                    calNum = calNum/divNumArray[i];
            }
           System.out.print(" "+count);
        }
        System.out.println("");
    }
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int testCount = scan.nextInt();
        for(int i = 1; i <= testCount; i++){
            System.out.print("#"+i);
            int calNum = scan.nextInt();
            calNumFunc(calNum);
        }
    }
}