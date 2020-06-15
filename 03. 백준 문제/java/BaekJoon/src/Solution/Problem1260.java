package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Problem1260
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);				
		// Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		// 간선
		Map<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
		for (int i = 1; i <= n; i++)
		{
			edges.put(i, new ArrayList<>());
		}
		for (int i = 0; i < m; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			edges.get(a).add(b);
			edges.get(b).add(a);
		}
		sc.close();
		// 간선 정렬
		for(int key : edges.keySet()) {
			Collections.sort(edges.get(key));
		}

		// BFS
		boolean[] visited = new boolean[n+1];
		visited[0] = true;
		Queue<Integer> visitQueue = new ArrayDeque<Integer>();
		visited[v] = true;
		visitQueue.add(v);
		String bfs = String.valueOf(v)+" ";
		while (!visitQueue.isEmpty())
		{
			int now = visitQueue.poll();
			for(int next : edges.get(now)) {
				if(!visited[next]) {
					visitQueue.add(next);
					visited[next] = true;
					bfs += String.valueOf(next)+" ";
				} // end if
			} // end for
		} // end while
		
		// DFS
		visited = new boolean[n+1];
		visited[0] = true;
		Stack<Integer> visitStack = new Stack<Integer>();
		visitStack.push(v);
		String dfs = "";
		while(!visitStack.isEmpty()) {
			int now = visitStack.pop();
			if(!visited[now]) {
				visited[now] = true;
				dfs += String.valueOf(now) + " ";
				List<Integer> temp = edges.get(now);
				for (int i = temp.size()-1; i >=0 ; i--)
				{
					int next = temp.get(i);
					if(!visited[next]) {
						visitStack.push(next);
					} // end if
				}// end for
			}// end if
		} // end while
		
		// 출력
		System.out.println(dfs);
		System.out.println(bfs);
	}
}
