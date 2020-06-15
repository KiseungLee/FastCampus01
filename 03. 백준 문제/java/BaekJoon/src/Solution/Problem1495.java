package Solution;

import java.util.Scanner;

public class Problem1495
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		int[] volumes = new int[n];
		for (int i = 0; i < volumes.length; i++)
		{
			volumes[i] = sc.nextInt();
		}
		boolean[] volumes1 = new boolean[m+1];
		boolean[] volumes2 = new boolean[m+1];
		volumes1[s]=true;
		
		boolean isImpossible = true;
		for (int i = 0; i < volumes.length; i++)
		{
			isImpossible = true;
			for (int j = 0; j < volumes1.length; j++)
			{
				if(volumes1[j]) {
					if(j-volumes[i]>=0) {
						isImpossible = false;
						volumes2[j-volumes[i]] = true;
					}
					if(j+volumes[i]<=m) {
						isImpossible = false;
						volumes2[j+volumes[i]] = true;
					}					
					volumes1[j] = false;
				}
			}
			if(isImpossible)
				break;
			// 다 돌면 volumes1은 모두 false로, volumes2는 가능한 값돌로 차있음
			// 모두 false인 배열을 다시 volumes2에게 주고 기존의 volumes2는 volumes1으로 가져옴
			boolean[] temp = volumes2;
			volumes2 = volumes1;
			volumes1 = temp;
		}
		
		// 중간에 볼륨 조절 실패할 경우
		if(isImpossible)
			System.out.println(-1);
		else {
			for (int i = volumes1.length-1; i >= 0; i--)
			{
				if(volumes1[i]) {
					System.out.println(i);
					break;
				}
			}			
		}

		
	}
}
