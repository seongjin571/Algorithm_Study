package week02;

import java.util.Scanner;

/*연월일 순으로 구성된 8자리의 날짜가 입력으로 주어진다.
        [그림1] 22220228 -> 2222/02/28

        해당 날짜의 유효성을 판단한 후, 날짜가 유효하다면

        [그림1] 과 같이 ”YYYY/MM/DD”형식으로 출력하고,

        날짜가 유효하지 않을 경우, -1 을 출력하는 프로그램을 작성하라.


        연월일로 구성된 입력에서 월은 1~12 사이 값을 가져야 하며

        일은 [표1] 과 같이, 1일 ~ 각각의 달에 해당하는 날짜까지의 값을 가질 수 있다.


        ※ 2월의 경우, 28일인 경우만 고려한다. (윤년은 고려하지 않는다.)


        [입력]

        입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.

        다음 줄부터 각 테스트 케이스가 주어진다.


        [출력]

        테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.

        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)*/

public class Solution2056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String date;
        int month, day;


        for(int i=0; i<num; i++){
            date = sc.next();

            System.out.print("#" + (i+1) + " ");

            month = (date.charAt(4)-'0')*10 + (date.charAt(5)-'0');
            day = (date.charAt(6)-'0')*10 + (date.charAt(7)-'0');

            if((month < 1 || month > 12) || (day < 1 || day > 31)) { System.out.println("-1"); }
            else {
                switch(month){
                    case 1: case 3: case 5:  case 7: case 8: case 10: case 12:
                        for(int j=0; j<8; j++){
                            if(j==4 || j==6) System.out.print("/");
                            System.out.print(date.charAt(j));
                        }
                        break;
                    case 2:
                        if(day > 28) { System.out.println("-1"); break; }
                        else {
                            for(int j=0; j<8; j++){
                                if(j==4 || j==6) System.out.print("/");
                                System.out.print(date.charAt(j));
                            }
                            break;
                        }
                    case 4: case 6: case 9: case 11:
                        if(day > 30) { System.out.println("-1"); break; }
                        else {
                            for(int j=0; j<8; j++){
                                if(j==4 || j==6) System.out.print("/");
                                System.out.print(date.charAt(j));
                            }
                            break;
                        }
                }
            }
        }
    }
}