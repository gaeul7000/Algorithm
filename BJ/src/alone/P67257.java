package alone;

import java.util.ArrayList;

public class P67257 {
    static String[] output;
    static ArrayList<String> realOut = new ArrayList<>();
    public long solution(String expression) {
        long max = 0;
        String ex = "";
        String tmp = expression;

        for(String x: expression.split("")) {
            if(!ex.contains(x) && x.matches("[*+-]")) {
                ex += x;
            }
        }
        output = new String[ex.length()];
        boolean[] visited = new boolean[ex.length()];

        for(String x: ex.split("")) {
            tmp = tmp.replace(x, " "+x+" ");
        }
        String[] express = tmp.split(" ");

        prem(ex.split(""), output, visited, 0, ex.length(), ex.length());

        // for(String x: output) {
        //     for(int i=0; i < real.size() - 1; i++) {
        //         if(x.equals(real.get(i))) {
        //             int tmp1 = Integer.parseInt(real.get(i - 1));
        //             int tmp2 = Integer.parseInt(real.get(i + 1));
        //             real.remove(i - 1);
        //             real.remove(i - 1);
        //             real.remove(i - 1);
        //             real.add(i - 1, cal(tmp1, tmp2, x));
        //         }
        //     }
        // }

        for(String x: realOut) {
            max = Math.max(max, ans(express, x));
        }
 
        return max;
    }

    public void prem(String[] arr, String[] out, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            String tmp = "";
            for(String x: out) {
                System.out.print(x);
                tmp += x;
            }
            System.out.println(" ");
            realOut.add(tmp);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                prem(arr, out, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    public String cal(int x, int y, String sign) {
        int answer = 0;

        switch(sign) {
            case "*" :
                answer = x * y;
                break;
            case "+" :
                answer = x + y;
                break;
            case "-" :
                answer = x - y;
                break;
        }

        return Integer.toString(answer);
    }

    public int ans(String[] express, String sign) {
        
        ArrayList<String> arr = new ArrayList<>();
        for(String x: express) arr.add(x);

        for(String y: sign.split("")){
            for(int i=0; i < arr.size() - 1; i++) {
                if(y.equals(arr.get(i))) {
                    int tmp1 = Integer.parseInt(arr.get(i - 1));
                    int tmp2 = Integer.parseInt(arr.get(i + 1));
                    arr.add(i - 1, cal(tmp1, tmp2, y));
                    arr.remove(i);
                    arr.remove(i);
                    arr.remove(i);
                    i = 0;
                }
            }
        }

        return Math.abs(Integer.parseInt(arr.get(0)));

    }

    public static void main(String[] args){
        P67257 s = new P67257();

        String expression = "50*6-3*2";
        long answer = s.solution(expression);

        System.out.println(answer);
    }
    
}
