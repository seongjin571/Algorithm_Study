package week03;

/*민석이는 교수가 되었고, 이번에 처음으로 맡은 과목에 수강생이 N명이다.

        민석이는 처음으로 과제를 내었다.

        그리고 제출한 사람의 목록을 받았다.

        수강생들은 1번에서 N번까지 번호가 매겨져 있고, 어떤 번호의 사람이 제출했는지에 대한 목록을 받은 것이다.

        과제를 제출하지 않은 사람의 번호를 오름차순으로 출력하는 프로그램을 작성하라.


        [입력]

        첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

        각 테스트 케이스의 첫 번째 줄에는 수강생의 수를 나타내는 정수 N(2≤N≤100)과 과제를 제출한 사람의 수를 나타내는 정수 K(1≤K≤N)가 공백으로 구분되어 주어진다.

        두 번째 줄에는 과제를 제출한 사람의 번호 K개가 공백으로 구분되어 주어진다. 번호는 1이상 N이하의 정수이며 같은 번호가 두 번 이상 주어지는 경우는 없다.


        [출력]

        각 테스트 케이스마다 과제를 제출하지 않은 사람의 번호를 오름차순으로 출력한다.*/

import java.util.Scanner;

public class Solution5431_민석이의_과제_체크하기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            int N = sc.nextInt();
            int K = sc.nextInt();

            if((N < 2 || N >100) || (K < 1 || K > N)) {
                // Error
            } else {
                int[] arr = new int[N];

                //배열에 1~N까지 수 채우기
                for(int j=0; j<N; j++){
                    arr[j] = j+1;

                }
                for(int j=0; j<K; j++){
                    int tmp = sc.nextInt();

                    for(int z = 0; z< N; z++){
                        if(arr[z] == tmp) {
                            arr[z] = -1;
                        }
                    }
                }

                System.out.print("#" + (i+1) + " ");

                for(int j=0; j<N; j++){
                    if(arr[j] != -1) {
                        System.out.print(arr[j] + " ");
                    }
                }

                System.out.println();
            }
        }

    }
}
