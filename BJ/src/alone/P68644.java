package alone;

//조합

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class P68644 {
    static Map<Integer,Integer> map = new HashMap<>();
    static int sum = 0;
    public int[] solution(int[] numbers) {
        int[] realA;
        boolean[] visited = new boolean[100];
        combi(numbers, visited, 0, numbers.length, 2);

        realA = new int[map.size()];
        int i=0;

        for(Entry<Integer, Integer> entry: map.entrySet()){
            realA[i] = entry.getKey();
            i++;
        }

        Arrays.sort(realA);
        return realA;
    }
    
    public void combi(int[] arr, boolean[] visited, int start, int n, int r){
        if(r == 0){
            for(int i = 0; i < n; i++){
                if(visited[i]){
                    sum += arr[i];
                }
            }
            map.put(sum, 0);
            sum = 0;
            return;
        }
        
        for(int i = start; i < n; i++){
            visited[i] = true;
            combi(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    } 
}
