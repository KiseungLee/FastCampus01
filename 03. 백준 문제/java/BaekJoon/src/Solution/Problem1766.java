package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem1766
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);		
	    
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    // 진입 차수 기록
	    int[] indegree = new int[n];
	    // 연결된 문제들
	    Map<Integer, List<Integer>> map = new HashMap<>();
	    // 방문 했는 지 기록
	    boolean[] visited = new boolean[n];
	    
	    // 입력
	    for (int i = 0; i < m; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			indegree[b-1] += 1;
			if(!map.containsKey(a)) {
				map.put(a, new ArrayList<>());
			}
			map.get(a).add(b);
		}
	    sc.close();
	    
	    int count = 0;

	    while(count<n) {
		    // 진입 차수 돌면서 진입 차수가 0인것 부터 풀기
		    for (int i = 0; i < indegree.length; i++)
			{
		    	// 아직 방문하지 않았고 진입 차수가 0인 경우
				if(!visited[i] && indegree[i]==0) {
					// 해당 문제 풀고
					visited[i]=true;
					count += 1;					
					System.out.print(i+1+" ");
					// 해당 문제에 연결된 문제들 진입차수 낮춤
					if(map.containsKey(i+1)) {
						for(int temp : map.get(i+1)) 
							indegree[temp-1] -= 1;						
					}
					// for문 나감
					break;
				}
			}	    	
	    }

	}
}
