package alone;

import java.util.Stack;

public class P12909 {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();

        for(char x: s.toCharArray()) {
            if(!st.isEmpty() && st.peek() == '(' && x == ')') st.pop();
            else st.push(x);
        }

        if(!st.isEmpty()) return false;
        else return true;
    }
    
}
