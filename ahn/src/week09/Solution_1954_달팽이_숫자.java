package week09;

/*달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.

        다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.


        [예제]

        N이 3일 경우,




        N이 4일 경우,



        [제약사항]

        달팽이의 크기 N은 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10)


        [입력]

        가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

        각 테스트 케이스에는 N이 주어진다.


        [출력]

        각 줄은 '#t'로 시작하고, 다음 줄부터 빈칸을 사이에 두고 달팽이 숫자를 출력한다.

        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)*/


import java.util.Scanner;

public class Solution_1954_달팽이_숫자 {
    public static int[][] snail;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int cnt;
    public static int n;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();

            snail = new int[n][n];
            visited = new boolean[n][n];

            System.out.println("#" + tc);

            cnt = 1;
            snail[0][0] = cnt++;
            makeSnail(0,0);

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void makeSnail(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (snail[nx][ny] == 0 && !visited[nx][ny]){
                    snail[nx][ny] = cnt++;
                    makeSnail(nx, ny);
                }
            }
        }
    }
}
