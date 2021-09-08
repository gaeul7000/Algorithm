package alone;

public class P42746 {
    static int max = 0;
    public String solution(int[] numbers) {

        int[] output = new int[numbers.length];
        boolean[] visited = new boolean[numbers.length];

        perm(numbers, output, visited, 0, numbers.length, numbers.length);
        return Integer.toString(max);
    }

    public void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            String tmp = "";
            for(int x: output) {
                tmp += Integer.toString(x);
            }
            max = Math.max(max, Integer.parseInt(tmp));
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        P42746 p = new P42746();

        int[] numbers = {3, 30, 34, 5, 9};

        String answer = p.solution(numbers);

        System.out.println(answer);
    }
    
}
