package alone;

public class P42883 {
    static long max = 0;

    public String solution(String number, int k) {

        boolean[] visited = new boolean[number.length()];
        combi(number.split(""), visited, 0, number.length(), number.length() - k);

        return Long.toString(max);
    }

    public void combi(String[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            String tmp = "";
            for(int i = 0; i < n; i++) {
                if(visited[i]) tmp += arr[i];
            }
            max = Math.max(Long.parseLong(tmp), max);
            return;
        }

        for(int i = start; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                combi(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        P42883 p = new P42883();

        String number = "1924";
        int k = 2;

        String answer = p.solution(number, k);

        System.out.println(answer);
    }
    
}
