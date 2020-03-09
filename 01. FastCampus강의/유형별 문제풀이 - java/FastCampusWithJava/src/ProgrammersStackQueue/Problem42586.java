package ProgrammersStackQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Problem42586 {
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		System.out.println(Arrays.toString(sol.solution(progresses, speeds)));
		
	}
}

class Solution4{
	public int[] solution(int[] progresses, int[] speeds) {
		int time = 0;
		int progressIdx = 0;
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int i : progresses)
			queue.add(i);
		
		List<Integer> resultList = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			time++;
			int deployOnce = 0;
			while(!queue.isEmpty() && queue.peek()+time*speeds[progressIdx]>=100) {
				queue.poll();
				deployOnce++;
				progressIdx++;
			}
			if(deployOnce!=0)
				resultList.add(deployOnce);
		}
		
		return resultList.stream().mapToInt(i -> i).toArray();
	}
}
