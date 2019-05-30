package week01;

import java.util.Scanner;

public class Solution2047 {
    //2047
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(input.getBytes().length <= 80) {
            for(int i=0; i<input.length(); i++){
                if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
                    System.out.print((char)(input.charAt(i)-32));
                else
                    System.out.print(input.charAt(i));
            }
        } else {
            //Error
        }
    }
}