package team;

import java.util.LinkedList;
import java.util.Queue;

//토마토

class ripeLocation{
	int x;
	int y;
	int day;
	public ripeLocation(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.day = d;
	}
} 

class Solution7576{
	public int solution(int x, int y, int arr[][]) {
		int answer = 0;
		int notRipeTo = x * y; //전체 토마토 개수
		Queue<ripeLocation> q = new LinkedList<>();
		
		int[] dr = {0, 0, -1, 1};
		int[] dc = {-1, 1, 0, 0}; //왼 오 위 아
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				if(arr[i][j] == 1) q.add(new ripeLocation(i, j, 0));
				if(arr[i][j] == -1) notRipeTo -= 1; //토마토 없는 상자 개수 파악
			}
		}
		
		notRipeTo = notRipeTo - q.size(); //안익은 토마토 개수 
		
		while(!q.isEmpty()) {
			ripeLocation node = q.poll();
			int r = node.x;
			int c = node.y;
			int d = node.day;
			
			for(int i = 0; i < 4; i++) {
				if(0 <= (r + dr[i]) && (r + dr[i]) < x && 0 <= (c + dc[i]) && (c + dc[i]) < y && arr[r + dr[i]][c + dc[i]] == 0) {
					arr[r + dr[i]][c + dc[i]] = 1;
					q.add(new ripeLocation(r + dr[i], c + dc[i], d + 1));
					notRipeTo -= 1;
				}
			}
			answer = d;
		}
		
		if(notRipeTo != 0) answer = -1;
		
		return answer;
	}
}

public class BJ7576 {

	public static void main(String[] args) {
		
		int x = 4;
		int y = 6;
		int[][] arr = {{1,-1,0,0,0,0},{0,-1,0,0,0,0},{0,0,0,0,-1,0},{0,0,0,0,-1,1}};
		
		Solution7576 s = new Solution7576();
		
		int answer = s.solution(x, y, arr);
		
		System.out.println(answer);
	}

}
