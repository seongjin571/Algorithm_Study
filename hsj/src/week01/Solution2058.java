package week01;

import java.util.Scanner;

public class Solution2058{
    static int plusNumFunc(int num){
        int sum = 0;
        while(num>0){
           sum += num%10;
           num = num/10;
        }
        return sum;
    }
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        if(num>=1 && num<=9999)
            System.out.println(plusNumFunc(num));
        else
            System.out.println("입력값이 범위를 초과하였습니다.");
    }
}