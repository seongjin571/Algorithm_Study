package week11;

/*다음 100X100의 2차원 배열이 주어질 때, 각 행의 합, 각 열의 합, 각 대각선의 합 중 최댓값을 구하는 프로그램을 작성하여라.

        다음과 같은 5X5 배열에서 최댓값은 29이다.



        [제약 사항]

        총 10개의 테스트 케이스가 주어진다.

        배열의 크기는 100X100으로 동일하다.

        각 행의 합은 integer 범위를 넘어가지 않는다.

        동일한 최댓값이 있을 경우, 하나의 값만 출력한다.

        [입력]

        각 테스트 케이스의 첫 줄에는 테스트 케이스 번호가 주어지고 그 다음 줄부터는 2차원 배열의 각 행 값이 주어진다.

        [출력]

        #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 답을 출력한다.*/

import java.util.Scanner;

public class Solution_1209_Sum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int tc=1; tc<=10; tc++){
            int t= sc.nextInt();

            int[][] arr = new int[100][100];

            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            int sum1, sum2, max = 0;
            for(int i=0; i<100; i++) {

                sum1 = sum2 = 0;

                for(int j=0; j<100; j++) {
                    sum1 += arr[i][j];
                    sum2 += arr[j][i];
                }
                if( sum1 > max ) max = sum1;
                if( sum2 > max ) max = sum2;
            }

            sum1 = sum2 = 0;
            for(int i=0; i<100; i++) {
                sum1 += arr[i][i];
                sum2 += arr[i][99-i];
            }
            if( sum1 > max ) max = sum1;
            if( sum2 > max ) max = sum2;


            System.out.println("#" + tc + " " + max);
        }
    }
}
