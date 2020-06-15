package Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Problem12865
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] items = new int[n][2];
		for (int i = 0; i < items.length; i++)
			items[i] = new int[] {sc.nextInt(), sc.nextInt()};
		sc.close();
		
		// dp[i][j] : 물품을 0~i 번재 까지만 고려하고 무게 제한이 k일 때 최대 가치
		// dp[i][j] = i번째 물품을 넣고 dp[i-1][j-i번째무게 ]+i번째 가치를 넣는냐, i번재 물품을 넣지 않고 dp[i-1][j]를 그대로 가져오느냐
		int[][] dp = new int[n][k+1];
		
		for (int i = 0; i < n; i++)
		{
			if(i==0) {
				for (int j = 0; j < k+1; j++)
				{
					if(items[i][0]<=j)
						dp[i][j] = items[i][1];
				}
			}else {
				for (int j = 0; j < k+1; j++)
				{
					if(j-items[i][0]>=0)
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i][0]] + items[i][1]);
					else
						dp[i][j] = dp[i-1][j];
				}				
			}
		}

		System.out.println(dp[n-1][k]);
	}
}
