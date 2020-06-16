package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

// 20%���� ��� ��Ÿ�� ���� ���µ� ���� �𸣰ڴ�. ��� ���� �ʰ� ����� ���� �Ⱥ��̴µ�
public class Problem5719
{
	static Scanner sc;
	static Map<Integer, Node4> map;
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. ���� ����\\java\\BaekJoon\\src\\Solution\\input.txt");
	    sc = new Scanner(file);
		// Scanner sc = new Scanner(System.in);		
	    
	    while (true)
		{
//	    	System.out.println("------------------------");
	    	// �Է�
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    
		    // ������ ��� ����
		    if(n==0 && m==0)
		    	break;
		    
		    // �ƴҰ�� ���� Ǯ��
		    almostShortPath(n, m);
		}
	    
	    sc.close();
	} // end main
	
	private static void almostShortPath(int n, int m)
	{
	    // ��� �� �ʱ�ȭ
	    map = new HashMap<Integer, Node4>();
	    for (int i = 0; i < n; i++)
	    	map.put(i, new Node4(i));
	    
		// s:������, d:������
		int s = sc.nextInt();
		int d = sc.nextInt();
		
		for (int i = 0; i < m; i++)
		{
			// u���� v�� ���� ������ ���̰� p, ����׷���
			int u = sc.nextInt();
			int v = sc.nextInt();
			int p = sc.nextInt();
			
			map.get(u).nexts.put(v, p);
		} // end for
		
		
		// 1. ���ͽ�Ʈ�� �˰��� - �ִ� ��� ���� ���� (�ִ� ��� �����Ҷ� ����� prev�� ����ϱ�)
		Queue<Node4> queue = new ArrayDeque<Node4>();
		map.get(s).cost = 0;
		queue.add(map.get(s));
		while(!queue.isEmpty()) {
			Node4 now = queue.poll();
			for(int nextIdx : now.nexts.keySet()) {
				
				Node4 nextNode = map.get(nextIdx);
				
				if(nextNode.cost > now.cost+now.nexts.get(nextIdx)) {
					nextNode.cost = now.cost+now.nexts.get(nextIdx);
					nextNode.prevs.clear();
					nextNode.prevs.add(now.index);
					queue.add(nextNode);
				}else if(nextNode.cost == now.cost + now.nexts.get(nextIdx)) {
					nextNode.prevs.add(now.index);
					queue.add(nextNode);
				} // end if
			} // end for
		} // end while
		
		// ���ʿ� �ִ� �Ÿ��� ���� ��쵵 �ֳ�?
		if(map.get(d).cost == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}

		
		// 2. �������ؼ� �ִ� ��� ���� ����
		// deleteEdges(s, d);
		
		// 2. ��Ÿ�ӿ����� ��� ���� �ʰ��� �� ���� ��� �Ⱦ��� ������, ���� ���� ����
		Queue<Integer> deleteQueue = new ArrayDeque<>();
		deleteQueue.add(d);
		while(!deleteQueue.isEmpty()) {
			int now = deleteQueue.poll();
			for(int prev : map.get(now).prevs) {
				map.get(prev).nexts.remove(now);
				deleteQueue.add(prev);
			}
			map.get(now).prevs.clear();
		}
		
		// 3. ���� costs, prevs �ʱ�ȭ
		for(int key : map.keySet()) {
			map.get(key).cost = Integer.MAX_VALUE;
			map.get(key).prevs.clear();
		}
		
		// 3. �ٽ� ���ͽ�Ʈ�� �˰��� - ���� �ִ� ��� ���� ����
		queue.clear();
		map.get(s).cost = 0;
		queue.add(map.get(s));
		while(!queue.isEmpty()) {
			
			Node4 now = queue.poll();
			
			for(int nextIdx : now.nexts.keySet()) {
				Node4 nextNode = map.get(nextIdx);
				if(nextNode.cost > now.cost+now.nexts.get(nextIdx)) {
					nextNode.cost = now.cost+now.nexts.get(nextIdx);
					nextNode.prevs.clear();
					nextNode.prevs.add(now.index);
					queue.add(nextNode);
				}else if(nextNode.cost == now.cost + now.nexts.get(nextIdx)) {
					nextNode.prevs.add(now.index);
					queue.add(nextNode);
				} // end if
			} // end for 
		}// end while
		
		// ��� ���
		if(map.get(d).cost == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(map.get(d).cost);
		
	} // end almostShortPath

	// d��° ����� prevs���� d�� ���� ������ �����϶�.
	private static void deleteEdges(int s, int d)
	{
		if(s==d)
			return;
		
		for(int prev : map.get(d).prevs) {
			// prev���� d�� ���� ������ �����
			if(map.get(prev).nexts.containsKey(d))
				map.get(prev).nexts.remove(d);
			// ���
			deleteEdges(s, prev);
		}
	}
}

class Node4{
	int index;
	int cost;
	Map<Integer, Integer> nexts;
	List<Integer> prevs;
	public Node4(int index) {
		this.index = index;
		this.cost = Integer.MAX_VALUE;
		this.nexts = new HashMap<>();
		this.prevs = new ArrayList<Integer>();
	}
}