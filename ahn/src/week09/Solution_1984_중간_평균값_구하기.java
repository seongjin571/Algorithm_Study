package week09;

/*10개의 수를 입력 받아, 최대 수와 최소 수를 제외한 나머지의 평균값을 출력하는 프로그램을 작성하라.

        (소수점 첫째 자리에서 반올림한 정수를 출력한다.)


        [제약 사항]

        각 수는 0 이상 10000 이하의 정수이다.


        [입력]

        가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

        각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.


        [출력]

        출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.

        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)*/

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1984_중간_평균값_구하기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] arr = new int[10];

        for(int tc=1; tc<=t; tc++){
            for(int i=0; i<10; i++){
                arr[i] = sc.nextInt();
            }

            int result = 0;

            Arrays.sort(arr);

            for(int i=1; i<=8; i++){
                result += arr[i];
            }

            System.out.println("#" + tc + " " + Math.round(result/8.0));
        }
    }
}
