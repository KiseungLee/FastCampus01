package ProgrammersSort;

import java.util.Arrays;

public class Problem42748 {
// https://programmers.co.kr/learn/courses/30/lessons/42748?language=java
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(sol.solution(array, commands));
	}
}

class Solution{
	public int[] solution(int[] array, int[][] commands) {
		int[] result = new int[commands.length];
		for(int i =0 ; i<commands.length; i++) {
			int[] command = commands[i];
			
			int[] slice = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			/*
			int[] slice = new int[command[1]-command[0]+1];
			for(int j=0 ; j<slice.length ; j++) {
				slice[j] = array[command[0]-1+j];
			}
			*/
			Arrays.sort(slice);
			result[i] = slice[command[2]-1];
		}
		return result;
	}
}
