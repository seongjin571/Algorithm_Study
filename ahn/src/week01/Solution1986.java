package week01;

import java.util.Scanner;

public class Solution1986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int input = sc.nextInt();

            if (input >= 1 && input <= 10) {
                System.out.print("#" + (i + 1) + " ");

                int result = 0;

                for (int j = 1; j <= input; j++) {
                    if (j % 2 == 1) {
                        result += j;
                    } else {
                        result -= j;
                    }
                }
                System.out.println(result);
            } else {
                //Error
            }
        }
    }
}
