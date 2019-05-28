package week01;

import java.util.Scanner;
     
public class Solution1986{
    static int calNumFunc(int calNum){
        int sum = 0;
        for(int i = 1; i <= calNum; i++){
            if(i%2==0) sum -= i;
            else sum += i;
    }
        return sum;
    }
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int testCount = scan.nextInt();
        for(int i = 1; i <= testCount; i++){
            System.out.print("#"+i+" ");
            int calNum = scan.nextInt();
            System.out.print(calNumFunc(calNum)+"\n");
        }
    }
 
}