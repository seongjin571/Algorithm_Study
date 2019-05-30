package week01;

import java.util.Scanner;

public class Solution2050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(input.length() <= 200) {
            for(int i=0; i<input.length(); i++) {
                System.out.print(input.charAt(i) - 64);
                System.out.print(" ");
            }
        } else {
            //Error
        }
    }
}