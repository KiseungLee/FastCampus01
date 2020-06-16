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
		// 입력
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		c = sc.nextInt();
		sc.nextLine();
		arr = sc.nextLine().replaceAll(" ", "").toCharArray();
		sc.close();
		
		// 정렬
		Arrays.sort(arr);
		// 빈 패스워드 초기화
		password = new char[l];
		
		// 1. DFS로 l개로 이루어진 비밀번호를 구함
		for (int i = 0; i <= arr.length-l; i++)
		{
			// password의 0번째에 arr[i] 문자를 넣어 보겠다.
			dfs(0, i);
		}
		// 2. 만들어진 비밀번호가 최소 한 개의 모음, 최소 두개의 자음을 만족하는 지 체크후 출력
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
