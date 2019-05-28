package week01;

import java.util.Scanner;

public class Solution2047{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        char[] charArray;
        charArray = inputString.toCharArray();
        int charArrayLength = charArray.length;
        for(int i = 0; i < charArrayLength; i++){
            if(97<=charArray[i] && charArray[i]<=122)
                charArray[i] = (char)(charArray[i]-32);
        }
        System.out.println(charArray);
    }
}