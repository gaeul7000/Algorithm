package alone;
public class P72412 {

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for(int i = 0; i < query.length; i++) {
            query[i] = query[i].replace("and ", "");
        }

        for(int i = 0; i < query.length; i++) {
            int count = 0;
            String[] q = query[i].split(" ");
            
            for(int j = 0; j < info.length; j++) {
                Boolean flag = true;
                String[] in = info[j].split(" ");

                for(int w = 0; w < q.length; w++) {

                    if(q[w].equals("-")) continue;

                    if((w < 4 && q[w].equals(in[w])) || (w == 4 && Integer.parseInt(q[w]) <= Integer.parseInt(in[w]))) continue;
                    
                    flag = false;
                }

                if(flag) count++;
            }
            answer[i] = count;
        }
        

        return answer;
    }
    

    public static void main (String[] args) {
        P72412 p = new P72412();

        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        int[] answer = p.solution(info, query);

        for(int x: answer) System.out.println(x);
    }
    
}
