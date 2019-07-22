package week08;

/*2016년은 삼성전자가 러시아 현지법인을 설립한지 20주년이 된 해이다. 이를 기념해서 당신은 러시아 국기를 만들기로 했다.

        먼저 창고에서 오래된 깃발을 꺼내왔다. 이 깃발은 N행 M열로 나뉘어 있고, 각 칸은 흰색, 파란색, 빨간색 중 하나로 칠해져 있다.

        당신은 몇 개의 칸에 있는 색을 다시 칠해서 이 깃발을 러시아 국기처럼 만들려고 한다. 다음의 조건을 만족해야 한다.

        위에서 몇 줄(한 줄 이상)은 모두 흰색으로 칠해져 있어야 한다.
        다음 몇 줄(한 줄 이상)은 모두 파란색으로 칠해져 있어야 한다.
        나머지 줄(한 줄 이상)은 모두 빨간색으로 칠해져 있어야 한다.

        이렇게 러시아 국기 같은 깃발을 만들기 위해서 새로 칠해야 하는 칸의 개수의 최솟값을 구하여라.




        첫 번째 예제이다. 왼쪽에 있는 그림이 입력이다. 중간에 있는 그림에 X가 적힌 칸들을 새롭게 색칠하여 오른쪽에 있는 그림과 같은 깃발을 만들면 최적이다.


        [입력]

        첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

        각 테스트 케이스의 첫 번째 줄에는 두 정수 N,M(3≤N,M≤50)이 공백으로 구분되어 주어진다.

        다음 N개의 줄에는 M개의 문자로 이루어진 문자열이 주어진다. i번 째 줄의 j번째 문자는 깃발에서 i번째 행 j번째 열인 칸의 색을 의미한다.

        ‘W’는 흰색, ‘B’는 파란색, ‘R’은 빨간색을 의미한다. ‘W’, ‘B’, ‘R’외의 다른 문자는 입력되지 않는다.


        [출력]

        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 러시아 국기 같은 깃발을 만들기 위해서 새로 칠해야 하는 칸의 개수의 최솟값을 구하여 T 줄에 걸쳐서 출력한다.*/


import java.util.Scanner;

public class Solution_4613_러시아_국기_같은_깃발 {
    public static int n;
    public static int m;
    public static int result;
    public static char[][] flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();

            flag = new char[n][m];

            for (int i = 0; i < n; i++) {
                String tmp = sc.next();

                for (int j = 0; j < m; j++) {
                    flag[i][j] = tmp.charAt(j);
                }
            }

            result = 99999;

            selectColor();

            System.out.println("#" + tc + " " + result);
        }
    }

    public static void selectColor() {
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                for (int k = 1; k < n - 1; k++) {
                    if (i + j + k == n) {
                        countColor(i, j, k);
                    }
                }
            }
        }
    }

    public static void countColor(int i, int j, int k) {
        int cnt = 0;

        for (int w = 0; w < i; w++) {
            for (int x = 0; x < m; x++) {
                if (flag[w][x] != 'W') cnt++;
            }
        }

        for (int b = 0; b < j; b++) {
            for (int x = 0; x < m; x++) {
                if (flag[i+b][x] != 'B') cnt++;
            }
        }

        for (int r = 0; r < k; r++) {
            for (int x = 0; x < m; x++) {
                if (flag[i+j+r][x] != 'R') cnt++;
            }
        }

        result = Math.min(cnt, result);
    }
}
