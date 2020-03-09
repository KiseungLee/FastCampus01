package ProgrammersGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class Boxing {
	public static void main(String[] args) {
		int n = 5;
		int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
		Boxing boxing = new Boxing();
		System.out.println(boxing.solution(n, results));
	}
	public int solution(int n, int[][] results) {
		int result = 0;
		
		// key=winner : value=losers 
		HashMap<Integer, ArrayList<Integer>> winnerMap = getWinnerLoserMap(n, results, 1);
		// key=loser : value=winners
		HashMap<Integer, ArrayList<Integer>> loserMap = getWinnerLoserMap(n, results, 0);
		
		// for i in range(n):
		for (int i=1; i<=n ; i++) {
			// win bfs -> return number of losers by one winner
			int winNum = bfs(i, winnerMap);
			
			// lose bfs -> return number of winners by one loser
			int loseNum = bfs(i, loserMap);
			
			// if winNum+loseNum==n : can figure out order of i
			if(winNum+loseNum==n)
				result++;
		}
		return result;
	}
	
	public int bfs(int root, HashMap<Integer, ArrayList<Integer>>map) {
		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(!visited.contains(now)) {
				visited.add(now);
				if(map.containsKey(now)) {
					for(int num : map.get(now))
						queue.add(num);
				}
			}
		}
		
		return visited.size();
	}
	
	public HashMap<Integer, ArrayList<Integer>> getWinnerLoserMap(int n, int[][] results, int flag){
		// if flag==1 : make winnerMap; winnerMap is a Map which has a key as winner and a value as losers array
		// if flag==0 : make loserMap; loserMap is a Map which has a key as loser and a value as winners array
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int[] result : results) {
			if(!map.containsKey(result[1-flag]))
				map.put(result[1-flag], new ArrayList<Integer>());
			map.get(result[1-flag]).add(result[flag]);
		}
		return map;
	}
}
