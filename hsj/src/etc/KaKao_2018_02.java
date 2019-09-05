package etc;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Fail implements Comparable<Fail>{
    int stage;
    double failRate;
    Fail(int stage, double failRate){
        this.stage = stage;
        this.failRate = failRate;
    }
    @Override
    public int compareTo(Fail fail){
        if(this.failRate < fail.failRate){
            return 1;
        }else if(this.failRate == fail.failRate){
            return 0;
        }else{
            return -1;
        }
    }
}
class Solution {
    public int[] solution(int N, int[] stages) {
        List<Fail> list = new ArrayList<>();
        int peopleNum = stages.length;
        int[] stageArr = new int[N];
        for(int i = 0; i < peopleNum; i++){
            if(stages[i] > N) continue;
            else stageArr[stages[i] - 1]++;
        }
        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(cnt == peopleNum){
                list.add(new Fail(i + 1, 0));
            }else{
                list.add(new Fail(i + 1, (double)stageArr[i]/(double)(peopleNum - cnt)));
                cnt += stageArr[i];
            }
        }
        Collections.sort(list);
        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            Fail fail = list.get(i);
            answer[i] = fail.stage;
         }
        return answer;
    }
}