package week11;

/*영준이는 신비한 짐승들이 살고 있는 뿔의 숲을 지나왔다.

        이 숲에는 뿔이 한 개 달린 유니콘과 뿔이 두 개 달린 트윈혼이 살고 있다.

        영준이는 n개의 뿔과 m마리의 짐승을 보았다.

        영준이가 본 유니콘의 수와 트윈혼의 수는 몇 마리일까?

        만약 영준이가 5개의 뿔과 3마리의 짐승을 봤다면, 아래 그림과 같이 유니콘 1마리와 트윈혼 2마리였을 것이다.




        [입력]

        첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

        각 테스트 케이스마다 첫 번째 줄에 두 정수 n, m (1 ≤ n ≤ 300, m ≤ n ≤ 2m)이 공백으로 구분되어 주어진다.


        [출력]

        각 테스트 케이스마다 영준이가 본 유니콘의 수와 트윈혼의 수를 공백으로 구분하여 출력한다.*/

import java.util.Scanner;

public class Solution_3142_영준이와_신비한_뿔의_숲 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int tc=1; tc<=t; tc++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int result = -1;

            int unicorn = 0;
            int twinhorn = m;

            while(true){
                if(result > -1) break;

                if(unicorn + twinhorn*2 == n){
                    result = unicorn;
                }

                else {
                    unicorn++;
                    twinhorn--;
                }
            }

            System.out.println("#" +  tc+ " " + unicorn + " " + twinhorn);
        }
    }
}
