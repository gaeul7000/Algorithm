package alone;

import java.util.Arrays;

public class P42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i].length() < phone_book[i+1].length()) {
                int sub = phone_book[i].length();
                if(phone_book[i].equals(phone_book[i+1].substring(0,sub))) return false;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P42577 p = new P42577();

        String[] phone_book = {"119","1", "97674223", "1195524421"};
        boolean answer = p.solution(phone_book);

        System.out.println(answer);
    }
    
}
