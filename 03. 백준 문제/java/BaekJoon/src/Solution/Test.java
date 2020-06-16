package Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test
{
	public static void main(String[] args)
	{
//		Queue<int[]> temp = new PriorityQueue<int[]>(new Comparator<int[]>()
//		{
//
//			@Override
//			public int compare(int[] o1, int[] o2)
//			{
//				return o1[1] - o2[1];
//			}
//			
//		});
//		temp.add(new int[]{2, 3});
//		temp.add(new int[]{5, 1});
//		temp.add(new int[]{4, 7});
//		while (!temp.isEmpty())
//			System.out.println(Arrays.toString(temp.poll()));
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		map.put(5, 5);
		map.remove(2);
		map.clear();
		System.out.println();
	}
}
