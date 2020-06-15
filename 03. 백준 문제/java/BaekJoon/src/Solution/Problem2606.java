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

public class Problem2606
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);				
		// Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    Map<Integer, List<Integer>> edges = new HashMap<>();
	    for (int i = 0; i < n; i++)
			edges.put(i+1, new ArrayList<>());
	    
	    for (int i = 0; i < m; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			edges.get(a).add(b);
			edges.get(b).add(a);
		}
	    sc.close();
	    
	    int count = 0;
	    boolean[] visited = new boolean[n+1];
	    visited[0] = true;
	    Queue<Integer> visitQueue = new ArrayDeque<Integer>();
	    visitQueue.add(1);
	    
	    while (!visitQueue.isEmpty()) {
	    	int now = visitQueue.poll();
	    	if(!visited[now]) {
	    		visited[now] = true;
	    		count += 1;
		    	for(int next : edges.get(now)) {
		    		if(!visited[next]) {
		    			visitQueue.add(next);
		    		}
		    	}	    		
	    	}
	    } // end while
	    
	    System.out.println(count-1);
	} // end main
}
