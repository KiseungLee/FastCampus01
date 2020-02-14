package ProgrammersBFSDFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;

public class Problem43165 {
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		// Solution43165 sol = new Solution43165();
		Solution43165_2 sol = new Solution43165_2();
		System.out.println(sol.solution(numbers, target));
	}
}

class Solution43165{
	public int solution(int[] numbers, int target) {
		// 종료조건
		if(numbers.length==0) 
			return (target==0 ? 1 : 0);			
		
		// 맨 앞의 숫자, 그외 숫자들 나누기
		int num = numbers[0];
		int[] left = new int[numbers.length-1];
		for(int i=0; i<left.length; i++)
			left[i] = numbers[i+1];
		
		// 재귀
		return solution(left, target-num) + solution(left, target+num);
	}
}

class Solution43165_2{
	public int solution(int[] numbers, int target) {
		int count = 0;
		
		ArrayDeque<Integer> numbersQueue = new ArrayDeque<Integer>();
		for(int i : numbers)
			numbersQueue.add(i);
		
		ArrayDeque<Object[]> queue = new ArrayDeque<Object[]>();
		queue.add(new Object[] {numbersQueue, target});
		
		while(!queue.isEmpty()) {
			Object[] now = queue.pollFirst();
			if(((ArrayDeque<Integer>)now[0]).size()==0) {
				if((int)now[1]==0)
					count++;
			}else {
				int num = ((ArrayDeque<Integer>)now[0]).pollFirst();
				queue.add(new Object[] {((ArrayDeque<Integer>)now[0]).clone(), (int)now[1]-num});
				queue.add(new Object[] {((ArrayDeque<Integer>)now[0]).clone(), (int)now[1]+num});		
			}
		}
		return count;
	}
}