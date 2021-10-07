package alone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Paper{
    String num;
    boolean[] isvisited;

    public Paper(String n, boolean[] v) {
        this.num = n;
        this.isvisited = v.clone();
    }
}

public class P42839 {
    static ArrayList<Boolean> arr = new ArrayList<>();

    public int solution(String numbers) {
        int answer = 0;
        String tmp = "";
        String[] number = numbers.split("");
        Arrays.sort(number, Collections.reverseOrder());

        for(String x: number) tmp += Integer.parseInt(x);

        if(Integer.parseInt(tmp) >= 2) eratos(Integer.parseInt(tmp));
        else return 0;

        
        Queue<Paper> q = new LinkedList<>();
        ArrayList<Integer> out = new ArrayList<>();

        boolean[] isvisited = new boolean[number.length];
        q.add(new Paper("", isvisited));

        while(!q.isEmpty()) {
            Paper p = q.poll();
            String num = p.num;
            boolean[] v = p.isvisited.clone();

            for(int i = 0; i < number.length; i++) {
                if(!v[i]) {
                    v[i] = true;
                    q.add(new Paper(num + number[i], v));
                    v[i] = false;
                    if(!out.contains(Integer.parseInt(num + number[i]))) out.add(Integer.parseInt(num + number[i]));
                }
            }
        }
        
        for(int x: out) {
            if(arr.get(x)) answer++;
        }

        return answer;
    }

    public void eratos(int n) {

        arr.add(false);
        arr.add(false);

        if(n < 2) return;

        for(int i = 2; i <= n; i++) arr.add(true);

        for(int i = 2; (i * i) <= n; i++) {
            for(int j = i * i; j <= n; j += i) arr.set(j, false);
        }

    }


    public static void main(String[] args) {
        P42839 p = new P42839();

        String numbers = "011";

        int answer = p.solution(numbers);

        System.out.println(answer);
    }
    
}
