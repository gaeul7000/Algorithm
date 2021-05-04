import java.util.*;
import java.util.Map.Entry;

class Solution {
    static int count = 0;
    
    public int solution(int[] nums) {
        
        int choose = nums.length/2;
        
        boolean[] isVisited = new boolean[nums.length];
        
        combi(nums, isVisited, 0, nums.length, choose);
        
        return count;
    }
    
    
    public void combi(int[] arr, boolean[] isVisited, int start, int n, int r){
        
        if(r == 0) checkCount(arr, isVisited, n);
        else {
            for(int i = start; i < n; i++){
                isVisited[i] = true;
                combi(arr, isVisited, i + 1, n, r - 1);
                isVisited[i] = false;
            }
            
        }
        
    }
    
    public void checkCount(int arr[], boolean[] isVisited, int n){
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            if(isVisited[i]){
                if(map.containsKey(arr[i]) && map.get(arr[i]) >= 1) map.put(arr[i], map.get(arr[i]) + 1);
                else map.put(arr[i], 1);
            }
            if(isVisited[i]){
                System.out.print(arr[i]+ " ");
            }
        }
        System.out.println("");
        
        if(map.size() > count) count = map.size();
        
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
