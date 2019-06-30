package d2;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution_Coding_Test05 {
    public int solution(int[] A) {
        int arrayLength = A.length;
        int maxSatisfy = 0;
        int satisfy = 0;
        boolean[][] visit = new boolean[arrayLength][arrayLength];
        for(int i = 0; i < arrayLength; i++){
            for(int j = 0; j < arrayLength; j++){
                if(visit[i][j] == false){
                    int dist = Math.abs(i-j);
                    satisfy = A[i]+A[j]+dist;
                    visit[i][j] = true;
                    visit[j][i] = true;
                }
                maxSatisfy = Math.max(maxSatisfy, satisfy);
            }
        }
        return maxSatisfy;
        // write your code in Java SE 8
    }
}