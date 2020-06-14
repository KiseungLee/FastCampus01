package Solution;

import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem7490
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int test_case = sc.nextInt();
		for (int i = 0; i < test_case; i++)
		{
			int n = sc.nextInt();
			Queue<Struct_> queue = new ArrayDeque<Struct_>();
			queue.add(new Struct_(1, "1"));
			List<String> list = new ArrayList<>();
			
			while (!queue.isEmpty()) {
				Struct_ now = queue.poll();
				if (now.num == n) {
					list.add(now.str);
				}else {
					queue.add(new Struct_(now.num+1, now.str+" "+String.valueOf(now.num+1)));															
					queue.add(new Struct_(now.num+1, now.str+"+"+String.valueOf(now.num+1)));
					queue.add(new Struct_(now.num+1, now.str+"-"+String.valueOf(now.num+1)));
				}
			}
			
			for (String string : list)
			{
				if (evalOnlyPlusMinus(string)==0) {
					System.out.println(string);					
				}
			}
			System.out.println();
		}

	}

	//
	private static int evalOnlyPlusMinus(String string)
	{
		char[] charArr = string.toCharArray();
		int result = 0;
		int num = 0;
		boolean isPlus = true;
		
		for (char c : charArr)
		{
			if (c=='+') {
				// 기존에 쌓은 num 연산 및 초기화
				if (isPlus)
					result += num;
				else
					result -= num;
				num = 0;
				// 다음 num 연산에 사용할 연산자 지정
				isPlus = true;
			}else if(c=='-'){
				// 기존에 쌓은 num 연산
				if (isPlus)
					result += num;
				else
					result -= num;
				num = 0;				
				// 다음 num 연산에 사용할 연산자 지정
				isPlus = false;
			}else if(c==' ') {
				continue;
			}else {
				num = num*10 + c - 48;
			}
		}
		// 마지막 숫자 연산
		if (isPlus)
			result += num;
		else
			result -= num;
		
		return result;
	}
}

class Struct_{
	int num;
	String str;
	public Struct_(int num, String str) {
		this.num = num;
		this.str = str;
	}
	
}