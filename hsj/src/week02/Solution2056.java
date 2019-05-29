package week02;

import java.util.Scanner;

public class Solution2056{
    private static int[] dayOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31}; 
    static String checkDate(String date, int month, int day){
        if(day <= dayOfMonth[month-1]){
            StringBuffer sb = new StringBuffer();
        	sb.append(date);
        	sb.insert(4,"/");
        	sb.insert(7,"/");
            return sb.toString();
        }
        else return "-1";
    }
    
	public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int testCount = scan.nextInt();
        for(int i = 1; i <= testCount; i++){
        	System.out.printf("#%d ",i);
        	String date = scan.next();
            int month = Integer.parseInt(date.substring(4,6));
            if(month>0 && month<=12)
                System.out.println(checkDate(date, month, Integer.parseInt(date.substring(6,8))));
            else
                System.out.println("-1");
        }
    }
	
}