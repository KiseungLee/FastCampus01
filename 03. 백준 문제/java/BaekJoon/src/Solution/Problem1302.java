package Solution;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1302
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = Integer.valueOf(sc.nextLine());
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < n; i++)
		{
			String book = sc.nextLine();
			if (!map.containsKey(book))
				map.put(book, 1);
			else
				map.put(book, map.get(book)+1);
		}
		
		int max_count = 0;
		String max_book = "";
		for(String key : map.keySet()) {
			if (max_count < map.get(key)) {
				max_count = map.get(key);
				max_book = key;
			}else if(max_count == map.get(key)) {
				if (max_book.compareTo(key)>0)
					max_book = key;
			}
		}
		
		System.out.println(max_book);
	}
}
