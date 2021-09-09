package alone;

public class P42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        double a = 1;
        double b = -((brown+4)/2);
        double c = yellow + brown;

        double D = b * b - ( 4 * a * c);

        if(D == 0) {
            answer[0] = (int)((-b) / (2 * a));
            answer[1] = (int)((-b) / (2 * a));
        } else {
            answer[0] = (int)(((-b) + Math.sqrt(D)) / (2 * a));
            answer[1] = (int)(((-b) - Math.sqrt(D)) / (2 * a));
        }
        
        return answer;
    }


    public static void main(String[] args) {
        P42842 p = new P42842();

        int brown = 8;
        int yellow = 1;

        int[] answer = p.solution(brown, yellow);

        for(int x : answer)  System.out.println(x);
       
    }
    
}
