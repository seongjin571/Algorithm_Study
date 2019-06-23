package week04;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS {
    public static int[][] map = new int[10][10];
    public static boolean[][] visited_dfs = new boolean[10][10];
    public static boolean[][] visited_bfs = new boolean[10][10];
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int cnt = 1;


    public static void main(String[] args){

        //dfs
        dfs(0,0);


        System.out.println("------------------DFS------------------");
        for(int i =0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.print(" "+map[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");

        //bfs
        bfs(0,0);

        System.out.println("------------------BFS------------------");
        for(int i =0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.print(" "+map[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
    }

    public static void dfs(int x,int y){

        visited_dfs[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && visited_dfs[nx][ny] == false){   //nx, ny 범위
                map[nx][ny] = cnt++;
                visited_dfs[nx][ny] = true;
                dfs(nx,ny);

            }
        }
    }

    public static void bfs(int x,int y){
        Queue<Integer> queue = new LinkedList<Integer>();
        visited_bfs[x][y] = true;
        cnt = 1;
        queue.add(x);
        queue.add(y);

        while(!queue.isEmpty()){
            int qx = queue.poll();
            int qy = queue.poll();

            for(int i=0; i<4; i++){
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if(nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && visited_bfs[nx][ny] == false){
                    queue.add(nx);
                    queue.add(ny);
                    visited_bfs[nx][ny] = true;
                    map[nx][ny] = cnt++;
                }
            }
        }
    }
}
