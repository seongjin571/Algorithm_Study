package week09;

/*은빈이는 시간 개념이 없다.

        은빈이를 보고 있자면 코리아 타임이라는 단어가 왜 생겼는지 알 수 있는 것 같다.

        호석이는 은빈이를 위해 프로그램을 작성해주려고 한다.

        현재 시각과 약속 시각을 알려주면 약속까지 남은 시간을 알려주는 프로그램이다.

        현재 시각보다 약속 시각이 더 빠른 경우에는, 약속이 다음 날에 있는 것이다.

        모든 시간은 00:00:00 ~ 23:59:59 사이로 표현되고 XX:XX:XX 형태이며, 숫자가 2자리가 아닐 경우에는 0으로 채운다.

        현재 시각과 약속 시각을 받으면 남은 시간을 알려주는 프로그램을 작성해라.


        [입력]

        첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

        각 테스트 케이스의 첫 번째 줄에는 현재 시각이 주어지고 두 번째 줄에는 약속 시각이 주어진다. 현재 시각이 약속 시각보다 빠르다.


        [출력]

        각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

        남은 시간을 XX:XX:XX 형태로 출력하라.*/

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Solution_7732_시간_개념 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            String curTime = sc.next();
            String promiseTime = sc.next();


            String result = getTime(curTime, promiseTime);

            System.out.println("#" + tc + " " + result);
        }
    }

    public static String getTime(String curTime, String promiseTime){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        if(promiseTime.equals("00:00:00")){
            promiseTime = "24:00:00";
        }

        Date d1 = format.parse(curTime,new ParsePosition(0));
        Date d2 = format.parse(promiseTime,new ParsePosition(0));

        long culDate = d2.getTime() - d1.getTime();

        long totalSec = culDate/(1000);
        long time = totalSec/3600;
        long min = (totalSec%3600)/60;
        long sec = (totalSec%3600)%60;

        String tmp = Long.toString(time) + ":" + Long.toString(min) + ":" + Long.toString(sec);

        Date resultDate = new SimpleDateFormat("HH:mm:ss").parse(tmp,new ParsePosition(0));

        String result = new SimpleDateFormat("HH:mm:ss").format(resultDate);

        return result;
    }
}
