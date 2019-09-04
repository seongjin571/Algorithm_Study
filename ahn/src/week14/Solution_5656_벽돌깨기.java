package week14;

/*구술을 쏘아 벽돌을 깨트리는 게임을 하려고 한다.

        구슬은 N번만 쏠 수 있고, 벽돌들의 정보는 아래와 같이 W x H 배열로 주어진다.

        ( 0 은 빈 공간을 의미하며, 그 외의 숫자는 벽돌을 의미한다. )






        게임의 규칙은 다음과 같다.

        ① 구슬은 좌, 우로만 움직일 수 있어서 항상 맨 위에 있는 벽돌만 깨트릴 수 있다.

        ② 벽돌은 숫자 1 ~ 9 로 표현되며,

        구술이 명중한 벽돌은 상하좌우로 ( 벽돌에 적힌 숫자 - 1 ) 칸 만큼 같이 제거된다.



        아래는 벽돌에 적힌 숫자와, 구술이 명중했을 시 제거되는 범위의 예이다.





        ③ 제거되는 범위 내에 있는 벽돌은 동시에 제거된다.



        예를 들어 아래와 같이 4 번 벽돌에 구술이 명중할 경우,





        9번 벽돌은 4 번 벽돌에 반응하여,





        동시에 제거된다.





        ④ 빈 공간이 있을 경우 벽돌은 밑으로 떨어지게 된다.







        N 개의 벽돌을 떨어트려 최대한 많은 벽돌을 제거하려고 한다.

        N, W, H, 그리고 벽돌들의 정보가 주어질 때,

        ▶ 남은 벽돌의 개수를 구하라!



        ※ sample input 1



        N = 3, W = 10, K = 10 이고 벽돌들의 정보가 아래와 같을 때,





        최대한 많은 벽돌을 깨트리는 방법은 아래와 같으며, 정답은 12 가 된다.

        그림의 빨간 색 원은 구술이 명중한 위치이며, 주황색 칸은 폭발의 범위를 의미한다.



        i) 첫 번째 구술





        ii) 두 번째 구술





        iii) 세 번째 구술





        [제약 사항]

        1. 1 ≤ N ≤ 4

        2. 2 ≤ W ≤ 12

        3. 2 ≤ H ≤ 15



        [입력]

        가장 첫 줄에는 총 테스트 케이스의 개수 T 가 주어지고,

        그 다음 줄부터 T 개의 테스트 케이스가 주어진다.

        각 테스트 케이스의 첫 번째 줄에는 N, W, H 가 순서대로 공백을 사이에 두고 주어지고,

        다음 H 줄에 걸쳐 벽돌들의 정보가 1 줄에 W 개씩 주어진다.



        [출력]

        출력은 #t 를 찍고 한 칸 띄운 다음 정답을 출력한다.

        (t 는 테스트 케이스의 번호를 의미하며 1 부터 시작한다) */

import java.util.Scanner;

public class Solution_5656_벽돌깨기 {
    static int[][] map;
    static int[][] tmp;
    static int n, w, h;
    static boolean[] visited;
    static int[] order;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            w = sc.nextInt();
            h = sc.nextInt();

            map = new int[h][w];
            tmp = new int[h][w];
            visited = new boolean[w];
            order = new int[n];

            result = 100000;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            rePermutation(0);


            System.out.println("#" + tc + " " + result);
        }
    }

    static void find(int k) {
        for (int i = 0; i < h; i++) {
            if (tmp[i][k] != 0) {
                bomb(i, k);

                break;
            }
        }
    }


    static void bomb(int x, int y) {
        if(x >= 0 && x < h && y >= 0 && y < w) {
            int temp = tmp[x][y];
            tmp[x][y] = 0;

            for (int i = 1; i < temp; i++) {
                bomb(x - i, y);
                bomb(x + i, y);
                bomb(x, y - i);
                bomb(x, y + i);
            }

        }
    }

    static void copyMap(){
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                tmp[i][j] = map[i][j];
            }
        }
    }

    static void rePermutation(int cnt) {
        if(cnt == n) {
            copyMap();
            for(int i=0; i<n; i++){
                find(order[i]);

                setMap();

            }
            result = Math.min(result,cntMap());

            //System.out.println(Arrays.toString(order));
            return;
        }


        for (int i = 0; i < w; i++) {
            order[cnt] = i;
            rePermutation(cnt + 1);
        }
    }

    static int cntMap(){
        int cnt = 0;

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(tmp[i][j] != 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void setMap(){ //리스트로 사용
        for(int i=0; i<w; i++){
            for(int j=h-1; j>=0; j--){
                if(tmp[j][i] == 0) {
                    for(int k=j; k>=0; k--){
                        if(tmp[k][i] != 0) {
                            tmp[j][i] = tmp[k][i];
                            tmp[k][i] = 0;

                            break;
                        }
                    }
                }
            }
        }
    }
}
