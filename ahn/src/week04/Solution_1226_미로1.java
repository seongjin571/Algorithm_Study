package week04;

/*아래 그림과 같은 미로가 있다. 16*16 행렬의 형태로 만들어진 미로에서 흰색 바탕은 길, 노란색 바탕은 벽을 나타낸다.

        가장 좌상단에 있는 칸을 (0, 0)의 기준으로 하여, 가로방향을 x 방향, 세로방향을 y 방향이라고 할 때, 미로의 시작점은 (1, 1)이고 도착점은 (13, 13)이다.

        주어진 미로의 출발점으로부터 도착지점까지 갈 수 있는 길이 있는지 판단하는 프로그램을 작성하라.

        아래의 예시에서는 도달 가능하다.




        아래의 예시에서는 출발점이 (1, 1)이고, 도착점이 (11, 11)이며 도달이 불가능하다.


        [입력]

        각 테스트 케이스의 첫 번째 줄에는 테스트 케이스의 번호가 주어지며, 바로 다음 줄에 테스트 케이스가 주어진다.

        총 10개의 테스트케이스가 주어진다.

        테스트 케이스에서 1은 벽을 나타내며 0은 길, 2는 출발점, 3은 도착점을 나타낸다.

        [출력]

        #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 도달 가능 여부를 1 또는 0으로 표시한다 (1 - 가능함, 0 - 가능하지 않음).*/

import java.util.Scanner;

public class Solution_1226_미로1 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int maze[][];
    public static boolean visited[][];
    public static int result = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<10; i++){
            result = 0;
            maze = new int[16][16];
            visited = new boolean[16][16];

            int n = sc.nextInt();

            for(int j=0; j<16; j++){
                String tmp = sc.next();
                for(int k=0; k<16; k++){
                    maze[j][k] = tmp.charAt(k)-'0';
                }
            }
            for(int j=0; j<16; j++){
                for(int k=0; k<16; k++){
                    if(maze[j][k] == 2){
                        dfs(j,k);
                    }
                }
            }
            System.out.println("#" + (i+1) + " " + result);
        }
    }

    public static void dfs(int x,int y){

        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < 16 && ny >= 0 && ny < 16){
                if(visited[nx][ny] == false && maze[nx][ny] != 1) {

                    dfs(nx, ny);

                    if(maze[nx][ny]==3) result = 1;
                }
            }
        }
    }
}
