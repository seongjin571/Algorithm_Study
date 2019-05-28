package week01;

import java.util.Scanner;

public class Solution2050{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        char[] charArray;
        charArray = inputString.toCharArray();
        int charArrayLength = charArray.length;
        for(int i = 0; i < charArrayLength; i++){
            if(charArray[i] >= 65 && charArray[i] <= 90)
                System.out.print(charArray[i]-64+" ");
            else if(charArray[i] >= 97 && charArray[i] <=122)
                System.out.print(charArray[i]-96+" ");
        }     
    }
}