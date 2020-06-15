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
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. ���� ����\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);		
	    
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    // ���� ���� ���
	    int[] indegree = new int[n];
	    // ����� ������
	    Map<Integer, List<Integer>> map = new HashMap<>();
	    // �湮 �ߴ� �� ���
	    boolean[] visited = new boolean[n];
	    
	    // �Է�
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
		    // ���� ���� ���鼭 ���� ������ 0�ΰ� ���� Ǯ��
		    for (int i = 0; i < indegree.length; i++)
			{
		    	// ���� �湮���� �ʾҰ� ���� ������ 0�� ���
				if(!visited[i] && indegree[i]==0) {
					// �ش� ���� Ǯ��
					visited[i]=true;
					count += 1;					
					System.out.print(i+1+" ");
					// �ش� ������ ����� ������ �������� ����
					if(map.containsKey(i+1)) {
						for(int temp : map.get(i+1)) 
							indegree[temp-1] -= 1;						
					}
					// for�� ����
					break;
				}
			}	    	
	    }

	}
}
