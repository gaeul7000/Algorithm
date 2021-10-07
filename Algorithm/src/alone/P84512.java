package alone;

import java.util.Stack;

public class P84512 {
    static String wordC = "";
    static int count = 0;
    static int answer = 0;
    static Stack<String> st = new Stack<>();
    static String[] words = {"A", "E", "I", "O", "U"};

    public int solution(String word) {

        boolean[][] visited = new boolean[5][5];
        wordC = word;

        st.push("");

        dfs(0, visited);
        return answer;
    }

    public void dfs(int index, boolean[][] visited) {
        if(answer != 0) return;

        if(wordC.equals(st.peek())) {
            answer = count;
            return;
        }

        while(!st.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                if (index < 5 && !visited[index][i]) {
                    count++;
                    visited[index][i] = true;
                    String tmp = st.peek() + words[i];

                    st.push(st.peek() + words[i]);
                    dfs(index + 1, visited);
                    visited[index][i] = false;
                }
            }
            st.pop();
            break;
        }

    }

    public static void main(String[] args) {
        P84512 p = new P84512();

        String word = "AAAE";

        int answer = p.solution(word);

        System.out.println(answer);
    }
    
}
