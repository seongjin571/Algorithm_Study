package week01;

import java.util.Scanner;

public class Solution2058 {

    //2058
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int result = 0;

        for(int i=0; i<input.length(); i++){
            result += (input.charAt(i) - '0');
        }

        System.out.println(result);
    }

}


