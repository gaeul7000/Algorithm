package alone;

import java.util.Scanner;

/* N0.1
 * 2021.2 2ÁÖÂ÷
 * 
 */


public class BJ10828 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int stackSize = scanner.nextInt();
		int[] stack = new int[stackSize-1];
		String command;
		int pushNumber;
		int index=0;
		
		while(stackSize>0) {
		
			command = scanner.next();
			
			if(command.equals("push")) {
				pushNumber = scanner.nextInt();
				push(stack, pushNumber, index);
			}else if(command.equals("pop")){
				pop(stack, index);
			}else if(command.equals("size")) {
				size(index);
			}else if(command.equals("empty")) {
				empty(index);
			}else if(command.equals("top")) {
				top(stack, index);
			}
			
			stackSize--;
		}
	}

	static void push(int arr[], int x, int index) {
		arr[index] = x;
		index++;
	}

	static void pop(int arr[], int index) {
		if(index == 0) {
			System.out.println("-1");
		} else {
			System.out.println(arr[index]);
			
			index -= 1;
		}
		
	}
	
	static void size(int index) {
		System.out.println(index);
	}
	
	static void empty(int index) {
		if(index==0) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}
	
	static void top(int arr[], int index) {
		if(index==0) {
			System.out.println("-1");
		}else {
			System.out.println(arr[index]);
		}
	}
	
}