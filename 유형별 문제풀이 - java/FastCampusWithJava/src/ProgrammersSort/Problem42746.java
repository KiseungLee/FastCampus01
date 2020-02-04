package ProgrammersSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem42746 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println(sol.solution(numbers));
	}
}

class Solution2{
	public String solution(int[] numbers) {
		for(int i=0; i<numbers.length;i++) {
			for(int j=i ; j<numbers.length-1 ; j++) {
				
				if(compare(numbers[j+1], numbers[j])) {
					System.out.println(Arrays.toString(numbers));
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		return "";
	}
	
	private boolean compare(int a, int b) {
		// 10*a+b - 10*b+a
		if( a-b >= 0)
			return true;
		else
			return false;
	}
}