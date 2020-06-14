package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Problem1939
{
	static int n;
	public static void main(String[] args)
	{
//	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
//	    Scanner sc = new Scanner(file);
	    Scanner sc = new Scanner(new InputStreamReader(System.in));
	    
	    n = sc.nextInt();
	    int m = sc.nextInt();
	    
	    // 갈 수 있는 길들
	    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
	    for (int i = 0; i < n; i++)
			map.put(i+1, new HashMap<Integer, Integer>());
	    
	    for (int i = 0; i < m; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			// 이미 a - b 경로가 있는 경우라면 무게 제한 큰 걸로 교체
			if (map.get(a).containsKey(b)) {
				if (map.get(a).get(b) < c) {
					map.get(a).put(b, c);
					map.get(b).put(a, c);
				}
			}else {
				map.get(a).put(b, c);
				map.get(b).put(a, c);
			}
		}
	    
	    int start = sc.nextInt();
	    int end = sc.nextInt();
	    
	    int left = 0;
	    int right = 1000000000;
	    int result = 0;
	    while(left<=right) {
	    	int mid = (left+right)/2;
	    	result = mid;
	    	if(isPossible(map, start, end, mid))
	    		left = mid+1;	    			    		
	    	else
	    		right = mid-1;

	    }
	    
	    System.out.println(right);
	}

	private static boolean isPossible(Map<Integer, Map<Integer, Integer>> map, int start, int end, int weight)
	{
		// boolean의 기본값은 false, Boolean의 기본값은 null
		boolean[] visited = new boolean[n];
		Queue<Integer> visitQueue = new ArrayDeque<Integer>();
		visited[start-1] = true;
		visitQueue.add(start);
		
		while(!visitQueue.isEmpty()) {
			int now = visitQueue.poll();
			// end에 도달했으면 true 리턴
			if (now==end) {
				return true;				
			}
			
			for(int next : map.get(now).keySet()) {
				// 방문 안했고 무게가 무게제한보다 낮거나 같을 때 방문 예정 큐에 넣음
				if(!visited[next-1] && map.get(now).get(next)>=weight) {
					visitQueue.add(next);
					visited[next-1] = true;
				}
			}
		}
		
		// BFS 다 돌 때까지 end를 못만났으면 false 리턴
		return false;
	}
}
