package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Problem1927
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);			
	    
		Queue<Integer> heap = new PriorityQueue<>();
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++)
		{
			int num = sc.nextInt();
			if(num>0)
				heap.add(num);
			else if (num==0) {
				if(!heap.isEmpty())
					System.out.println(heap.poll());
				else
					System.out.println(0);
			}
		}
	}
}
