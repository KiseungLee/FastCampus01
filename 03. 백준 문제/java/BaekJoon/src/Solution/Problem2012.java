package Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2012
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		sc.close();
		
		Arrays.sort(arr);
		
		long result = 0;
		for (int i = 0; i < arr.length; i++)
			result += Math.abs((i+1) - arr[i]);

		
		System.out.println(result);
	}
}
