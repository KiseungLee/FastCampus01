package Solution;

import java.util.Scanner;

public class Problem9663
{
	static boolean[][] chessBoard;
	static int n;
	static int count;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		chessBoard = new boolean[n][n];
		
		for (int i = 0; i < n; i++)
			dfs(0, i);
		
		System.out.println(count);
	}
	
	static void dfs(int r, int c) {
		// r, c 자리에 놓고
		chessBoard[r][c] = true;
		
		// 백트랙킹 성공시
		if(backTrack(r, c)) {
			// r이 마지막 행이면 횟수 +1
			if(r==n-1) {
				count++;
			}else {
				// 다음 row DFS 재귀 돌림				
				for (int i = 0; i < chessBoard.length; i++)
					dfs(r+1, i);
			}
			// 다 끝나면 퀸 치우고 리턴
			chessBoard[r][c] = false;
			return;				
		}else {
			// 재귀 실패시 r, c 자리 놨던거 취소하고 리턴			
			chessBoard[r][c] = false;
			return;
		}

	}

	// r, c에 놓고 백트랙킹 해보기
	private static boolean backTrack(int r, int c)
	{
		for (int i = 1; r-i >=0; i++)
		{
			// 세로
			if(chessBoard[r-i][c])
				return false;
			// 대각선 왼쪽
			if (c-i>=0 && chessBoard[r-i][c-i])
				return false;
			// 대각선 오른쪽
			if (c+i<n && chessBoard[r-i][c+i])
				return false;
		}
		return true;
	}
}
