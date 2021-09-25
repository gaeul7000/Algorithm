package alone;

public class P12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2[0].length; j++){

            for(int w = 0; w < arr1[0].length; w++){


                    answer[i][j] += arr1[i][w] * arr2[w][j];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P12949 p = new P12949();

        int[][] arr1 = {{2,3,2}, {4,2,4}, {3,1,4}};
        int[][] arr2 = {{5,4}, {2,4}, {3, 1}};

        int[][] answer = p.solution(arr1, arr2);

        for(int[] x: answer){
            for(int y: x) {
                System.out.print(y+ " ");
            }
            System.out.println(" ");
        }
    }
    
}
