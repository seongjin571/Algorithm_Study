package week01;

import java.util.Scanner;

public class Solution1945 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] e = {0, 0, 0, 0, 0};

        for (int i = 0; i < num; i++) {
            int input = sc.nextInt();

            System.out.print("#" + (i + 1) + " ");

            while (input != 1) {
                for (int j = 2; j <= input; j++) {
                    if (input % j == 0) {
                        input /= j;

                        if (j == 2) e[0]++;
                        else if (j == 3) e[1]++;
                        else if (j == 5) e[2]++;
                        else if (j == 7) e[3]++;
                        else if (j == 11) e[4]++;

                        break;
                    }
                }
            }
            for (int j = 0; j < e.length; j++) {
                System.out.print(e[j] + " ");
                e[j] = 0;
            }
            System.out.println();
        }
    }
}
