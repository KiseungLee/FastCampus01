package ProgrammersGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Queue;

public class FarNode {
	public int solution(int n, int[][] edge) {
		int result = 0;
		
		// make adjacent map - make map
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int[] now : edge) {
			if(!map.containsKey(now[0]))
				map.put(now[0], new ArrayList<Integer>());
			map.get(now[0]).add(now[1]);
			
			if(!map.containsKey(now[1]))
				map.put(now[1], new ArrayList<Integer>());
			map.get(now[1]).add(now[0]);
		}
		// make adjacent map - sort map values
		for(int key : map.keySet())
			Collections.sort(map.get(key));
		
		// visited list, queue
		int[] visited = new int[n];
		Queue<int[]> queue = new ArrayDeque<int[]>();
		
		// maxNum to solve the problem
		int maxNum = 0;
		
		// bfs
		queue.add(new int[] {1, 1});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			if(visited[now[0]-1]==0) {
				visited[now[0]-1] = now[1];
				
				if(maxNum<now[1])
					maxNum = now[1];
							
				if(map.containsKey(now[0])) {
					for (int num : map.get(now[0]))
						queue.add(new int[] {num, now[1]+1});
				}
			}
		}
		
		// get return
		for(int num:visited) {
			if(num==maxNum)
				result++;
		}
		
		return result;
	}
}
