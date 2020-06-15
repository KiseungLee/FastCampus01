package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Problem1012
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);				
		// Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for (int i = 0; i < t; i++)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();
			boolean[][] cabbages = new boolean[m][n]; // 배추밭
			boolean[][] visited = new boolean[m][n];  // 탐색시 쓸 방문 했는지 기록할 배열
			// 배추 입력
			for (int j = 0; j < k; j++)
			{
				int r = sc.nextInt();
				int c = sc.nextInt();
				cabbages[r][c] = true;
			} // end for j
			
	    	int count = 0; // 지렁이 카운트 -> bfs 돌 때마다 +1
	    	Queue<int[]> visitQueue;
	    	
	    	for (int r = 0; r < m; r++)
			{
	    		for (int c = 0; c < n; c++)
				{
	    			// r, c 가 배추이고, 방문 안했을 때 -> BFS 돌림
					if(cabbages[r][c] && !visited[r][c]) {
						// BFS run
						count += 1;
						visitQueue = new ArrayDeque<int[]>();
						visitQueue.add(new int[] {r, c});
						while(!visitQueue.isEmpty()) {
							// 하나 뽑아서 방문 안했으면 방문
							int[] now = visitQueue.poll();
							if (!visited[now[0]][now[1]]) {
								visited[now[0]][now[1]] = true;
								// 왼쪽 인덱스 안벗어나고, 배추이고 방문 안했을 때
								if(now[1]-1>=0 && cabbages[now[0]][now[1]-1] && !visited[now[0]][now[1]-1]) 
									visitQueue.add(new int[] {now[0], now[1]-1});
								
								// 오른쪽
								if(now[1]+1<n && cabbages[now[0]][now[1]+1] && !visited[now[0]][now[1]+1]) 
									visitQueue.add(new int[] {now[0], now[1]+1});
								
								// 위
								if(now[0]-1>=0 && cabbages[now[0]-1][now[1]] && !visited[now[0]-1][now[1]]) 
									visitQueue.add(new int[] {now[0]-1, now[1]});								
								
								// 아래
								if(now[0]+1<m && cabbages[now[0]+1][now[1]] && !visited[now[0]+1][now[1]]) 
									visitQueue.add(new int[] {now[0]+1, now[1]});								
								
							} // end if
						} // end while visitQueue
					} // end if
				} // end for c
			} // end for r
	    	
			// 결과 출력
			System.out.println(count);
		} // end for i
	} // end main
}
