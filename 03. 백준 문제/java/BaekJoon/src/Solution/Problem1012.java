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
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. ���� ����\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);				
		// Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for (int i = 0; i < t; i++)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();
			boolean[][] cabbages = new boolean[m][n]; // ���߹�
			boolean[][] visited = new boolean[m][n];  // Ž���� �� �湮 �ߴ��� ����� �迭
			// ���� �Է�
			for (int j = 0; j < k; j++)
			{
				int r = sc.nextInt();
				int c = sc.nextInt();
				cabbages[r][c] = true;
			} // end for j
			
	    	int count = 0; // ������ ī��Ʈ -> bfs �� ������ +1
	    	Queue<int[]> visitQueue;
	    	
	    	for (int r = 0; r < m; r++)
			{
	    		for (int c = 0; c < n; c++)
				{
	    			// r, c �� �����̰�, �湮 ������ �� -> BFS ����
					if(cabbages[r][c] && !visited[r][c]) {
						// BFS run
						count += 1;
						visitQueue = new ArrayDeque<int[]>();
						visitQueue.add(new int[] {r, c});
						while(!visitQueue.isEmpty()) {
							// �ϳ� �̾Ƽ� �湮 �������� �湮
							int[] now = visitQueue.poll();
							if (!visited[now[0]][now[1]]) {
								visited[now[0]][now[1]] = true;
								// ���� �ε��� �ȹ����, �����̰� �湮 ������ ��
								if(now[1]-1>=0 && cabbages[now[0]][now[1]-1] && !visited[now[0]][now[1]-1]) 
									visitQueue.add(new int[] {now[0], now[1]-1});
								
								// ������
								if(now[1]+1<n && cabbages[now[0]][now[1]+1] && !visited[now[0]][now[1]+1]) 
									visitQueue.add(new int[] {now[0], now[1]+1});
								
								// ��
								if(now[0]-1>=0 && cabbages[now[0]-1][now[1]] && !visited[now[0]-1][now[1]]) 
									visitQueue.add(new int[] {now[0]-1, now[1]});								
								
								// �Ʒ�
								if(now[0]+1<m && cabbages[now[0]+1][now[1]] && !visited[now[0]+1][now[1]]) 
									visitQueue.add(new int[] {now[0]+1, now[1]});								
								
							} // end if
						} // end while visitQueue
					} // end if
				} // end for c
			} // end for r
	    	
			// ��� ���
			System.out.println(count);
		} // end for i
	} // end main
}
