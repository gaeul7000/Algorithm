package alone;

import java.util.Stack;

class stock {
    int index;
    int price;

    public stock(int i, int p) {
        this.index = i;
        this.price = p;
    }
}

public class P42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<stock> st = new Stack<>();

        for(int i = 0; i < prices.length; i++) {
            while(true){
                if(!st.isEmpty() && st.peek().price > prices[i]) {
                    answer[st.peek().index] = i - st.pop().index;
                }else break;
            }
            st.push(new stock(i, prices[i]));
        }

        while(!st.isEmpty()) {
            answer[st.peek().index] = (prices.length - 1) - st.pop().index;
        }
        return answer;
    }

    public static void main(String[] args) {
        P42584 p = new P42584();

        int[] prices = {5, 8, 6, 2, 4, 1};

        int[] answer = p.solution(prices);

        for(int x: answer) System.out.println(x);
    }
    
}
