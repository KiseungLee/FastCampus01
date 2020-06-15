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
			// ���� �����ϴ� ���� ���� Ƚ��
			int count = 0;
			for (int j = 0; j < i; j++)
			{
				// arr[i]���� ���� ��鿡 ���ؼ��� ����
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
