package ProgrammersBFSDFS;

import java.util.HashMap;
import java.util.HashSet;

public class Problem43162 {
	public static void main(String[] args) {
		Solution43162 sol = new Solution43162();
		// int n = 3;
		// int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		int n = 4;
		int[][] computers = {{1,0,0,1},{0,1,1,1},{0,1,1,0},{1,1,0,1}};
		System.out.println(sol.solution(n, computers));
	}
}

class Solution43162{
	public int solution(int n, int[][] computers) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i<n ; i++)
			map.put(i, i);
		
		for(int i=0; i<computers.length ; i++) {
			for(int j=0; j<computers[i].length; j++) {
				if(computers[i][j]==1 && i!=j) {
					int parent = map.get(i);
					map.put(j, parent);					
				}
			}
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i : map.keySet()) {
			set.add(map.get(i));
		}
		return set.size();
	}
}