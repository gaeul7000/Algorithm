package team;

import java.util.LinkedList;
import java.util.Queue;

class node {
    int value;
    int index;
    int sum;
    
    public node(int v, int i, int s){
        this.value = v;
        this.index = i;
        this.sum = s;
    }
}

class Solution {
    static Queue<node> queue = new LinkedList<>();
    static int[] numbersCopy;
    static int targetCopy;
    
    public int bfs(int n){
        int index = 0;
        int sum = 0;
        
        int count = 0;
        
        queue.add(new node(-numbersCopy[n],index,-numbersCopy[n]));
        queue.add(new node(numbersCopy[n],index,numbersCopy[n]));
        
        while(!queue.isEmpty()){
            node node = queue.poll();
            
            int v = node.value;
            int i = node.index;
            int s = node.sum;
            
            if(i+1 < numbersCopy.length){
                queue.add(new node(-numbersCopy[i+1],i+1,s-numbersCopy[i+1]));
                queue.add(new node(numbersCopy[i+1],i+1,s+numbersCopy[i+1]));
            }
            
            if(i == numbersCopy.length-1 && s == targetCopy) count ++;
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
}

public class P43165 {
    public static void main(String[] args){

        Solution6 s = new Solution6();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int anw = s.solution(numbers, target);

        System.out.println(anw);

    }
}