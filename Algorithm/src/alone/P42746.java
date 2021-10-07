package alone;

import java.util.Arrays;
import java.util.Comparator;

public class P42746 {
    public String solution(int[] numbers) {
        String answer = "";

        String[] order = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            order[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(order, new Comparator<String>(){
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o2.compareTo(o1);
                } else if(o1.substring(0,1).equals(o2.substring(0,1))) {
                    return Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2);
                }
                return o2.compareTo(o1);
            }
        });

        for(String x: order) {
            if("0".equals(x) && answer.length() == 0) continue;
            else answer += x;
        }
        if(answer.length() == 0) answer = "0";
    

        return answer;
    }

    public static void main(String[] args){
        P42746 p = new P42746();

        int[] numbers = {0,0,0,0};

        String answer = p.solution(numbers);

        System.out.println(answer);
    }
    
}
