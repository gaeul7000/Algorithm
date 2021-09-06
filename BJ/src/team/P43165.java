package team;

import java.util.LinkedList;
import java.util.Queue;
// 타겟 넘버 만들기
class node {
    int index;
    int sum;
    
    public node(int i, int s){
        this.index = i;
        this.sum = s;
    }
}

class P43165 {
    static Queue<node> queue = new LinkedList<>();
    static int[] numbersCopy;
    static int targetCopy;
    
    public int bfs(int n){
        int index = 0;
        int sum = 0;
        
        int count = 0;
        
        queue.add(new node(index, -numbersCopy[n]));
        queue.add(new node(index, numbersCopy[n]));
        
        while(!queue.isEmpty()){
            node node = queue.poll();
            
            int i = node.index;
            int s = node.sum;
            
            if(i+1 < numbersCopy.length){
                queue.add(new node(i + 1, s-numbersCopy[i + 1]));
                queue.add(new node(i + 1, s+numbersCopy[i + 1]));
            }
            
            if(i == numbersCopy.length - 1 && s == targetCopy) count++;
        }
        
        return count;
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        numbersCopy = numbers;
        targetCopy = target;
        
        answer = bfs(0);
    
        return answer;
    }
    public static void main(String[] args){

        P43165 s = new P43165();
        
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int anw = s.solution(numbers, target);

        System.out.println(anw);

    }
}
