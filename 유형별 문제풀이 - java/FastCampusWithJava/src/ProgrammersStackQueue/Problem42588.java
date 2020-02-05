package ProgrammersStackQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Problem42588 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] heights = {3,9,9,3,5,7,2};
		System.out.println(Arrays.toString(sol.solution(heights)));
	}
}

class Solution{
	public int[] solution(int[] heights) {
		int[] result = new int[heights.length];
		for(int i = heights.length-1 ; i>=0 ; i--) {
			result[i] = 0;
			for(int j = i-1; j>=0 ; j--) {
				if(heights[i]<heights[j]) {
					result[i] = j+1;
					break;
				}
			}
		}
		return result;
	}
}

// 스택 써서 풀었는데 반복문 두번 쓰는거랑 속도 차이 별로 안난다. 오히려 더 느린거 같은데
class Solution2{
	public int[] solution(int[] heights) {
		Stack<int[]> stack = new Stack<int[]>();
		int[] result = new int[heights.length];
		
		for(int i = heights.length-1; i>=0 ;i--) {
			while(!stack.isEmpty() && heights[i]>stack.peek()[1]) {
				result[stack.pop()[0]] = i+1;
			}
			stack.push(new int[]{i, heights[i]}) ;
		}
		
		while(!stack.isEmpty()) {
			result[stack.pop()[0]] = 0;
		}
		
		return result;
	}
}