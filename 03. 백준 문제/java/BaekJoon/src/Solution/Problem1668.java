package Solution;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Problem1668
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		// 왼쪽에서 볼 때
		int tallest = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if(arr[i]>tallest) {
				tallest = arr[i];
				count += 1;
			}
		}
		System.out.println(count);
		
		// 오른쪽에서 볼 때
		tallest = 0;
		count = 0;
		for (int i = arr.length-1; i >= 0; i--){
			if(arr[i]>tallest){
				tallest = arr[i];
				count += 1;
			}
		}
		System.out.println(count);
	}
}
