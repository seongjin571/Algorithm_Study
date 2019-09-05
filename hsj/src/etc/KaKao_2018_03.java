package etc;

class Solution {
    public int solution(int[] food_times, long k) {
        int answer = 0;
        int foodNum = food_times.length;
        int minNum = 100000000;
        for(int i = 0; i < foodNum; i++){
            minNum = minNum > food_times[i] ? food_times[i] : minNum;
        }
        if(k > minNum * foodNum) {
            for(int i = 0; i < foodNum; i++){
                food_times[i] -= minNum;
            }
            k -= minNum * foodNum;
            int idx = 0;
            int time = 0;
            while(time < k){
                time = time >= foodNum ? 0 : time;
                if(food_times[idx] != 0){
                    food_times[idx]--;
                    answer = idx;
                    time++;
                    idx++;
                }else{
                    idx++;
                } 
            }
            
        }
        else{
            answer = (int)(k % foodNum);
        }
        return answer - 1;
    }
}