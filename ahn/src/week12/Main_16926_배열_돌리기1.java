package week12;

/*크기가 N×M인 배열이 있을 때, 배열을 돌려보려고 한다. 배열은 다음과 같이 반시계 방향으로 돌려야 한다.

        A[1][1] ← A[1][2] ← A[1][3] ← A[1][4] ← A[1][5]
        ↓                                       ↑
        A[2][1]   A[2][2] ← A[2][3] ← A[2][4]   A[2][5]
        ↓         ↓                   ↑         ↑
        A[3][1]   A[3][2] → A[3][3] → A[3][4]   A[3][5]
        ↓                                       ↑
        A[4][1] → A[4][2] → A[4][3] → A[4][4] → A[4][5]
        예를 들어, 아래와 같은 배열을 2번 회전시키면 다음과 같이 변하게 된다.

        1 2 3 4       2 3 4 8       3 4 8 6
        5 6 7 8       1 7 7 6       2 7 8 2
        9 8 7 6   →   5 6 8 2   →   1 7 6 3
        5 4 3 2       9 5 4 3       5 9 5 4
        <시작>         <회전1>        <회전2>
배열과 정수 R이 주어졌을 때, 배열을 R번 회전시킨 결과를 구해보자.

        입력
        첫째 줄에 배열의 크기 N, M과 수행해야 하는 회전의 수 R이 주어진다.

        둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.

        출력
        입력으로 주어진 배열을 R번 회전시킨 결과를 출력한다.

        제한
        2 ≤ N, M ≤ 300
        1 ≤ R ≤ 1,000
        min(N, M) mod 2 = 0
        1 ≤ Aij ≤ 108*/

import java.util.Scanner;

public class Main_16926_배열_돌리기1 {
    static int[][] map;
    static int[][] tmp;
    static boolean[][] visited;
    static int n, m, r;
    public static int val;
    static int dx[] = { 0, 1, 0, -1 };
    static int dy[] = { 1, 0, -1, 0 };


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        while(r>0){
            r--;

            rotate((n > m ? m:n)/2);
        }


        printMap();
    }


    static boolean isChecked(int r,int c,int num){
        if(r >= num && c >= num && r < n - num && c < m-num)
            return true;
        else
            return false;
    }

    static void rotate(int num){
        for(int i=0; i<num; i++){
            int val = map[i][i];
            int x = i;
            int y = i;
            int dir = 0;
            int cnt = 0;

            while(cnt < 4){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(isChecked(nx,ny,i)){
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    dir = (dir+1)%4;
                    cnt++;
                }
            }
            map[i+1][i] = val;
        }
    }

    static void printMap(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
