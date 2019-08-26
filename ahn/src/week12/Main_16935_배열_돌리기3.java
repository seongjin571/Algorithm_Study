package week12;

/*문제
        크기가 N×M인 배열이 있을 때, 배열에 연산을 R번 적용하려고 한다. 연산은 총 6가지가 있다.

        1번 연산은 배열을 상하 반전시키는 연산이다.

        1 6 2 9 8 4 → 4 2 9 3 1 8
        7 2 6 9 8 2 → 9 2 3 6 1 5
        1 8 3 4 2 9 → 7 4 6 2 3 1
        7 4 6 2 3 1 → 1 8 3 4 2 9
        9 2 3 6 1 5 → 7 2 6 9 8 2
        4 2 9 3 1 8 → 1 6 2 9 8 4
<배열>       <연산 결과>
2번 연산은 배열을 좌우 반전시키는 연산이다.

        1 6 2 9 8 4 → 4 8 9 2 6 1
        7 2 6 9 8 2 → 2 8 9 6 2 7
        1 8 3 4 2 9 → 9 2 4 3 8 1
        7 4 6 2 3 1 → 1 3 2 6 4 7
        9 2 3 6 1 5 → 5 1 6 3 2 9
        4 2 9 3 1 8 → 8 1 3 9 2 4
<배열>       <연산 결과>
3번 연산은 오른쪽으로 90도 회전시키는 연산이다.

        1 6 2 9 8 4 → 4 9 7 1 7 1
        7 2 6 9 8 2 → 2 2 4 8 2 6
        1 8 3 4 2 9 → 9 3 6 3 6 2
        7 4 6 2 3 1 → 3 6 2 4 9 9
        9 2 3 6 1 5 → 1 1 3 2 8 8
        4 2 9 3 1 8 → 8 5 1 9 2 4
<배열>       <연산 결과>
4번 연산은 왼쪽으로 90도 회전시키는 연산이다.

        1 6 2 9 8 4 → 4 2 9 1 5 8
        7 2 6 9 8 2 → 8 8 2 3 1 1
        1 8 3 4 2 9 → 9 9 4 2 6 3
        7 4 6 2 3 1 → 2 6 3 6 3 9
        9 2 3 6 1 5 → 6 2 8 4 2 2
        4 2 9 3 1 8 → 1 7 1 7 9 4
<배열>       <연산 결과>
5, 6번 연산을 수행하려면 배열을 크기가 N/2×M/2인 4개의 부분 배열로 나눠야 한다. 아래 그림은 크기가 6×8인 배열을 4개의 그룹으로 나눈 것이고, 1부터 4까지의 수로 나타냈다.

        1 1 1 1 2 2 2 2
        1 1 1 1 2 2 2 2
        1 1 1 1 2 2 2 2
        4 4 4 4 3 3 3 3
        4 4 4 4 3 3 3 3
        4 4 4 4 3 3 3 3
        5번 연산은, 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동시키는 연산이다.

        3 2 6 3 1 2 9 7 → 2 1 3 8 3 2 6 3
        9 7 8 2 1 4 5 3 → 1 3 2 8 9 7 8 2
        5 9 2 1 9 6 1 8 → 4 5 1 9 5 9 2 1
        2 1 3 8 6 3 9 2 → 6 3 9 2 1 2 9 7
        1 3 2 8 7 9 2 1 → 7 9 2 1 1 4 5 3
        4 5 1 9 8 2 1 3 → 8 2 1 3 9 6 1 8
<배열>            <연산 결과>
6번 연산은, 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동시키는 연산이다.

        3 2 6 3 1 2 9 7 → 1 2 9 7 6 3 9 2
        9 7 8 2 1 4 5 3 → 1 4 5 3 7 9 2 1
        5 9 2 1 9 6 1 8 → 9 6 1 8 8 2 1 3
        2 1 3 8 6 3 9 2 → 3 2 6 3 2 1 3 8
        1 3 2 8 7 9 2 1 → 9 7 8 2 1 3 2 8
        4 5 1 9 8 2 1 3 → 5 9 2 1 4 5 1 9
<배열>            <연산 결과>
입력
        첫째 줄에 배열의 크기 N, M과 수행해야 하는 연산의 수 R이 주어진다.

        둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.

        마지막 줄에는 수행해야 하는 연산이 주어진다. 연산은 공백으로 구분되어져 있고, 문제에서 설명한 연산 번호이며, 순서대로 적용시켜야 한다.

        출력
        입력으로 주어진 배열에 R개의 연산을 순서대로 수행한 결과를 출력한다.

        제한
        2 ≤ N, M ≤ 100
        1 ≤ R ≤ 1,000
        N, M은 짝수
        1 ≤ Aij ≤ 108*/


import java.util.Scanner;

public class Main_16935_배열_돌리기3 {
    static int map[][];
    static int n,m,r;
    static int[] comm;
    static int row,col;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        map = new int[n>=m?n:m][n>=m?n:m];
        comm = new int[r];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        row = n;
        col = m;

        for(int i=0; i<r; i++){
            comm[i] = sc.nextInt();
        }

        for(int i=0; i<r; i++){
            if(comm[i] == 1){
                operation_1();
            } else if(comm[i] == 2){
                operation_2();
            } else if(comm[i] == 3){
                operation_3();
            } else if(comm[i] == 4){
                operation_4();
            } else if(comm[i] == 5){
                operation_5();
            } else if(comm[i] == 6){
                operation_6();
            } else {
                //Error
            }
        }

        printMap();
    }

    static void operation_1(){
        for(int i=0; i<col; i++){
            int tmp;
            for(int j=0; j<row/2; j++){
                tmp = map[j][i];
                map[j][i] = map[row-1-j][i];
                map[row-1-j][i] = tmp;
            }
        }
    }

    static void operation_2(){
        for(int i=0; i<row; i++){
            int tmp;
            for(int j=0; j<col/2; j++){
                tmp = map[i][j];
                map[i][j] = map[i][col-1-j];
                map[i][col-1-j] = tmp;
            }
        }
    }

    static void operation_3(){
        int[][] tmp = new int[col][row];

        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++){
                tmp[i][j] = map[row-1-j][i];
            }
        }

        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++){
                map[i][j] = tmp[i][j];
            }
        }
        int temp = row;
        row = col;
        col = temp;
    }

    static void operation_4(){

        int[][] tmp = new int[col][row];

        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++){
                tmp[i][j] = map[j][col-1-i];
            }
        }

        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++){
                map[i][j] = tmp[i][j];
            }
        }

        int temp = row;
        row = col;
        col = temp;
    }

    static void operation_5(){
        int[][] tmp = new int[row/2][col/2];

        for(int i=0; i<row/2; i++){
            for(int j=0; j<col/2; j++){
                tmp[i][j] = map[i][j];
            }
        }

        for(int i=row/2; i<row; i++){
            for(int j=0; j<col/2; j++){
                map[i-row/2][j] = map[i][j];
            }

            for(int j=col/2; j<col; j++){
                map[i][j-col/2] = map[i][j];
            }

            for(int j=col/2; j<col; j++){
                map[i][j] = map[i-row/2][j];
            }

            for(int j=col/2; j<col; j++){
                map[i-row/2][j] = tmp[i-row/2][j-col/2];
            }
        }
    }

    static void operation_6() {
        int[][] tmp = new int[row / 2][col / 2];

        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col / 2; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < row/2; i++) {
            for (int j = 0; j < col/2; j++) {
                map[i][j] = map[i][col/2 + j];
            }
            for (int j = col/2; j < col; j++) {
                map[i][j] = map[row/2 + i][j];
            }
            for (int j = col/2; j < col; j++) {
                map[row/2 + i][j] = map[row/2 + i][j - col/2];
            }
            for (int j = 0; j < col/2; j++) {
                map[row/2 + i][j] = tmp[i][j];
            }
        }
    }



    static void printMap(){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
