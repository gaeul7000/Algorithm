package alone;

public class P12945 {
    public int solution(int n) {
        int[] F = new int[n + 1];

        F[0] = 0;
        F[1] = 1;
        F[2] = 1;
        
        for(int i = 3; i <= n; i++) {
            F[i] = (F[i-1] + F[i-2]) % 1234567 ;
        }
        return F[n];
    }

    public static void main(String[] args) {
        P12945 p = new P12945();

        int n = 5;
        System.out.println(p.solution(n));
    }
    
}
