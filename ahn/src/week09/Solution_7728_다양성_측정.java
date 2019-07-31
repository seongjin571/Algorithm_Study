package week09;

/*숫자는 다양성을 가지고 있다. 다양성이란, 숫자를 구성하는 수의 종류를 의미한다.

        예를 들어서 1512 라는 숫자는 ‘1’, ‘5’, ‘2’로 구성되어 있기 때문에 다양성이 3이다.

        숫자가 주어졌을 때 그 숫자의 다양성을 구하는 프로그램을 작성하라.


        [입력]

        첫 번째 줄에 테스트 케이스의 수 T(1 ≤ T ≤ 100)가 주어진다.

        각 테스트 케이스의 첫 번째 줄에는 다양성을 체크하고 싶은 숫자 X(1 ≤ X ≤ 109) 가 주어진다.


        [출력]

        각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

        주어진 숫자의 다양성을 출력하라.*/

import java.util.Scanner;

public class Solution_7728_다양성_측정 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int tc=1; tc<=t; tc++){
            String num = sc.next();

            String result = "";

            for(int i=0; i<num.length(); i++){
                if(!result.contains(String.valueOf(num.charAt(i)))){
                    result += String.valueOf(num.charAt(i));
                }
            }

            System.out.println("#" + tc + " " + result.length());
        }
    }
}
