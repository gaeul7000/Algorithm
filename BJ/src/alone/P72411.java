package alone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class P72411 {
    
    static HashMap<String,Integer> map = new HashMap<>();
    static HashMap<Integer,Integer> maxMap = new HashMap<>();
    static String[] orderCopy;
    static int start = 0;
    static int maxOrder = 0;

    public String[] solution(String[] orders, int[] course) {
        String[] answer;

        String total = "";
        orderCopy = orders.clone();

        for(String x: orders) {
            for(char y: x.toCharArray()) {
                if(!total.contains(Character.toString(y))) total += y;
            }
            maxOrder = Math.max(maxOrder, x.length());
        }
        start = course[0];
        maxOrder = Math.min(maxOrder, course[course.length - 1]);

        String tmp = "";

        boolean[] visited = new boolean[total.length()];
        combi(total.split(""), visited, 0, total.length(), maxOrder);

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

        if(r >= start || r <= maxOrder) {
            ArrayList<String> tmpArr = new ArrayList<>();
            String tmp = "";
            for(int i = 0; i < arr.length; i++) {
                if(visited[i]) tmpArr.add(arr[i]);
            }
            Collections.sort(tmpArr);
    
            for(String x: tmpArr) tmp += x;
            
            map.put(tmp, check(tmp));
            
        }
        if(r == 0 ) {
            return;
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            combi(arr, visited, i + 1, n, r-1);

            visited[i] = false;
        }
    }

    public int check(String word) {
        String[] words = word.split("");
        int flag = 0;
        int count = 0;

        for(String x: orderCopy) {
            if(x.length() >= words.length) {
                for(String y: words) {
                    if(x.contains(y)) flag++;
                }
                if(flag == word.length()) count++;
                flag = 0;
            }
        }
        if(maxMap.containsKey(words.length)) maxMap.put(words.length, Math.max(maxMap.get(words.length),count));
        else maxMap.put(words.length, count);
        return count;
    }

    public static void main(String[] args) {
        P72411 s = new P72411();

        String[] arr = {"ABCD", "ABCD", "ABCD"};
        int[] arr2 = {2, 3, 4};

        String[] answer = s.solution(arr, arr2);
        for(String x: answer){
            System.out.println(x);
        }

    }
    
        
}
