package Solution;

import java.util.Scanner;

public class Problem1568
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sing = 1;
		int time = 0;
		while (n>0) {
			if (sing<=n) {
				n -= sing++;				
				time += 1;
			}else {
				sing = 1;
			}
		}
		System.out.println(time);
	}
}