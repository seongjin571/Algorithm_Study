package week02;

import java.util.Scanner;

/*1부터 주어진 숫자만큼 모두 더한 값을 출력하시오.

        단, 주어질 숫자는 10000을 넘지 않는다.


        [예제]

        주어진 숫자가 10 일 경우 출력해야 할 정답은,

        1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55*/


public class Solution2025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (input >= 10000) { /*Error*/ } else {
            int result = 0;

            for (int i = 1; i <= input; i++) {
                result += i;
            }
            System.out.println(result);
        }
    }
}
