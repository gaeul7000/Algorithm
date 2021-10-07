package team;

class Solution77884 {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++){
            if(check(i)) answer += i;
            else answer -= i;
        }
        return answer;
    }
    
    //for문 사용
    public boolean check(int n) {
        int count = 1;
        for(int i = 1; i < n; i++) if(n % i == 0) count++;
        
        if(count % 2 == 0) return true;
        else return false;
    }

    //오빠들한테 혼날까봐 제곱근여부 확인해서 체크(제곱근 존재할때만 약수가 홀수니까)
    public boolean check2(int n) {
        Double ch = Math.sqrt(n);
        if(ch == ch.intValue()) return false;
        else return true;
    }
}

public class P77884 {
    
}
