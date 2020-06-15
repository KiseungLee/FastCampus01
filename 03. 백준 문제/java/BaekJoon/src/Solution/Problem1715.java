package Solution;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Problem1715
{
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner((System.in));
    	
    	int n = sc.nextInt();
    	
    	Queue<Integer> heap = new PriorityQueue<Integer>();
    	for (int i = 0; i < n; i++)
			heap.add(sc.nextInt());
    	
    	int count = 0;
    	while(heap.size()>1) {
    		int num1 = heap.poll();
    		int num2 = heap.poll();
    		count = count + num1 + num2;
    		heap.add(num1+num2);
    	}
    	
    	System.out.println(count);
    }
}
