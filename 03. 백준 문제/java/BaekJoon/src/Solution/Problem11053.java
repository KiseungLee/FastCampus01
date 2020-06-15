package Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Problem11053
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		
		int[] dp = new int[n];
		
		for (int i = 0; i < dp.length; i++)
		{
			// 직전 증가하는 수와 증가 횟수
			int count = 0;
			for (int j = 0; j < i; j++)
			{
				// arr[i]보다 작은 얘들에 대해서만 수행
				if(arr[j]<arr[i]) {
					if(dp[j] > count) {
						count = dp[j];
					}
				}
			}
			dp[i] = count+1;
		}
		
		int maxNum = 0;
		for(int x : dp)
			maxNum = Math.max(maxNum, x);
		System.out.println(maxNum);
	}
}
