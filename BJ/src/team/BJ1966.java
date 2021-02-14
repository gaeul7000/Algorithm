package team;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;


/* N0.1
 * 2021.2 2주차
 * 
 */


public class BJ1966 {
	public static void main(String []arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		int testCount = scanner.nextInt(); //test case 개수
		int[] result = new int[testCount];
		for(int i=0;i<result.length;i++) {
			result[i]=0;
		}
		
		for(int i=0;i<testCount;i++) {
			Scanner scanner2 = new Scanner(System.in);
			int index = scanner2.nextInt(); //프린터에 들어갈 문서 갯수
			int resultIndex = scanner2.nextInt(); //알고자 하는 문서의 순서
						
			int count = index-1;
			
			int[] documents = new int[index];
			for(int j=0;j<index;j++) {
				documents[j] = scanner2.nextInt();
			}
			
			int[] copyDocuments = documents.clone();
			
			Integer[] sortedDocuments = new Integer[index]; //문서를 내림차순으로 정렬할 배열 선언
			for(int j=0;j<documents.length;j++) {
				sortedDocuments[j] = documents[j];
			}
			Arrays.sort(sortedDocuments, Collections.reverseOrder());
			
			while(count>=0) {
				
				if(documents[0]==sortedDocuments[0]) {
					if(copyDocuments[resultIndex]==sortedDocuments[0]) {
						result[i]++;
						break;
					}else {
						for(int j=0;j<count;j++) {
							documents[j] = documents[j+1];
							sortedDocuments[j] = sortedDocuments[j+1];
						}
						count--;
						result[i]++;
					}
				}else {
					int save = documents[0];
					for(int j=0;j<count;j++) {
						documents[j] = documents[j+1];
					}

					documents[count] = save;
					
				}
			}	
		}
		
		for(int i=0;i<testCount;i++) {
			System.out.println(result[i]);
		}
		
	}

}
