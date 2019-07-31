package week09;

/*문자열 P는 스스로를 계속 복제해서 매우 긴 문자열이 되었다.

        복제하는 방법은 다음과 같다.

        P0 = “0”

        Pi+1 = Pi + “0” + f(g(Pi))

        여기서, f(A) 함수는 문자열 A의 모든 문자를 반전시킨다.

        예를 들어서, f(“10110”) = “01001”이다.

        g(A)함수는 문자열 A를 좌우 반전 시킨다. 예를 들어서, g(“10110”) = “01101” 이다.

        위와 같은 복제 방법을 무한히 반복한 문자열 P의 K번째 문자가 무엇인지 구하여라.


        [입력]

        첫 번째 줄에 테스트 케이스의 수 T(1 ≤ T ≤ 100)가 주어진다.

        각 테스트 케이스마다 K(1 ≤ K ≤ 1018)가 주어진다.


        [출력]

        각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

        문자열 P의 K번째 문자가 무엇인지 구하여라.

        P1 = “001”

        P2­ = “0010011”

        P3 = “001001100011011”

        위와 같이 복제가 이루어질 것이다.

        따라서 3번째 문자는 1, 7번째 문자는 1, 10번째 문자는 0이다.*/


import java.util.Scanner;

public class Solution_7584_자가_복제_문자열 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        String p = "0";

        for(int tc=1; tc<=t; tc++){
            int k = sc.nextInt();

            String tmp = p;

            while(tmp.length() <= k){
                tmp = progressP(tmp);
            }

            System.out.println("#" + tc + " " + tmp.charAt(k-1));
        }
    }

    public static String f(String p){
        String result = "";

        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '0'){
                result += String.valueOf('1');
            }
            if(p.charAt(i) == '1'){
                result += String.valueOf('0');
            }
        }

        return result;
    }

    public static String g(String p){
        String result = "";

        for(int i=0; i<p.length(); i++){
            result += String.valueOf(p.charAt(p.length()-1-i));
        }

        return result;
    }

    public static String progressP(String p){
        String result = "";

        result = p + "0" + f(g(p));

        return result;
    }
}
