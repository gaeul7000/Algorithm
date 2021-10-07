package alone;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class printer {
    int prior;
    boolean target;

    public printer(int p, boolean t) {
        this.prior = p;
        this.target = t;
    }
}

public class P42587 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        int max = 0;

        Queue<printer> q = new LinkedList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < priorities.length; i++) {
            q.add(new printer(priorities[i], (location == i) ? true : false));

            if(map.containsKey(priorities[i])) map.put(priorities[i], map.get(priorities[i]) + 1);
            else map.put(priorities[i], 1);

            max = Math.max(max, priorities[i]);
        }

        while(!q.isEmpty()) {
            printer pr = q.poll();
            int prior = pr.prior;
            boolean target = pr.target;

            if(prior != max) q.add(pr);
            else {
                answer++;
                if(target) return answer;
                
                if(map.get(prior) == 1) map.remove(prior);
                else map.put(prior, map.get(prior) - 1);

                max = Collections.max(map.keySet());
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        P42587 p = new P42587();

        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        int answer = p.solution(priorities, location);

        System.out.println(answer);
    }
    
}
