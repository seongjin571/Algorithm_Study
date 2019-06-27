package week04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 단지번호_붙이기_BFS {
    public static int[][] map;
    public static boolean[][] visited;
    public static int n;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[] num;
    public static int[] result;
    public static int cnt = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n][n];
        visited = new boolean[n][n];
        num = new int[n*n];

        for(int i=0; i<n; i++){
            String tmp = sc.next();
            for(int j=0; j<n; j++){
                map[i][j] = tmp.charAt(j)-'0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] == false && map[i][j] == 1){
                    bfs(i,j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

        result = new int[cnt];

        for(int i=0; i<cnt; i++){
            result[i] = num[i];
        }

        Arrays.sort(result);

        for(int i=0; i<cnt; i++){
            System.out.print(result[i] + "\n");
        }
    }

    public static void bfs(int x,int y) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[x][y] = true;
        queue.add(x);
        queue.add(y);

        num[cnt]++;

        while (!queue.isEmpty()) {
            int qx = queue.poll();
            int qy = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (visited[nx][ny] == false && map[nx][ny] == 1) {
                        queue.add(nx);
                        queue.add(ny);
                        num[cnt]++;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
