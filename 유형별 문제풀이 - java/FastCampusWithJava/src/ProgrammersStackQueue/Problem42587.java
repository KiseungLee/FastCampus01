package ProgrammersStackQueue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem42587 {
	public static void main(String[] args) {
		Solution42587 sol = new Solution42587();
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		System.out.println(sol.solution(priorities, location));
	}
}

class Solution42587{
	public int solution(int[] priorities, int location) {
		// 우선순위 큐 만들때 비교하는 걸 둘 수 있다.
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				if(a<b)
					return 1;
				else
					return -1;
			}
		});
		// 위치 큐
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int i : priorities) {
			queue.add(i);
			heap.add(i);
		}

		int count = 0;
		while(!queue.isEmpty()) {
			if(queue.peek()==heap.peek()) {
				if(location==0) {
					return ++count;
				}else {
					heap.poll();
					queue.poll();
					count++;
					location--;
				}
			}else {
				queue.add(queue.poll());
				location = (location==0?queue.size()-1:location-1);
			}
		}
		
		return -1;
	}
}