package team;

/* N0.3
 * 2021.2 4ÁÖÂ÷
 * 
 */
// 삼각형 채우기
class P68645{
	public int[] solution(int n) {
	        int[] answer;
	        int[][] triangle = new int[n][n];
	        
	        int max = sum(n);
	        answer = new int[max];
	        
	        for(int i=0;i<n;i++) {
	        	for(int j=0;j<=i;j++) {
	        		triangle[i][j]=-1;
	        	}
	        }
	      
	        int i = 0,j = 0;
	        int k = 1;
	        
	        triangle[i][j] = k;
	        
	        while(k<max) {
	        	
	        	while(i+1<n&&triangle[i+1][j]<0&&k<max) {
	        		triangle[++i][j] = ++k;
	        	}
	        	
	        	while(j+1<n&&triangle[i][j+1]<0&&k<max) {
	        		triangle[i][++j] = ++k;
	        	}
	        	
	        	while(i-1>0&&j-1>0&&triangle[i-1][j-1]<0&&k<max) {
	        		triangle[--i][--j] = ++k;
	        	}
	        }
	        
	        k=0;
	        
	        for(i=0;i<n;i++) {
	        	for(j=0;j<=i;j++) {
	        		answer[k++] = triangle[i][j];
	        	}
	        }
	        return answer;
	    }
	 
	 public int sum(int n) {
		 int max = 0;
		 
		 for(int i=1;i<=n;i++) {
			 max += i;
		 }
		 
		 return max;
	 }
}