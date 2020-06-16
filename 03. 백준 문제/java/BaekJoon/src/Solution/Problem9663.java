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
		// r, c �ڸ��� ����
		chessBoard[r][c] = true;
		
		// ��Ʈ��ŷ ������
		if(backTrack(r, c)) {
			// r�� ������ ���̸� Ƚ�� +1
			if(r==n-1) {
				count++;
			}else {
				// ���� row DFS ��� ����				
				for (int i = 0; i < chessBoard.length; i++)
					dfs(r+1, i);
			}
			// �� ������ �� ġ��� ����
			chessBoard[r][c] = false;
			return;				
		}else {
			// ��� ���н� r, c �ڸ� ������ ����ϰ� ����			
			chessBoard[r][c] = false;
			return;
		}

	}

	// r, c�� ���� ��Ʈ��ŷ �غ���
	private static boolean backTrack(int r, int c)
	{
		for (int i = 1; r-i >=0; i++)
		{
			// ����
			if(chessBoard[r-i][c])
				return false;
			// �밢�� ����
			if (c-i>=0 && chessBoard[r-i][c-i])
				return false;
			// �밢�� ������
			if (c+i<n && chessBoard[r-i][c+i])
				return false;
		}
		return true;
	}
}
