package Solution;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Problem1697
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		if(n==k) {
			System.out.println(0);
		}else {
			Set<Integer> set1 = new HashSet<Integer>();
			Set<Integer> set2 = new HashSet<Integer>();
			boolean[] visited = new boolean[100001];
			visited[n] = true;
			set1.add(n);
			int time = 0;
			boolean isBreak = false;
			while(true) {
				time+=1;
				isBreak = false;
				for(int num : set1) {
					if(num+1==k || num-1==k || num*2==k) {
						isBreak = true;
						break;					
					}else {
						if(num+1<=100000 && !visited[num+1]) {
							set2.add(num+1);
							visited[num+1] = true;
						}
						if(num-1>=0 && !visited[num-1]) {
							set2.add(num-1);		
							visited[num-1] = true;							
						}
						if(num*2<=100000 && !visited[num*2]) {
							set2.add(num*2);							
							visited[num*2] = true;							
						}

					}
				} // end for
				if(isBreak)
					break;
				else {
					set1 = set2;
					set2 = new HashSet<Integer>();
				}// end if
			} // end while
			System.out.println(time);			
		}// end if

		
		// boolean의 크기의 경우 VM에 따라 달라짐. 실제론 1bit여도 되나 컴퓨터가 1bit씩 다루는게 속도가 좋지 않아 1byte로 잡기도 함.
//		boolean[] visited = new boolean[100001];
//		Queue<int[]> queue = new ArrayDeque<int[]>();
//		queue.add(new int[] {n, 0});
//		visited[n] = true;
//		while(true) {
//			int[] now = queue.poll();
//			if(now[0]==k) {
//				System.out.println(now[1]);
//				break;
//			}
//			if(now[0]+1<=100000 && !visited[now[0]+1])
//				queue.add(new int[] {now[0]+1, now[1]+1});
//			if(now[0]-1>=0 && !visited[now[0]-1])
//				queue.add(new int[] {now[0]-1, now[1]+1});
//			if(now[0]*2<=100000 && !visited[now[0]*2])
//				queue.add(new int[] {now[0]*2, now[1]+1});
//		}
	}
}
