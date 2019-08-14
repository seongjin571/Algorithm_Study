package week11;

/*직사각형의 네 변 중에서 세 변의 길이가 주어진다.

        나머지 한 변의 길이가 얼마인지 출력하는 프로그램을 작성하라.

        세 변의 길이는 상하좌우 어디든 될 수 있으므로 그 순서는 중요하지 않다.

        입력으로 직사각형이 불가능한 경우는 주어지지 않는다.


        다음 그림의 예시는 각각 a = 4, b = 3, c = 4의 입력과 a = 5, b = 5, c = 5의 입력을 받았을 때 직사각형의 모습이다.

        빨간 숫자로 표시된 나머지 변의 길이를 출력하면 된다.

        [입력]

        첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

        각 테스트 케이스의 첫 번째 줄에는 세 자연수 a, b, c(1 ≤ a, b, c ≤ 100)가 공백으로 구분되어 주어진다.


        [출력]

        각 테스트 케이스마다 나머지 한 변의 길이를 출력한다.*/


import java.util.Scanner;

public class Solution_3456_직사각형_길이찾기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int tc=1; tc<=t; tc++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int result = a;

            if(a==b) result = c;
            else if(a==c) result = b;

            System.out.println("#" + tc + " " + result);
        }
    }
}
