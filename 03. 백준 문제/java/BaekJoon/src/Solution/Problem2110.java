package Solution;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Problem2110
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = 1000000000;
		
		while(left<=right) {
			int mid = (left+right)/2;
			if(isPossible(arr, c, mid)) {
				left = mid + 1;
			}else {
				right = mid - 1;				
			}
		}
		
		System.out.println(right);
	}

	// �־��� gap���� n�� �̻��� ��ġ �� �� �ִ���
	private static boolean isPossible(int[] arr, int n, int gap)
	{
		// ���� ��ġ �� ��
		int now = arr[0];
		// �� �տ� ��ġ�ϰ� ����
		int count = 1;
		for (int i = 0; i < arr.length-1; i++)
		{
			// ���� �ִ� ������ ���� �������� gap �̻��̸� ��ġ
			if(arr[i+1] - now >= gap) {
				count += 1;
				now = arr[i+1];
			}
		}
		
		if(count>=n) {
			// System.out.println("gap "+gap + " is possible");
			return true;			
		}else {
			// System.out.println("gap "+gap + " is not possible");
			return false;
		}
	}
}
