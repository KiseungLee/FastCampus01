package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Problem1774
{
	static Map<Integer, Integer> parent;
	static double result;
	static int[][] nodes;
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);
		// Scanner sc = new Scanner(System.in);
	    
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    
	    parent = new HashMap<Integer, Integer>();
	    nodes = new int[n][2];
	    
	    for (int i = 0; i < n; i++)
		{
	    	// i번째 좌표 : x, y
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			parent.put(i, i);
			nodes[i] = new int[] {x, y};
		}
	    
	    for (int i = 0; i < m; i++)
		{
	    	// a번째 좌표와 b번째 좌표는 연결되어 있음
			int a = sc.nextInt();
			int b = sc.nextInt();
			a-=1;
			b-=1;
			
			a = find(a);
			b = find(b);
			
			// 기존 연결된 통로는 결과에 안들어감
			union(a, b, 0);
		}
	    sc.close();
	    
	    // 점들 간 거리 구하기
	    Queue<Node3> queue = new PriorityQueue<Node3>(new Comparator<Node3>()
		{
			@Override
			public int compare(Node3 o1, Node3 o2)
			{
				if (o1.distance>o2.distance)
					return 1;
				else if (o1.distance==o2.distance)
					return 0;
				else
					return -1;
			}
		});
	    
	    // 좌표간 거리 구하고 가장 작은 거리부터 우선순위 큐에 넣음
	    for (int i = 0; i < n-1; i++)
		{
			for (int j = i+1; j < n; j++)
			{
				queue.add(new Node3(i, j, distance(nodes[i], nodes[j])));
			} // end for j
		} // end for i
	    
	    
	    while(!queue.isEmpty()) {
	    	Node3 now = queue.poll();
	    	union(find(now.from), find(now.to), now.distance);
	    } // end while queue

	    System.out.printf("%.2f",result);
	} // end main
	
	static void union(int x, int y, double d) {
		if(x!=y) {
			// System.out.println("merge : "+x+" , "+y+" distance : "+d  );
			result += d;
			if(x>=y)
				parent.put(y, x);
			else
				parent.put(x, y);
		}
	}
	
	static int find(int x) {
		while (x!=parent.get(x)) {
			x = parent.get(x);
		}
		return x;
	}
	
	static double distance(int[] p1, int[] p2) {
		return (double) Math.sqrt( Math.pow((p1[0]-p2[0]),2) + Math.pow((p1[1]-p2[1]), 2) );
	}
}

class Node3{
	int from;
	int to;
	double distance;
	public Node3(int from, int to, double distance) {
		this.from = from;
		this.to = to;
		this.distance = distance;
	}
}