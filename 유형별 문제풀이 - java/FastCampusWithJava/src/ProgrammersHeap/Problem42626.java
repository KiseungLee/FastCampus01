package ProgrammersHeap;

import java.util.PriorityQueue;

public class Problem42626 {
	public static void main(String[] args) {
		Solution42626 sol = new Solution42626();
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int k = 7;
		System.out.println(sol.solution(scoville, k));
	}
}

class Solution42626{
	public int solution(int[] scoville, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		for(int i : scoville)
			heap.add(i);
		int count = 0;
		while(heap.peek()<k) {
			if(heap.size()<=1)
				return -1;
			count++;
			heap.add(heap.poll() + 2*heap.poll());
		}
		return count;
	}
}
