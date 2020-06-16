package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Problem10282
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);
		// Scanner sc = new Scanner(System.in);					
	    
	    int testCase = sc.nextInt();
	    for (int t = 0; t < testCase; t++)
		{
		    int n = sc.nextInt();
		    int d = sc.nextInt();
		    int c = sc.nextInt();
		    
		    // 인접행렬 초기화
		    Map<Integer, List<int[]>> adj = new HashMap<Integer, List<int[]>>();
		    for (int i = 0; i < n ; i++)
		    	adj.put(i+1, new ArrayList<>());
		    
		    for (int i = 0; i < d; i++)
			{
		    	// a가 b를 의존 == b 감염되면 s초 후 a 감염
				int a = sc.nextInt();
				int b = sc.nextInt();
				int s = sc.nextInt();
				// 인접 행렬 입력
				adj.get(b).add(new int[] {a, s});
			} // end for i 
		    
		    // 감염 시간을 기록할 비용 배열 및 방문 기록 배열(Integer.MAX_VALUE이면 방문 안한걸로 판별)
		    int[] infectTimes = new int[n+1];
		    Arrays.fill(infectTimes, Integer.MAX_VALUE);
		    infectTimes[c] = 0; // 처음 해킹단한 곳 
		    
		    // BFS 
		    Queue<Integer> visitQueue = new ArrayDeque<Integer>();
		    visitQueue.add(c);
		    while(!visitQueue.isEmpty()) {
		    	int now = visitQueue.poll();
		    	for(int[] next : adj.get(now)) {
		    		if(infectTimes[next[0]] > infectTimes[now]+next[1]) {
		    			infectTimes[next[0]] = infectTimes[now]+next[1];
		    			visitQueue.add(next[0]);
		    		}
		    	}
		    } // end while visitQueue
		    
		    int count = 0;
		    int result = 0;
		    for(int num : infectTimes) {
		    	if(num!=Integer.MAX_VALUE) {
		    		count += 1;
		    		result = Math.max(result, num);
		    	}
		    }
		    // 결과 출력
		    System.out.println(count + " " + result);
		} // end for t testCase
	} // end main
}
