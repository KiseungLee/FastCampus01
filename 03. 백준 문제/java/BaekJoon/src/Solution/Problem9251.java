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
		
		// dp[i][j] : word1을 i번째 까지만, word2를 j번째 까지만 있다고 생각할 때 최장 공통 부분 수열
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
