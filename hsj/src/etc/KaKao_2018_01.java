package etc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class User{
    String state, id, name;
    User(String state, String id, String name){
        this.state = state;
        this.id = id;
        this.name = name;
    }
}
class Solution {
    public String[] solution(String[] record) {
        List<User> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int strCnt = 0;
        for(String str : record){
            int idSize = set.size();
            String[] oneState = str.split("\\s");
            String state = oneState[0];
            String id = oneState[1].substring(3);
            if(state.equals("Leave")){
                strCnt++;
                for(User user : list){
                    if(user.id.equals(id)){
                        list.add(new User("나갔습니다.", id, user.name));
                        break;
                    }
                }
            }else if(state.equals("Enter")){
                strCnt++;
                String name = oneState[2];
                list.add(new User("들어왔습니다.", id, name));
                set.add(id);
                if(set.size() == idSize){
                    for(User user : list){
                        if(user.id.equals(id)) user.name = name;
                    }
                }
            }else{
                String name = oneState[2];
                for(User user : list){
                    if(user.id.equals(id)) user.name = name;
                }
            }
        }
        String[] answer = new String[strCnt];
        for(int i = 0; i < strCnt; i++){
            User user = list.get(i);
            String name = user.name;
            String state = user.state;
            answer[i] = name + "님이 " + state;
        }
        return answer;
    }
}
