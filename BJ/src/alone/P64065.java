package alone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P64065 {
    public int[] solution(String s) {
        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList<>();
        HashMap<Integer, String> order = new HashMap<>();

        s = s.substring(2);
        s = s.substring(0,s.length()-2);
        s = s.replace("},{", "-");

        String[] str = s.split("-");

        for(String x: str) {
            order.put(checkCount(x,','), x);
        }
        Object[] orders = order.keySet().toArray();
        Arrays.sort(orders);

        for(Integer key: order.keySet()){
            String[] strs = order.get(key).split(",");
    
            for(String x: strs) {
                if(!answerList.contains(Integer.parseInt(x))) answerList.add(Integer.parseInt(x));                
            }
        }
        answer = new int[answerList.size()];

        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public int checkCount(String string, char find) {
        int count = 0;

        for(char x: string.toCharArray()) {
            if(x == find) count++;
        }

        return count;
    }
    
    public static void main(String[] args) {
        P64065 p = new P64065();

        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int[] answer = p.solution(s);

        for(int x: answer) {
            System.out.println(x);
        }
    }
}
