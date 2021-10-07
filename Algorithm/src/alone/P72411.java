package alone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class P72411 {
    
    static HashMap<String,Integer> map = new HashMap<>();
    static HashMap<Integer,Integer> maxMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        String[] answer;

        String tmp = "";

        for(String x: orders) {
            boolean[] visited = new boolean[x.length()];
            combi(x.split(""), visited, 0, x.length(), x.length());
        }

        for(int x: course) {
            for(Entry<String, Integer> entry: map.entrySet()) {
                if(entry.getKey().length() == x && entry.getValue() == maxMap.get(x) && entry.getValue() > 1) tmp += entry.getKey() + ",";
            }
        }

        answer = tmp.split(",");
        Arrays.sort(answer);

        return answer;
    }

    public void combi(String[] arr, boolean[] visited, int start, int n, int r) {

        ArrayList<String> tmpArr = new ArrayList<>();

        String tmp = "";
        for(int i = 0; i < arr.length; i++) {
            if(visited[i]) tmpArr.add(arr[i]);
        }
        Collections.sort(tmpArr);
        
        for(String x: tmpArr) tmp += x;

        if(map.containsKey(tmp)) map.put(tmp, map.get(tmp) + 1);
        else map.put(tmp, 1);

        if(maxMap.containsKey(tmp.length())) maxMap.put(tmp.length(), Math.max(maxMap.get(tmp.length()), map.get(tmp)));
        else maxMap.put(tmp.length(), map.get(tmp));

        if(r == 0 )  return;

        for(int i = start; i < n; i++) {
            visited[i] = true;
            combi(arr, visited, i + 1, n, r-1);

            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        P72411 s = new P72411();

        String[] arr = {"XYZ", "XWY", "WXA"};
        int[] arr2 = {2, 3, 4};

        String[] answer = s.solution(arr, arr2);
        for(String x: answer){
            System.out.println(x);
        }

    }
    
        
}
