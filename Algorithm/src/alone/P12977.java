package alone;


import java.util.ArrayList;

class P12977 {
    static ArrayList<Integer> checkarr = new ArrayList<>();
    static int count = 0;
    public int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        
        combi(nums, visited, 0, nums.length, 3);

        return count;
    }
    
    public void combi(int[] arr, boolean[] visited, int start, int n, int r){
        if(r == 0) {
            checkarr.clear();
            for(int i = 0; i < arr.length; i++){
                if(visited[i]) checkarr.add(arr[i]);
            }
            
            for(int x: checkarr){
                System.out.print(x);
            }
            System.out.println("");
            if(check(checkarr)) count++;
            return;
        }
        
        for(int i = start; i < n; i++){
            visited[i] = true;
            combi(arr, visited, i + 1, n, r -1);
            visited[i] = false;
        }
    }
    
    public boolean check(ArrayList<Integer> arr){
        int sum = 0;
        int count = 2;
        
        for(int x: arr) sum += x;
        
        for(int i = 1; i <= sum; i++){
            if(sum % i == 0) count--;
            
            if(count < 0) return false;
        }
        return true;
    }
}
