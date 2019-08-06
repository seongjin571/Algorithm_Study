package week09;

/*N 개의 숫자로 구성된 숫자열 Ai (i=1~N) 와 M 개의 숫자로 구성된 숫자열 Bj (j=1~M) 가 있다.

        아래는 N =3 인 Ai 와 M = 5 인 Bj 의 예이다.


        Ai 나 Bj 를 자유롭게 움직여서 숫자들이 서로 마주보는 위치를 변경할 수 있다.

        단, 더 긴 쪽의 양끝을 벗어나서는 안 된다.




        서로 마주보는 숫자들을 곱한 뒤 모두 더할 때 최댓값을 구하라.

        위 예제의 정답은 아래와 같이 30 이 된다.



        [제약 사항]

        N 과 M은 3 이상 20 이하이다.


        [입력]

        가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

        각 테스트 케이스의 첫 번째 줄에 N 과 M 이 주어지고,

        두 번째 줄에는 Ai,

        세 번째 줄에는 Bj 가 주어진다.

        [출력]

        출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.

        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)*/

import java.util.Scanner;

public class Solution_1959_두개의_숫자열 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        int[] A;
        int[] B;

        for(int tc=1; tc<=t; tc++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            A = new int[n];
            B = new int[m];

            for(int i=0; i<n; i++){
                A[i] = sc.nextInt();
            }

            for(int i=0; i<m; i++){
                B[i] = sc.nextInt();
            }

            int sum, max=0;

            for(int i=0; i<m-n+1; i++){
                sum = 0;

                for(int j=0; j<n; j++){
                    sum += A[j]*B[j+i];
                }

                max = Math.max(sum,max);
            }

            for(int i=0; i<n-m+1; i++){
                sum = 0;

                for(int j=0; j<m; j++){
                    sum += A[j+i]*B[j];
                }

                max = Math.max(sum,max);
            }

            System.out.println("#" + tc + " " + max);
        }

    }
}
