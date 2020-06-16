package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Problem1781
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);				
		// Scanner sc = new Scanner(System.in);					
	    
	    int n = sc.nextInt();
	    int[][] homeworks = new int[n][2];
	    for (int i = 0; i < homeworks.length; i++)
			homeworks[i] = new int[]{ sc.nextInt(), sc.nextInt() };
	    
	    // 데드라인 순으로 정렬
	    Arrays.sort(homeworks, new Comparator<int[]>()
		{
			@Override
			public int compare(int[] o1, int[] o2)
			{
				return o1[0] - o2[0];
			}
		});

	    Queue<Integer> queue = new PriorityQueue<Integer>();
	    
	    for(int[] homework : homeworks) {
	    	if(queue.size()<homework[0])
	    		queue.add(homework[1]);
	    	// 데드라인보다 큐에 있는게 많거나 같은데, 큐에 있는 가장 작은 컵라면보다 지금 컵라면이 많으면 교체
	    	else if(queue.size()>=homework[0] && queue.peek()<homework[1]) {
	    		queue.poll();
	    		queue.add(homework[1]);
	    	}
	    }
	    
	    // 큐에서 빼서 컵라면 합계 구하기
	    int result = 0;
	    while(!queue.isEmpty())
	    	result += queue.poll();
	    
	    System.out.println(result);
	}
}
