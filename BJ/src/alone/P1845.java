package alone;

import java.util.*;
import java.util.Map.Entry;

class Solution {
    static int count = 0;
    
    public int solution(int[] nums) {
        
        int choose = nums.length/2;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int x : nums){
            if(map.containsKey(x)) map.put(x, map.get(x) + 1);
            else map.put(x, 1);
        }
        
        if(map.size() > choose) return choose;
        else return map.size();
    }
    
}
public class P1845 {
    public static void main(String[] args) throws Exception {

        Solution s = new Solution();

        int[] st = {3, 3, 3, 2, 2, 2};
        
        int an = s.solution(st);

        System.out.println(an);
    }
}
