package week14;

/*미세먼지를 제거하기 위해 구사과는 공기청정기를 설치하려고 한다. 공기청정기의 성능을 테스트하기 위해 구사과는 집을 크기가 R×C인 격자판으로 나타냈고, 1×1 크기의 칸으로 나눴다. 구사과는 뛰어난 코딩 실력을 이용해 각 칸 (r, c)에 있는 미세먼지의 양을 실시간으로 모니터링하는 시스템을 개발했다. (r, c)는 r행 c열을 의미한다.



        공기청정기는 항상 왼쪽 열에 설치되어 있고, 크기는 두 행을 차지한다. 공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고, (r, c)에 있는 미세먼지의 양은 Ar,c이다.

        1초 동안 아래 적힌 일이 순서대로 일어난다.

        미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
        (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
        인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
        확산되는 양은 Ar,c/5이고 소수점은 버린다.
        (r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.
        공기청정기가 작동한다.
        공기청정기에서는 바람이 나온다.
        위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
        바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
        공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
        다음은 확산의 예시이다.



        왼쪽과 오른쪽에 칸이 없기 때문에, 두 방향으로만 확산이 일어났다.



        인접한 네 방향으로 모두 확산이 일어난다.



        공기청정기가 있는 칸으로는 확산이 일어나지 않는다.

        공기청정기의 바람은 다음과 같은 방향으로 순환한다.



        방의 정보가 주어졌을 때, T초가 지난 후 구사과의 방에 남아있는 미세먼지의 양을 구해보자.

        입력
        첫째 줄에 R, C, T (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000) 가 주어진다.

        둘째 줄부터 R개의 줄에 Ar,c (-1 ≤ Ar,c ≤ 1,000)가 주어진다. 공기청정기가 설치된 곳은 Ar,c가 -1이고, 나머지 값은 미세먼지의 양이다. -1은 2번 위아래로 붙어져 있고, 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.

        출력
        첫째 줄에 T초가 지난 후 구사과 방에 남아있는 미세먼지의 양을 출력한다.*/

import java.util.Scanner;

public class Main_17144_미세먼지_안녕 {
    static int r,c;
    static int[][] map,tmp;
    static int dx[] = { 0, 1, 0, -1 };
    static int dy[] = { 1, 0, -1, 0 };
    static int result = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        int t = sc.nextInt();

        map = new int[r][c];
        tmp = new int[r][c];

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++){
                map[i][j] = sc.nextInt();

            }
        }

        for(int time = 1; time <= t; time++) {
            resetTmp();

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {

                    calcDust(i, j);

                }
            }
            setVacuum();

            moveDust();

            setMap();
        }

        getResult();

        System.out.println(result);
    }

    static void printMap(){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.printf("%5d",tmp[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------printMap()------------------");
    }

    static void calcDust(int x,int y){
        int cnt = 0;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (map[x][y] >= 1) {
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] >= 0) {
                    cnt++;
                    tmp[nx][ny] += map[x][y]/5;
                }
            }
        }
        tmp[x][y] += (map[x][y] - (map[x][y]/5)*cnt);
    }

    static void setMap(){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                map[i][j] = 0;
                map[i][j] = tmp[i][j];
            }
        }
    }

    static void resetTmp() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                tmp[i][j] = 0;
            }
        }
    }

    static void setVacuum(){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] == -1){
                    tmp[i][j] = -1;
                }
            }
        }
    }

    static void moveDust() {
        int x1 = 0;
        int x2 = 0;

        for (int i = 0; i < r; i++) {
            if (tmp[i][0] == -1) {
                x1 = i;
                break;
            }
        }

        x2 = x1 + 1;

        for (int i = x1 - 1; i > 0; i--) {
            tmp[i][0] = tmp[i - 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            tmp[0][i] = tmp[0][i + 1];
        }
        for (int i = 0; i < x1; i++) {
            tmp[i][c - 1] = tmp[i + 1][c - 1];
        }
        for (int i = c - 1; i > 0; i--) {
            tmp[x1][i] = tmp[x1][i - 1];
        }
        tmp[x1][1] = 0;

        for (int i = x2 + 1; i < r - 1; i++) {
            tmp[i][0] = tmp[i + 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            tmp[r - 1][i] = tmp[r - 1][i + 1];
        }
        for (int i = r - 1; i > x2; i--) {
            tmp[i][c - 1] = tmp[i - 1][c - 1];
        }
        for (int i = c - 1; i > 0; i--) {
            tmp[x2][i] = tmp[x2][i - 1];
        }
        tmp[x2][1] = 0;
    }

    static void getResult(){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++) {
                if(map[i][j] >= 1) {
                    result += map[i][j];
                }
            }
        }
    }
}
