package ProgrammersSort;

import java.util.Arrays;
import java.util.Comparator;

public class Problem42747 {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(sol.solution(citations));
	}
}

class Solution3{
	public int solution(int[] citations) {
		// 1. 내림차순 정렬
		Integer[] array = Arrays.stream(citations)			// Instream
								.boxed()					// Stream<Integer>
								.toArray(Integer[]::new);	// Integer[]
		Arrays.sort(array, Comparator.reverseOrder());
		
		// 2. i번째가 i+1보다 크면 i+1보다 큰 얘가 i+1개 이므로 H = i+1, 하지만 이때, i는 큰 값부터 줄여나가야 함.
		for(int i=array.length-1 ; i>=0; i--) {
			if(array[i]>=i+1)
				return i+1;
		}
		return 0;
	}
}
