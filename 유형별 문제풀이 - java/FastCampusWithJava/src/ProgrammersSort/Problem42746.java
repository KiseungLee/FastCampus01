package ProgrammersSort;

import java.util.Arrays;
import java.util.Comparator;

public class Problem42746 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println(sol.solution(numbers));
	}
}

class Solution2{
	public String solution(int[] numbers) {
		Integer[] list = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
		Arrays.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String str1 = o1.toString() + o2.toString();
				String str2 = o2.toString() + o1.toString();
				if(Integer.parseInt(str1) >= Integer.parseInt(str2))
					return -1;
				else
					return 1;
			}
		});
		StringBuffer sb = new StringBuffer();
		for(int i : list)
			sb.append(String.valueOf(i));
		return sb.toString();
	}
}