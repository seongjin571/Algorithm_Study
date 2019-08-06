package week09;

/*다음과 같이 Encoding 을 한다.

        1. 우선 24비트 버퍼에 위쪽(MSB)부터 한 byte씩 3 byte의 문자를 집어넣는다.

        2. 버퍼의 위쪽부터 6비트씩 잘라 그 값을 읽고, 각각의 값을 아래 [표-1] 의 문자로 Encoding 한다.



        입력으로 Base64 Encoding 된 String 이 주어졌을 때, 해당 String 을 Decoding 하여, 원문을 출력하는 프로그램을 작성하시오.

        [제약사항]
        문자열의 길이는 항상 4의 배수로 주어진다.
        그리고 문자열의 길이는 100000을 넘지 않는다.

        [입력]
        입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.
        다음 줄부터 각 테스트 케이스가 주어진다.
        테스트 케이스는 Encoding 된 상태로 주어지는 문자열이다.

        [출력]
        테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)*/


import java.util.Base64;
import java.util.Scanner;

public class Solution_1928_Base64_Decoder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int tc=1; tc<=t; tc++){
            String encoded = sc.next();
            String decode = new String(Base64.getDecoder().decode(encoded));

            System.out.println("#" + tc + " " + decode);
        }
    }
}
