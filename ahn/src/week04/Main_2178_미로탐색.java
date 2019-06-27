package week04;

/* N×M크기의 배열로 표현되는 미로가 있다.

        1	0	1	1	1	1
        1	0	1	0	1	0
        1	0	1	0	1	1
        1	1	1	0	1	1
        미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

        위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

        입력
        첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

        출력
        첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main_2178_미로탐색 {
    public static int map[][];
    public static boolean visited[][];
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int n,m;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String tmp = sc.next();
            for(int j=0; j<m; j++){
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(map[n-1][m-1]);

    }

    public static void bfs(int x,int y) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[x][y] = true;
        queue.add(x);
        queue.add(y);

        while (!queue.isEmpty()) {
            int qx = queue.poll();
            int qy = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (visited[nx][ny] == false && map[nx][ny] == 1) {
                        queue.add(nx);
                        queue.add(ny);
                        map[nx][ny] = map[qx][qy] + 1; //길 찾고 갈 수 있는길 같은 수로 채움
                    }
                }
            }
        }
    }
}
