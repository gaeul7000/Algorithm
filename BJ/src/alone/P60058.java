package alone;

import java.util.Stack;

public class P60058 {
    public String solution(String p) {
        String answer = "";

        if(checkRight(p)) return p;
        else answer = split(p);

        return answer;
    }

    public boolean checkRight(String tmp) {
        Stack<Character> st = new Stack<>();

        for(char c: tmp.toCharArray()) {
            if(!st.isEmpty() &&(st.peek() == '(' && c == ')')) st.pop();
            else st.push(c);
        }
        
        if(st.isEmpty()) return true;
        else return false;
    }

    public String split(String tmp) {
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        if(tmp.isEmpty()) return "";

        int flag = 0;

        for(int i = 0; i < tmp.length(); i++) {
            if(tmp.charAt(i) == '(') flag++;
            else flag--;

            if(flag == 0) {
                u.append(tmp.substring(0, i + 1));
                v.append(tmp.substring(i + 1));

                if(checkRight(u.toString())) u.append(split(v.toString()));
                else {
                    StringBuilder str = new StringBuilder();

                    str.append('(');
                    str.append(split(v.toString()));
                    str.append(')');
                    str.append(reverse(u.toString()));

                    return str.toString();
                }
                break;
            }

        }
        return u.toString();
    }

    public String reverse(String s){
        StringBuilder ss = new StringBuilder();
        for(int i = 1; i < s.length() - 1; i++) {
            if(s.charAt(i) == '(') ss.append(')');
            else ss.append('(');
        }

        return ss.toString();
    }

    public static void main(String[] args) {
        P60058 p = new P60058();

        String s = ")(";
        String answer = p.split(s);

        System.out.println(answer);
    }
    
}
