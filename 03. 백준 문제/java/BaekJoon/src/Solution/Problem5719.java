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

// 20%에서 계속 런타임 에러 나는데 뭔지 모르겠다. 재귀 스택 초과 말고는 딱히 안보이는데
public class Problem5719
{
	static Scanner sc;
	static Map<Integer, Node4> map;
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    sc = new Scanner(file);
		// Scanner sc = new Scanner(System.in);		
	    
	    while (true)
		{
//	    	System.out.println("------------------------");
	    	// 입력
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    
		    // 종료일 경우 종료
		    if(n==0 && m==0)
		    	break;
		    
		    // 아닐경우 문제 풀이
		    almostShortPath(n, m);
		}
	    
	    sc.close();
	} // end main
	
	private static void almostShortPath(int n, int m)
	{
	    // 노드 맵 초기화
	    map = new HashMap<Integer, Node4>();
	    for (int i = 0; i < n; i++)
	    	map.put(i, new Node4(i));
	    
		// s:시작점, d:도착점
		int s = sc.nextInt();
		int d = sc.nextInt();
		
		for (int i = 0; i < m; i++)
		{
			// u에서 v로 가는 도로의 길이가 p, 방향그래프
			int u = sc.nextInt();
			int v = sc.nextInt();
			int p = sc.nextInt();
			
			map.get(u).nexts.put(v, p);
		} // end for
		
		
		// 1. 다익스트라 알고리즘 - 최단 경로 길이 추출 (최단 경로 산정할때 노드의 prev도 기록하기)
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
		
		// 애초에 최단 거리가 없을 경우도 있나?
		if(map.get(d).cost == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}

		
		// 2. 역추적해서 최단 경로 간선 제거
		// deleteEdges(s, d);
		
		// 2. 런타임에러가 재귀 스택 초과인 것 같아 재귀 안쓰고 역추적, 간선 삭제 구현
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
		
		// 3. 노드들 costs, prevs 초기화
		for(int key : map.keySet()) {
			map.get(key).cost = Integer.MAX_VALUE;
			map.get(key).prevs.clear();
		}
		
		// 3. 다시 다익스트라 알고리즘 - 거의 최단 경로 길이 추출
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
		
		// 결과 출력
		if(map.get(d).cost == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(map.get(d).cost);
		
	} // end almostShortPath

	// d번째 노드의 prevs에서 d로 오는 간선을 삭제하라.
	private static void deleteEdges(int s, int d)
	{
		if(s==d)
			return;
		
		for(int prev : map.get(d).prevs) {
			// prev에서 d로 가는 간선을 지우고
			if(map.get(prev).nexts.containsKey(d))
				map.get(prev).nexts.remove(d);
			// 재귀
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