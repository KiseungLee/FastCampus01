package ProgrammersFullSearch;

import java.util.Arrays;

public class Problem42842 {
	public static void main(String[] args) {
		Solution42842 sol = new Solution42842();
		int brown = 8;
		int red = 1;
		System.out.println(Arrays.toString(sol.solution(brown, red)));
	}
}

class Solution42842{
	public int[] solution(int brown, int red) {
		final int sum = brown + red;
		for(int ver=2; ver<=sum/2 ; ver++) {
			if(sum%ver==0) {
				int hor = sum/ver;
				if(2*(hor+ver)-4==brown) 
					return new int[] {hor, ver};
			}
		}
		return null;
	}
}