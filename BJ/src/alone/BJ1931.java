package alone;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/* N0.3
 * 2021.2 4주차
 * 
 */
class Meet implements Comparable<Meet>{
	private int start;
	private int finish;

	public Meet(int st, int fi){
		this.start = st;
		this.finish = fi;
	}
	
	public int getLength() {
		return finish - getStart();
	}

	public int getStart() {
		return start;
	}
	
	public int getFinish() {
		return finish;
	}
	
	public String toString() {
		return "start :" + start + " finish :" + finish + " length :"+getLength(); 
	}


	@Override
	public int compareTo(Meet meet) {
		// TODO Auto-generated method stub
		return start - meet.start;
	}
}

public class BJ1931 {
	public static void main(String[] args) throws Exception{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int testCount = Integer.parseInt(bufferedReader.readLine());
		
		ArrayList<Meet> list = new ArrayList<Meet>();
		String[] data = new String[2];
		int[] data_n = new int[2];
		
		for(int i=0;i<testCount;i++) {
			data = bufferedReader.readLine().split(" ");
			data_n = Arrays.stream(data).mapToInt(Integer::parseInt).toArray();
			list.add(new Meet(data_n[0],data_n[1]));
		} // 입력받기
		
		Collections.sort(list); // 시작 시간 순으로 정렬
		
		int time = list.get(testCount-1).getStart() - list.get(0).getStart();
		int meetingCount = 0;
		int deletePoint=0;
		
		while(time>0) {
			int size=list.size();
			for(int i=0; i < size;i++) {
				if(list.get(0).getLength()>list.get(i).getFinish()) {
					list.remove(0);
					size--;
					i--;
				}
			}
			if(list.size()<=0) {
				break;
			}
			time -= list.get(0).getLength();
			meetingCount++;
			deletePoint = list.get(0).getFinish();
			int j = 0;
			size = list.size();
			for(int i=0; i < size;i++) {
				if(deletePoint > list.get(i).getStart()) {
					list.remove(i);
					size--;
					i--;
				}
			}

		}
		System.out.println(meetingCount);
	}

}
