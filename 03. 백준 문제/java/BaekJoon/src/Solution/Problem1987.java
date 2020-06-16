package Solution;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem1987
{
	static int r;
	static int c;
	static char[][] board;
	static Set<Character> backTrackSet;
	static int max_count = 0;
	static int count = 0;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		board = new char[r][c];
		backTrackSet = new HashSet<Character>();
		sc.nextLine();
		
		for (int i = 0; i < r; i++)
			board[i] = sc.nextLine().trim().toCharArray();
		sc.close();
		
		dfs(0, 0);
		
		System.out.println(max_count);
	}
	private static void dfs(int x, int y)
	{
		if(!backTrackSet.contains(board[x][y])) {
			backTrackSet.add(board[x][y]);
			count++;
			
			max_count = Math.max(max_count, count);
			
			// 위
			if(x-1>=0)
				dfs(x-1, y);
			// 아래
			if(x+1<r)
				dfs(x+1, y);
			// 왼쪽
			if(y-1>=0)
				dfs(x, y-1);
			// 오른쪽
			if(y+1<c)
				dfs(x, y+1);				

			backTrackSet.remove(board[x][y]);
			count--;
		}
	}
	
	
}
