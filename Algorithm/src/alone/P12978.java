package alone;

import java.util.Stack;


class village {
    int next;
    int time;

    public village(int n, int t) {
        this.next = n;
        this.time = t;
    }
}

public class P12978 {
    static Stack<village> st = new Stack<>();
    static int[][] roadCopy;
    static int KC;
    static boolean[] totalVisited;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        boolean[] visited = new boolean[N];
        totalVisited = new boolean[N];
        KC = K;
        roadCopy = road.clone();

        visited[0] = true;
        totalVisited[0] = true;
        for(int[] x: road) {
            if(x[0] == 1 && x[2] <= K) {
                st.push(new village(x[1], x[2]));
                visited[x[1] - 1] = true;
                totalVisited[x[1] - 1] = true;
            } else if (x[1] == 1 && x[2] <= K) {
                st.push(new village(x[0], x[2]));
                visited[x[0] - 1] = true;
                totalVisited[x[0] - 1] = true;
            }
        }

        dfs(visited);

        for(boolean x: totalVisited) {
            if(x) answer++;
        }
        

        return answer;
    }

    public void dfs(boolean[] v) {
        if(st.size() == 0) return;


        boolean flag = true;
        for(boolean x: v) {
            if(!x) flag = false;
        }

        while(!st.isEmpty()) {
            village vil = st.pop();
            int n = vil.next;
            int t = vil.time;
            for(int i = 0; i < roadCopy.length; i++) {
                if(n == roadCopy[i][0] && t + roadCopy[i][2] <= KC && !flag) {
                    st.push(new village(roadCopy[i][1], t + roadCopy[i][2]));
                    totalVisited[roadCopy[i][1] - 1] = true;
                    v[roadCopy[i][1] - 1] = true;
                    dfs(v);
                    v[roadCopy[i][1] - 1] = false;
                } else if(n == roadCopy[i][1] && t + roadCopy[i][2] <= KC && !flag) {
                    st.push(new village(roadCopy[i][0], t + roadCopy[i][2]));
                    totalVisited[roadCopy[i][0] - 1] = true;
                    v[roadCopy[i][0] - 1] = true;
                    dfs(v);
                    v[roadCopy[i][0] - 1] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        P12978 p = new P12978();

        int N = 5;
        int[][] road = {{1, 2, 4}, {1, 3, 1}, {3, 4, 1}, {4, 2, 1}, {2, 5, 1}};
        int K = 4;

        int answer = p.solution(N, road, K);

        System.out.println(answer);
    }
    
}
