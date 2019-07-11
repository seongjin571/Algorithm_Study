package week06;

/*4 종류의 괄호문자들 '()', '[]', '{}', '<>' 로 이루어진 문자열이 주어진다.

        이 문자열에 사용된 괄호들의 짝이 모두 맞는지 판별하는 프로그램을 작성한다.

        예를 들어 아래와 같은 문자열은 유효하다고 판단할 수 있다.



        아래와 같은 문자열은 유효하지 않은 문자열이다. 붉은색으로 표시된 괄호의 짝을 찾을 수 없기 때문이다.



        아래 문자열은 열고 닫는 괄호의 개수는 유효하나 짝이 맞지 않는 괄호가 사용 되었기 때문에 유효하지 않다.



        [입력]

        각 테스트 케이스의 첫 번째 줄에는 테스트케이스의 길이가 주어지며, 바로 다음 줄에 테스트 케이스가 주어진다.

        총 10개의 테스트케이스가 주어진다.

        [출력]

        #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 유효성 여부를 1 또는 0으로 표시한다 (1 - 유효함, 0 - 유효하지 않음).*/

import java.util.Scanner;

public class Solution_1218_괄호_짝짓기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i=1; i<=10; i++){
            int n = sc.nextInt();
            String str = sc.next();

            int result[] = new int[8];

            for(int j=0; j<n; j++){
                if(str.charAt(j) == '(') result[0]++;
                else if(str.charAt(j) == ')') result[1]++;
                else if(str.charAt(j) == '[') result[2]++;
                else if(str.charAt(j) == ']') result[3]++;
                else if(str.charAt(j) == '{') result[4]++;
                else if(str.charAt(j) == '}') result[5]++;
                else if(str.charAt(j) == '<') result[6]++;
                else if(str.charAt(j) == '>') result[7]++;
            }

            if(result[0]==result[1] && result[2]==result[3] && result[4]==result[5] && result[6]==result[7]){
                System.out.println("#" + i + " " + "1");
            } else {
                System.out.println("#" + i + " " + "0");
            }
        }
    }
}
