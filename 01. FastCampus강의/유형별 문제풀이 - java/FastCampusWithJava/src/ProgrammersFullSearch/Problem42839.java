package ProgrammersFullSearch;

import java.util.Arrays;
import java.util.Collections;

public class Problem42839 {
	public static void main(String[] args) {
		Solution42839 sol = new Solution42839();
		String numbers = "011";
		System.out.println(sol.solution(numbers));
	}
}

class Solution42839{
	public int solution(String numbers) {
		Integer[] intArr = new Integer[numbers.length()];
		int i = 0;
		for(char c : numbers.toCharArray())
			intArr[i++] = (int) c - 48;
		Arrays.sort(intArr, Collections.reverseOrder());
		int num = 0;
		for(int j=0; j<intArr.length; j++)
			num = 10*num+intArr[j];
		
		boolean[] bools = findPrime(num);
		// 길이가 l일때 P(l, l), P(l, l-1), P(l, l-2), ... , P(l, 1) 순열들에서 하나씩 뽑아냄
		
		// 하나씩 뽑은 거에서 소수판별
		
		return 1;
	}
	private int[] permutation(Integer[] n, int m) {
		int len = 1;
		for(int i=n.length; i>=n.length-m ;i--)
			len *= i;
		int[] result = new int[len];

		
		
		return result;
	}
	private boolean[] findPrime(int n) {
		boolean[] bools = new boolean[n+1];
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(bools[i]!=true) {
				int j=2;
				while(i*j <= n) {
					bools[i*j] = true;
					j++;
				}
			}
		}
		return bools;
	}
}