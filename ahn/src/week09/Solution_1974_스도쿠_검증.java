package week09;


/*스도쿠는 숫자퍼즐로, 가로 9칸 세로 9칸으로 이루어져 있는 표에 1 부터 9 까지의 숫자를 채워넣는 퍼즐이다.




        같은 줄에 1 에서 9 까지의 숫자를 한번씩만 넣고, 3 x 3 크기의 작은 격자 또한, 1 에서 9 까지의 숫자가 겹치지 않아야 한다.



        입력으로 9 X 9 크기의 스도쿠 퍼즐의 숫자들이 주어졌을 때, 위와 같이 겹치는 숫자가 없을 경우, 1을 정답으로 출력하고 그렇지 않을 경우 0 을 출력한다.


        [제약 사항]

        1. 퍼즐은 모두 숫자로 채워진 상태로 주어진다.

        2. 입력으로 주어지는 퍼즐의 모든 숫자는 1 이상 9 이하의 정수이다.


        [입력]

        입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.

        다음 줄부터 각 테스트 케이스가 주어진다.

        테스트 케이스는 9 x 9 크기의 퍼즐의 데이터이다.


        [출력]

        테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.

        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)*/

import java.util.Scanner;

public class Solution_1974_스도쿠_검증 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[][] sudoku;
        boolean flag;

        for(int tc=1; tc<=t; tc++){
            sudoku = new int[9][9];
            flag = true;

            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sudoku[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<9; i++){
                int sum1 = 0;
                int sum2 = 0;
                for(int j=0; j<9; j++){
                    sum1 += sudoku[i][j];
                    sum2 += sudoku[j][i];
                }
                if(sum1 != 45) flag = false;
                if(sum2 != 45) flag = false;
            }

            if(flag) {
                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){
                        int sum = 0;

                        for(int k=0; k<3; k++){
                            for(int l=0; l<3; l++){
                                sum += sudoku[i*3+k][j*3+l];
                            }
                        }

                        if(sum != 45) flag = false;
                    }
                }
            }

            if(flag) System.out.println("#" + tc + " " + 1);
            else System.out.println("#" + tc + " " + 0);
        }
    }
}
