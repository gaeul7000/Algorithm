package alone;


import java.util.ArrayList;

class P72410 {
    public String solution(String new_id) {
        String answer = "";
        
        ArrayList<String> answerList = new ArrayList<>();
        
        //step 1 - ok
        new_id = new_id.toLowerCase();

        String[] answerCopy = new_id.split("");
        for(String x: answerCopy) answerList.add(x);

        ArrayList<String> deleteString = new ArrayList<>();
    
        //step 2 - ok
        for(String x: answerList){
            if((x.charAt(0) >= 97 && x.charAt(0) <= 122)) continue;
            else if((x.charAt(0) >= 48 && x.charAt(0) <= 57)) continue;
            else if(x.equals("-") || x.equals("_") || x.equals(".")) continue;
            else deleteString.add(x);
        }

        for(String x: deleteString) answerList.remove(x);

        //step 3 - ok
        for(int i = 0; i < answerList.size() -1; i++){
            if(answerList.get(i).equals(".") && answerList.get(i).equals(answerList.get(i + 1))){
                answerList.remove(i);
                i--;
            }
        }

        //step 4 - ok
        for(int i = answerList.size() - 1; i >= 0; i--){
            if(i == answerList.size() - 1 && answerList.get(i).equals(".")) answerList.remove(i);
            else if(i == 0 && answerList.get(i).equals(".")) answerList.remove(i);
        }

        if(answerList.isEmpty()) {
            answerList.add("a");
            answerList.add("a");
            answerList.add("a");
        }

        for(String x: answerList) System.out.print(x);
        System.out.println("");
        System.out.println(answerList.size());

        if(answerList.size() >= 16) {
            for(int i = 15; i < answerList.size(); i++) {
                answerList.remove(i);
                i--;

                if(i == answerList.size() - 1 && answerList.get(i).equals(".")) answerList.remove(i);
            }
        }

        if(answerList.size() <= 2) {
            String push = answerList.get(answerList.size() - 1);
            while(answerList.size() < 3){
                answerList.add(push);
            }
        }
        for(String x : answerList) answer += x;

        return answer;
    }
}

class P72410_2 { //정규식사용
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();

        new_id = new_id.replaceAll("[^-_.0-9a-z]", "");
        new_id = new_id.replaceAll("[.]{2,}", ".");
        new_id = new_id.replaceAll("^[.]|[.]$", "");

        if(new_id.equals("")) new_id += "a";


        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("^[.]|[.]$", "");
        }

        if(new_id.length() <= 2){
            while(new_id.length() < 3){
                new_id += new_id.charAt(new_id.length()-1);
            }
        }

        return new_id;
    }
}
