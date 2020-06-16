package Solution;

import java.util.Scanner;

public class Problem5585
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num = 1000 - sc.nextInt();
		
		int count = 0;
		
		count += num/500;
		num = num%500;
		
		count += num/100;
		num = num%100;
		
		count += num/50;
		num = num%50;
		
		count += num/10;
		num = num%10;
		
		count += num/5;
		num = num%5;
		
		count += num;
		System.out.println(count);
	}
}
