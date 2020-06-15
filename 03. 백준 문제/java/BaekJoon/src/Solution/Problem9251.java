package Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Problem9251
{	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String word1 = sc.nextLine();
		String word2 = sc.nextLine();
		sc.close();
		
		// dp[i][j] : word1�� i��° ������, word2�� j��° ������ �ִٰ� ������ �� ���� ���� �κ� ����
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		for (int i = 0; i < word1.length(); i++)
		{
			for (int j = 0; j < word2.length(); j++)
			{
				if(word1.charAt(i)==word2.charAt(j))
					dp[i+1][j+1] = dp[i][j] + 1;
				else
					dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
			}
			System.out.println((i+1)+" : " +Arrays.toString(dp[i+1]));
		}
		
		System.out.println(dp[word1.length()][word2.length()]);
	}
}
