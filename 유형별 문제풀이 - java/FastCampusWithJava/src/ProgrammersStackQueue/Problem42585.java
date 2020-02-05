package ProgrammersStackQueue;

import java.util.Stack;

public class Problem42585 {
	public static void main(String[] args) {
		Solution42585 sol = new Solution42585();
		String arrangements = "()(((()())(())()))(())";
		System.out.println(sol.solution(arrangements));
	}
}

class Solution42585{
	public int solution(String arrangements) {
		char[] charArr = arrangements.replace("()", "x").toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		int count = 0;	// Áö³ª°£ xÀÇ °¹¼ö¸¦ ¼¼ÁÜ
		int result = 0;
		for(char c : charArr) {
			if(c=='(') {
				stack.add(count);
			}else if(c=='x'){
				count++;
			}else if(c==')') {
				result+=(count - stack.pop() + 1);
			}
		}
		return result;
	}
}