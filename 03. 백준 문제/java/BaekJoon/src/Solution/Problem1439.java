package Solution;

import java.util.Scanner;

public class Problem1439
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		
		int turnToOne = str.charAt(0)=='0' ? 1 : 0;
		int turnToZero = str.charAt(0)=='1' ? 1 : 0;
		for (int i = 0; i < str.length()-1; i++)
		{
			if(str.charAt(i)=='0' && str.charAt(i+1)=='1')
				turnToZero += 1;
			if(str.charAt(i)=='1' && str.charAt(i+1)=='0')
				turnToOne += 1;
		}
		
		System.out.println(Math.min(turnToOne, turnToZero));
	}
}
