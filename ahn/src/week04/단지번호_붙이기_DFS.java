package week04;

import java.util.Arrays;
import java.util.Scanner;

public class 단지번호_붙이기_DFS {
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
                    dfs(i,j);
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

    public static void dfs(int x,int y){

        visited[x][y] = true;

        num[cnt]++;  // 단지당 1의 개수가 몇개인지

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n){   // map의 범위 체크
                if(visited[nx][ny] == false && map[nx][ny] == 1) // 방문하지 않았고 map이 1 인 부분 체크
                dfs(nx,ny);
            }
        }
    }
}
