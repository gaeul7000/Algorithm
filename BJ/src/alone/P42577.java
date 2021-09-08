package alone;


public class P42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for(int i = 0; i < phone_book.length; i++) {
            int sub = phone_book[i].length();
            for(int j = 0; j < phone_book.length; j++) {
                if(i == j) continue;
                if(phone_book[i].equals(phone_book[j].substring(0, sub))) return false;
                else continue;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P42577 p = new P42577();

        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean answer = p.solution(phone_book);

        System.out.println(answer);
    }
    
}
