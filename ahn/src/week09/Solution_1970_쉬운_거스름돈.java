package week09;

/*우리나라 화폐 ‘원’은 금액이 높은 돈을 우선적으로 계산할 때 돈의 개수가 가장 최소가 된다.

        S마켓에서 사용하는 돈의 종류는 다음과 같다.
        50,000 원
        10,000 원
        5,000 원
        1,000 원
        500 원
        100 원
        50 원
        10 원

        S마켓에서 손님에게 거슬러 주어야 할 금액 N이 입력되면 돈의 최소 개수로 거슬러 주기 위하여 각 종류의 돈이 몇 개씩 필요한지 출력하라.


        [예제]

        N이 32850일 경우,
        50,000 원 : 0개
        10,000 원 : 3개
        5,000 원 : 0개
        1,000 원 : 2개
        500 원 : 1개
        100 원 : 3개
        50 원 : 1개
        10 원 : 0개


        [제약 사항]

        1. N은 10이상 1,000,000이하의 정수이다. (10 ≤ N ≤ 1,000,000)

        2. N의 마지막 자릿수는 항상 0이다. (ex : 32850)


        [입력]

        가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

        각 테스트 케이스에는 N이 주어진다.


        [출력]

        각 줄은 '#t'로 시작하고, 다음줄에 각 돈의 종류마다 필요한 개수를 빈칸을 사이에 두고 출력한다.

        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)*/

import java.util.Scanner;

public class Solution_1970_쉬운_거스름돈 {
    public static int money;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int tc=1; tc<=t; tc++){
            money = sc.nextInt();

            System.out.println("#" + tc + " ");

            calcMoney(50000);
            calcMoney(10000);
            calcMoney(5000);
            calcMoney(1000);
            calcMoney(500);
            calcMoney(100);
            calcMoney(50);
            calcMoney(10);

            System.out.println();
        }
    }

    public static void calcMoney(int k){
        int cnt = 0;

        if(money >= k){
            while(money >= 0) {
                money -= k;

                if(money < 0) {
                    money += k;
                    break;
                }

                cnt ++;
            }
        }

        System.out.print(cnt + " ");
    }
}
