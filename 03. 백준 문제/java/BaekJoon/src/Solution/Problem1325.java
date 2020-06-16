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

public class Problem1325
{
	static boolean[] visited2;
	static int dfsCount;
	public static void main(String[] args) throws FileNotFoundException
	{
		// �Է�
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. ���� ����\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);				
		// Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    
	    // ��ǻ�͵��� �ŷ� ���踦 ���� ��
	    Map<Integer, List<Integer>> edges = new HashMap<>();
	    for (int i = 0; i < n; i++)
	    	edges.put(i+1, new ArrayList<>());
	    
	    // �ŷ� ���� �Է�
	    for (int i = 0; i < m; i++)
		{
	    	// a�� b�� �ŷ� -> b���� a�� �� �� ����
			int a = sc.nextInt();
			int b = sc.nextInt();
			edges.get(b).add(a);
		}
	    
	    // 1�� ��ǻ�ͺ��� n�� ��ǻ�ͱ��� ��ŷ�ϸ� ������ų �� �ִ� ��ǻ���� ������ ����
	    // ���ϸ鼭 �ִ� ��ŷ ������ ����
	    int[] result = new int[n];
	    int max_hacking = 0;
	    for (int i = 0; i < result.length; i++)
		{
	    	visited2 = new boolean[n+1];
	    	dfsCount = 0;
	    	dfs(edges, i+1);
	    	result[i] = dfsCount;
	    	max_hacking = Math.max(max_hacking, dfsCount);
//	    	int hacking = bfs(edges, i+1);
//			result[i] = hacking;
//			max_hacking = Math.max(max_hacking, hacking);
		}
	    // ��� ���
	    for (int i = 0; i < result.length; i++)
		{
			if(result[i]==max_hacking)
				System.out.print((i+1)+" ");
		}
	}

	private static void dfs(Map<Integer, List<Integer>> edges, int i)
	{
		if(!visited2[i]) {
			visited2[i] = true;
			dfsCount += 1;
			for(int next : edges.get(i)) {
				if(!visited2[next])
					dfs(edges, next);
			}
		}
	}

	private static int bfs(Map<Integer, List<Integer>> edges, int i)
	{
		boolean[] visited = new boolean[edges.size()+1];
		visited[0] = true;
		Queue<Integer> visitQueue = new ArrayDeque<Integer>();
		visitQueue.add(i);

		int count = 0;
		while(!visitQueue.isEmpty()) {
			int now = visitQueue.poll();
			if(!visited[now]) {
				count += 1;
				visited[now] = true;
				for(int next : edges.get(now))
					visitQueue.add(next);
			}
		}
		
		return count;
	}
}
