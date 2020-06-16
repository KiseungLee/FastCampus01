package Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1759
{
	static char[] password;
	static int l;
	static int c;
	static char[] arr;
	public static void main(String[] args)
	{
		// �Է�
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		c = sc.nextInt();
		sc.nextLine();
		arr = sc.nextLine().replaceAll(" ", "").toCharArray();
		sc.close();
		
		// ����
		Arrays.sort(arr);
		// �� �н����� �ʱ�ȭ
		password = new char[l];
		
		// 1. DFS�� l���� �̷���� ��й�ȣ�� ����
		for (int i = 0; i <= arr.length-l; i++)
		{
			// password�� 0��°�� arr[i] ���ڸ� �־� ���ڴ�.
			dfs(0, i);
		}
		// 2. ������� ��й�ȣ�� �ּ� �� ���� ����, �ּ� �ΰ��� ������ �����ϴ� �� üũ�� ���
	}
	private static void dfs(int pwIdx, int arrIdx)
	{
		if(pwIdx>=l)
			return;
		
		password[pwIdx] = arr[arrIdx];
		if(pwIdx == l-1) {
			if(validation())
				System.out.println(String.valueOf(password));
		}else {
			for (int i = arrIdx+1; i < arr.length; i++)
				dfs(pwIdx+1, i);
		}
		
	}
	private static boolean validation()
	{
		int ja = 0;
		int mo = 0;
		for (int i = 0; i < password.length; i++)
		{
			if( password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || password[i] == 'o' || password[i] == 'u')
				mo++;
			else
				ja++;
		}
		if(ja>=2 && mo>=1)
			return true;
		else
			return false;
	}
}
