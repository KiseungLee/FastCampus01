package Solution;

import java.util.Scanner;

public class Problem1904
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int a = 0;
		int b = 1;
		while(n>0) {
			int c = (a+b)%15746;
			a = b;
			b = c;
			n--;
		}
		System.out.println(b);
	}
}
