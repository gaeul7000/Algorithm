package alone;

/* N0.5
 * 2021.3 2ÁÖÂ÷
 * 
 */

class Solution2{
	public int solution(int n) {
		int answer=0;
		int[] rec = new int[11];
		
		rec[0] = 1;
		rec[1] = 2;
		rec[2] = 4;
		
		for(int i=3;i<n;i++) {
			rec[i] = rec[i-3] + rec[i-2] + rec[i-1];
		}
		
		answer = rec[n-1];
		return answer;
	}
}
public class BJ9095 {
}
