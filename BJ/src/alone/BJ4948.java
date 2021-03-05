package alone;

import java.util.ArrayList;

/* N0.4
 * 2021.3 1ÁÖÂ÷
 * 
 */
class Solution{
	public int solution(int n) {
		
		ArrayList<Boolean> num = new ArrayList<Boolean>();
		int answer=0;
		
		num.add(false);
		num.add(false);
		
		for(int i=2;i<=2*n;i++) {
			num.add(true);
		}
		
		for(int i=2;(i*i)<=2*n;i++) {
			if(num.get(i)) {
				for(int j=(i*i);j<=2*n;j+=i) {
					num.set(j, false);
				}
			}
		}
		for(int i=n+1;i<2*n;i++) {
			if(num.get(i)) {
				answer++;
			}
		}
		
		return answer;
	}
}
public class BJ4948 {
	public static void main(String[] args) {

	}

}
