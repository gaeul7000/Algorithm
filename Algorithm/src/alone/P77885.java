package alone;

import java.util.Stack;

public class P77885 {
    static String binNum;
    static long ans;
    static Stack<StringBuilder> st = new Stack<>();

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        boolean[] visited;
        for(int i = 0; i < numbers.length; i++) {
            binNum = Long.toBinaryString(numbers[i]);
            binNum = "0" + binNum;
            ans = Long.MAX_VALUE;;
            visited = new boolean[binNum.length()];

            st.push(new StringBuilder(binNum));
            dfs(1, visited);
            answer[i] = ans;

        }

        return answer;
    }

    public void dfs(int index, boolean[] visited) {
        if(ans == Long.parseLong(binNum, 2) + 1) return;

        while(!st.isEmpty()) {
            for(int i = 0; i < binNum.length(); i++) {
                if(index <= 2 && !visited[i]) {
                    StringBuilder tmp = new StringBuilder(st.peek());
                    visited[i] = true;

                    if(tmp.charAt(i) == '0') tmp = tmp.replace(i, i + 1, "1");
                    else tmp = tmp.replace(i, i + 1, "0");
                    
                    if(Long.parseLong(tmp.toString(), 2) > Long.parseLong(binNum, 2)) {
                        ans = Math.min(ans, Long.parseLong(tmp.toString(), 2));
                    }

                    st.push(tmp);
                    dfs(index + 1, visited);
                    visited[i] = false;
                }
            }
            
            st.pop();
            return;
        }
    }

    public static void main(String[] args) {
        P77885 p = new P77885();

        long[] numbers = {2, 7};
        long[] answer = p.solution(numbers);

        for(long x: answer) {
            System.out.println(x);
        }
    }
    
}
