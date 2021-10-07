package team;

import java.util.Stack;

// 괄호 체크 스택 문제

class P76502 {
    int count = 0;
    
    public int solution(String s) {

        String[] st = new String[s.length()];
        st = s.split("");
        
        for(int i = 0; i < s.length(); i++){
            check(st);
            rollArray(st);
        }

        return count;
    }

    public void check(String[] s){
        
        if(s[0].equals(")") || s[0].equals("}") || s[0].equals("]")) return;

        Stack<String> stack = new Stack<>();

        for(String x : s){
            
            if(x.equals("(") || x.equals("{") || x.equals("[")) stack.push(x);
            else if((x.equals(")") || x.equals("}") || x.equals("]")) && stack.isEmpty()) return;
            else {
                switch(x){
                    case ")" :
                        if(stack.peek().equals("(")) stack.pop();
                        else stack.push(x);
                        break;
                    case "}" :
                        if(stack.peek().equals("{")) stack.pop();
                        else stack.push(x);
                        break;
                    case "]" :
                        if(stack.peek().equals("[")) stack.pop();
                        else stack.push(x);
                        break;
                }
            }    
        }

        if(stack.isEmpty()) count++;
        else return;
    }

    public void rollArray(String[] s){
        String k = "";

        k = s[0];
        for(int i = 0; i < s.length-1; i++){
            s[i] = s[i+1];
        }
        s[s.length-1] = k;

    }
    public static void main(String[] args) throws Exception {

        P76502 s = new P76502();

        String st = "}]()[{";
        int anw = s.solution(st);

        System.out.println("asw" + anw);
    }
}
