package week10;

/*폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.

        정사각형은 서로 겹치면 안 된다.
        도형은 모두 연결되어 있어야 한다.
        정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
        정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.



        아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.

        테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.

        테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.

        입력
        첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)

        둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.

        출력
        첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.*/

import java.util.Scanner;

public class Main_14500_테트로미노 {
    public static int[][] map;
    public static boolean[][] visited;
    public static int result = 0;
    public static int n, m;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        otherBlocks();

        System.out.println(result);

    }

    public static void dfs(int x, int y, int cnt, int value) {
        if (cnt == 4) {
            result = Math.max(value, result);

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, cnt + 1, value + map[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    public static void otherBlocks() {

        // 'ㅗ'
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m - 1; j++) {
                result = Math.max(result, (map[i][j - 1] + map[i][j] + map[i][j + 1] + map[i - 1][j]));
            }
        }

        // 'ㅓ'
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m; j++) {
                result = Math.max(result, (map[i][j - 1] + map[i][j] + map[i - 1][j] + map[i + 1][j]));
            }
        }

        // 'ㅏ'
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                result = Math.max(result, (map[i - 1][j] + map[i][j] + map[i + 1][j] + map[i][j + 1]));
            }
        }

        // 'ㅜ'
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                result = Math.max(result, (map[i][j - 1] + map[i][j] + map[i + 1][j] + map[i][j + 1]));
            }
        }
    }
}
