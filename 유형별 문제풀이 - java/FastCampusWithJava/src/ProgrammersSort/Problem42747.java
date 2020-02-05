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
		// 1. �������� ����
		Integer[] array = Arrays.stream(citations)			// Instream
								.boxed()					// Stream<Integer>
								.toArray(Integer[]::new);	// Integer[]
		Arrays.sort(array, Comparator.reverseOrder());
		
		// 2. i��°�� i+1���� ũ�� i+1���� ū �갡 i+1�� �̹Ƿ� H = i+1, ������ �̶�, i�� ū ������ �ٿ������� ��.
		for(int i=array.length-1 ; i>=0; i--) {
			if(array[i]>=i+1)
				return i+1;
		}
		return 0;
	}
}
