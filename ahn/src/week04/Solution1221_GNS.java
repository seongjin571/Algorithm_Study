package week04;

/*숫자 체계가 우리와 다른 어느 행성이 있다. 아래는 이 행성에서 사용하는 0 ~ 9의 값을 순서대로 나타낸 것이다.

        "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"

        0 ~ 9 의 값을 나타내는 단어가 섞여 있는 문자열을 받아 작은 수부터 차례로 정렬하여 출력하는 프로그램을 작성하라.

        예를 들어 입력 문자열이 "TWO NIN TWO TWO FIV FOR" 일 경우 정렬한 문자열은 "TWO TWO TWO FOR FIV NIN" 이 된다.

        [입력]

        입력 파일의 첫 번째 줄에는 테스트 케이스의 개수가 주어진다.

        그 다음 줄에 #기호와 함께 테스트 케이스의 번호가 주어지고 공백문자 후 테스트 케이스의 길이가 주어진다.

        그 다음 줄부터 바로 테스트 케이스가 주어진다. 단어와 단어 사이는 하나의 공백으로 구분하며, 문자열의 길이 N은 100≤N≤10000이다.

        [출력]

        #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 정렬된 문자열을 출력한다.*/


import java.util.Arrays;
import java.util.Scanner;

public class Solution1221_GNS {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String tmp2;
        int idx = 0;

        String[] str = {"ZRO","ONE","TWO","THR","FOR","FIV","SIX","SVN","EGT","NIN"};
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int[] tmp;

        for(int i=0; i<n; i++) {
            String tmp1 = sc.next();
            tmp2 = sc.next();

            int num = Integer.parseInt(tmp2);

            tmp = new int[num];

            for(int j=0; j<num; j++){
                String strNum = sc.next();

                switch (strNum){
                    case "ZRO":
                        tmp[idx++] = 0;
                        break;
                    case "ONE":
                        tmp[idx++] = 1;
                        break;
                    case "TWO":
                        tmp[idx++] = 2;
                        break;
                    case "THR":
                        tmp[idx++] = 3;
                        break;
                    case "FOR":
                        tmp[idx++] = 4;
                        break;
                    case "FIV":
                        tmp[idx++] = 5;
                        break;
                    case "SIX":
                        tmp[idx++] = 6;
                        break;
                    case "SVN":
                        tmp[idx++] = 7;
                        break;
                    case "EGT":
                        tmp[idx++] = 8;
                        break;
                    case "NIN":
                        tmp[idx++] = 9;
                        break;
                }
            }
            Arrays.sort(tmp);

            System.out.println("#"+(i+1));
            for(int j=0; j<idx; j++){
                System.out.print(str[tmp[j]] + " ");
            }
            idx = 0;
            System.out.println();
        }
    }
}
