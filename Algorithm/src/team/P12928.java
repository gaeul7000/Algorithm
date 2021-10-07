package team;


/* N0.4
 * 2021.3 1ÁÖÂ÷
 * 
 */

class Solution2 {

	public int solution(int n) {
		int answer = 0;
		int i = 0;
		
		while(i<=n) {
			i++;
			if(n%i == 0) {
				answer += i;
			}
		}
		return answer;
	}
	
}
public class P12928 {
	
}
