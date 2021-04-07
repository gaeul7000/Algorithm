package team;
import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        
        Map<Integer, Integer> wantsMap = new HashMap<>();
        
        for (int i = 0; i < wants.length; i++) {
        	if (wantsMap.containsKey(wants[i])) {
        		wantsMap.put(wants[i], wantsMap.get(wants[i]) + 1);
        	} else wantsMap.put(wants[i], 1);
        }
        
        for (int i = 0; i < gift_cards.length; i++) {
        	if (wantsMap.containsKey(gift_cards[i]) && wantsMap.get(gift_cards[i]) > 1) {
        		wantsMap.put(gift_cards[i], wantsMap.get(gift_cards[i]) - 1);
        	} else if (wantsMap.containsKey(gift_cards[i])) {
        		wantsMap.remove(gift_cards[i]);
        	}
        }
        
        for(Entry<Integer, Integer> entry: wantsMap.entrySet()) {
        	answer += entry.getValue();
        }
        
        return answer;
    } 
}

public class KC01 {

	public static void main(String[] args) {
	}

}
