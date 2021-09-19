package alone;

import java.util.Stack;

class Fight {
    double order;
    int round;

    public Fight(double o, int r) {
        this.order = o;
        this.round = r;
    }
}

public class P12985 {
    public int solution(int n, int a, int b)
    {
        Stack<Fight> A = new Stack<>();
        Stack<Fight> B = new Stack<>();
        int count = 0;

        A.push(new Fight(a, count));
        B.push(new Fight(b, count));

        while(true) {
            count++;
            if(Math.ceil(A.peek().order/2) == Math.ceil(B.peek().order/2)) break;
            A.push(new Fight(Math.ceil(A.peek().order/2), count));
            B.push(new Fight(Math.ceil(B.peek().order/2), count));
        }


        return count;
    }
    
    public static void main(String[] args) throws Exception {

        P12985 p = new P12985();

        int n = 8;
        int a = 4;
        int b = 7;
        
        int answer = p.solution(n, a, b);

        System.out.println(answer);
    }
    
}
