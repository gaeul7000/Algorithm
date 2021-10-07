package alone;


public class P12924 {
    public int solution(int n) {
        int answer = 1;

        int sum = 0;
        
        for(int i = 1; i <= n; i++){

            for(int j = i; j <= n; j++) {
                if(sum == n) {
                    answer++;
                    break;
                } else if (sum > n) break;

                sum += j;

            }
            sum = 0;
        }


        return answer;
    }

    public static void main(String[] args) {
        P12924 p = new P12924();

        int n = 15;
        int answer = p.solution(n);

        System.out.println(answer);
    }
    
}
