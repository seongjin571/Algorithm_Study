package week10;

/*삼성대학교 프로그래밍 기초 과목에서 조별과제를 위해 N명으로 구성된 조를 K개 만들고자 한다.

        프로그래밍 과목의 수강 인원은 정확히 N × K명이기 때문에, 완벽하게 조를 구성하는 것이 가능하다.

        조에 들어가는 사람들의 실력을 최대한 균등하게 하기 위해 이미 치른 중간고사 성적을 이용한다.

        성적은 모든 학생들이 달랐기 때문에, 1등에서 N × K등의 학생이 정해져 있다.

        각 조에 1번에서 K번까지의 번호를 붙인 다음과 같이 K개의 조를 구성한다.

        - 1등에서 K등인 학생은 순서대로 1번 조에서 K번 조까지 들어간다.

        - K+1등에서 2K등인 학생은 역순으로 1번 조에서 K번 조까지 들어간다.

        - 2K+1등에서 3K등인 학생은 순서대로 1번 조에서 K번 조까지 들어간다.

        - …

        예를 들어, N = 10 K = 20이면, 1번 조에는 1등, 40등, 41등, 80등, 81등, 120등, 121등, 160등, 161등, 200등인 학생이 들어간다.

        교수님은 각 조의 실력이 조원인 학생들의 등수를 모두 더한 것이라고 생각한다.

        즉, 앞의 예에서 든 1번 조의 실력은 1+40+41+80+81+120+121+160+161+200=1005이다.

        N, K가 주어질 때, 1번 조에서 K번 조까지 실력을 순서대로 모두 구하는 프로그램을 작성하라.


        [입력]

        첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

        각 테스트 케이스의 첫 번째 줄에는 두 정수 N, K(1 ≤ N, K ≤ 20)가 공백 하나로 구분되어 주어진다.


        [출력]

        각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

        각 테스트 케이스마다 1번 조의 실력에서 K번 조의 실력을 나타내는 K개의 정수를 순서대로 공백 하나로 구분하여 출력한다.*/

import java.util.Scanner;

public class Solution_8104_조만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        int[][] group;

        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            group = new int[k][n];
            int grade = 1;

            for(int i=0; i<n; i++){
                if(i%2 == 0) {
                    for (int j = 0; j < k; j++) {
                        group[j][i] = grade++;
                    }
                } else {
                    for (int j = k-1; j>=0; j--){
                        group[j][i] = grade++;
                    }
                }
            }


            System.out.print("#" + tc + " ");

            for(int i=0; i<k; i++){
                int sum = 0;

                for(int j=0; j<n; j++){
                    sum += group[i][j];
                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
