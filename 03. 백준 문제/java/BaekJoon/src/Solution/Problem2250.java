package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2250
{
	static int arrIdx = 0;
	static int maxDepth = 0;
	
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);					
	    
	    int n = sc.nextInt();
	    Map<Integer, Node2> map = new HashMap<>();
	    boolean[] isNotRoot = new boolean[n];
	    for (int i = 0; i < n; i++)
		{
			int name = sc.nextInt();
			int left = sc.nextInt();
			int right = sc.nextInt();
			if(left != -1)
				isNotRoot[left-1] = true;
			if(right != -1)
				isNotRoot[right-1] = true;
			map.put(name, new Node2(name, left, right));
		}
	    
	    // 중위 순회 순서순으로 [name, depth]를 담을 배열
	    int[][] arr = new int[n][2];
	    
	    // 루트 찾기
	    int root = 0;
	    for (int i = 0; i < isNotRoot.length; i++)
		{
			if(!isNotRoot[i]) {
				root = i+1;
				break;
			}
		}
	    
	    // 중위 순회
	    inorder(map, arr, root, 0);
	    
	    int[] maxPerDepth = new int[maxDepth+1];
	    int[] minPerDepth = new int[maxDepth+1];
	    Arrays.fill(minPerDepth, n);
	    
	    for (int i = 0; i < arr.length; i++)
		{
	    	int[] node = arr[i];
	    	maxPerDepth[node[1]] = Math.max(maxPerDepth[node[1]], i);
	    	minPerDepth[node[1]] = Math.min(minPerDepth[node[1]], i);			
		}
	    
	    int maxWidth = 0;
	    int maxWidthDepth = 0;
	    for (int i = 0; i < minPerDepth.length; i++)
		{
	    	int widthNow = maxPerDepth[i] - minPerDepth[i] + 1;
	    	if(widthNow > maxWidth) {
	    		maxWidth = widthNow;
	    		maxWidthDepth  = i;
	    	} 
		}
	    
	    System.out.println(maxWidthDepth+1 + " " +maxWidth);
	}

	private static void inorder(Map<Integer, Node2> map, int[][] arr, int name, int depth)
	{
		if(map.get(name).left!=-1)
			inorder(map, arr, map.get(name).left, depth+1);
		
		arr[arrIdx++] = new int[] {name, depth};
		maxDepth = Math.max(maxDepth, depth);
		
		if(map.get(name).right!=-1)
			inorder(map, arr, map.get(name).right, depth+1);		
	}
}

class Node2{
	int name;
	int left;
	int right;
	public Node2(int name, int left, int right) {
		this.name = name;
		this.left = left;
		this.right = right;
	}
}