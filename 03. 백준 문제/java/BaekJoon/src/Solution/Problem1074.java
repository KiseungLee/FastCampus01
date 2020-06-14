package Solution;

import java.util.Scanner;

public class Problem1074
{
	static int count = 0;
	static int r = 0;
	static int c = 0;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		sc.close();

		// 한 변이 2**n 인 이중 배열
		runZ( (int)Math.pow(2, n), 0, 0);
	}

	private static void runZ(int i, int j, int k)
	{
		if(j==r && k==c) 
		{
			System.out.println(count);
		}else if(i==1) 
		{
			count += 1;
		}
		else {
			if(i/2 > 0) {
				runZ(i/2, j, k);
				runZ(i/2, j, k + i/2);
				runZ(i/2, j + i/2, k);
				runZ(i/2, j + i/2, k + i/2);				
			}
		}
	}
	
	
}
