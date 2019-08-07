package week10;

/*뿌요뿌요의 룰은 다음과 같다.

        필드에 여러 가지 색깔의 뿌요를 놓는다. 뿌요는 중력의 영향을 받아 아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어진다.

        뿌요를 놓고 난 후, 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다.

        뿌요들이 없어지고 나서 위에 다른 뿌요들이 있다면, 역시 중력의 영향을 받아 차례대로 아래로 떨어지게 된다.

        아래로 떨어지고 나서 다시 같은 색의 뿌요들이 4개 이상 모이게 되면 또 터지게 되는데, 터진 후 뿌요들이 내려오고 다시 터짐을 반복할 때마다 1연쇄씩 늘어난다.

        터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 하고 여러 그룹이 터지더라도 한번의 연쇄가 추가된다.

        남규는 최근 뿌요뿌요 게임에 푹 빠졌다. 이 게임은 1:1로 붙는 대전게임이라 잘 쌓는 것도 중요하지만, 상대방이 터뜨린다면 연쇄가 몇 번이 될지 바로 파악할 수 있는 능력도 필요하다. 하지만 아직 실력이 부족하여 남규는 자기 필드에만 신경 쓰기 바쁘다. 상대방의 필드가 주어졌을 때, 연쇄가 몇 번 연속으로 일어날지 계산하여 남규를 도와주자!

        입력
        12*6의 문자가 주어진다.

        이때 .은 빈공간이고 .이 아닌것은 각각의 색깔의 뿌요를 나타낸다.

        R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다.(모두 대문자로 주어진다.)

        입력으로 주어지는 필드는 뿌요들이 전부 아래로 떨어진 뒤의 상태(즉 뿌요 아래에 빈 칸이 있는 경우는 없음) 이다.

        출력
        현재 주어진 상황에서 몇연쇄가 되는지 출력하라. (하나도 터지지 않는다면 0을 출력하면 된다.)*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main_11559_Puyo_Puyo {
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static ArrayList<Integer> list;
    public static int result = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        map = new char[12][6];

        for(int i=0; i<12; i++){
            String tmp = sc.next();

            for(int j=0; j<6; j++){
                map[i][j] = tmp.charAt(j);
            }
        }

        while(true) {
            visited = new boolean[12][6];
            boolean flag = false;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.') { //map[i][j] == 'R' || map[i][j] == 'Y' || map[i][j] == 'G' 하니까 안됌
                        list = new ArrayList();

                        dfs(i, j, map[i][j]);

                        if(list.size() >= 8){
                            flag = true;

                            for(int k=0; k<list.size(); k++){
                                map[list.get(k)][list.get(k+1)] = '.';
                                k++;
                            }
                        }
                    }
                }
            }
            renewalOfMap();

            if(!flag) break;
            else result++;


            drawMap();

        }
        System.out.println(result);
    }

    public static void dfs(int x, int y, char color) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6) {
                if (!visited[nx][ny] && map[nx][ny] == color) {
                    visited[nx][ny] = true;
                    list.add(nx);
                    list.add(ny);
                    dfs(nx, ny, color);
                }
            }
        }
    }

    public static void renewalOfMap(){
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j >= 0; j--) {
                if (map[j][i] != '.') {
                    for (int k = 11; k > j; k--) {
                        if (map[k][i] == '.') {
                            map[k][i] = map[j][i];
                            map[j][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void drawMap(){
        for(int i=0; i<12; i++){
            for(int j=0; j<6; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
