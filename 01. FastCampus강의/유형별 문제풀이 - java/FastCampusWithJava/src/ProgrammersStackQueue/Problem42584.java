package ProgrammersStackQueue;

import java.util.Arrays;
import java.util.Stack;

public class Problem42584 {
	public static void main(String[] args) {
		Solution42584 sol = new Solution42584();
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(sol.solution(prices)));
	}
}

class Solution42584{
	public int[] solution(int[] prices) {
		Stack<int[]> stack = new Stack<int[]>();	// int[] = {idx, time, value} -> idx랑 time이랑 같아서 하나 지워도 될듯
		int time = 0;
		int[] result = new int[prices.length];
		for(int i = 0; i<prices.length ; i++){
			while(!stack.isEmpty() && stack.peek()[2]>prices[i]) {
				int[] pop = stack.pop();
				result[pop[0]] = time - pop[1];
			}
			stack.add(new int[] {i, time, prices[i]});
			time++;
		}
		while(!stack.isEmpty()) {
			int[] pop = stack.pop();
			result[pop[0]] = time - pop[1] -1;
		}
		return result;
	}
}