package alone;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String x : participant){
            if(map.containsKey(x)) map.put(x, map.get(x) + 1);
            else map.put(x, 1);
        }
        
        for(String x : completion){
            if(map.containsKey(x) && map.get(x) > 1) map.put(x, map.get(x) - 1);
            else map.remove(x);
        }
        
        for(Entry<String, Integer> entry : map.entrySet()){
            answer = entry.getKey();
        }
        return answer;
    }
}