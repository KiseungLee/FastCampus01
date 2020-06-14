package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem4195
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);
	    
	    int test_case = Integer.valueOf(sc.nextLine());
	    for (int i = 0; i < test_case; i++)
		{
			int f = Integer.valueOf(sc.nextLine());
			// 부모 기록할 딕셔너리 (맵)
			Map<String, String> parentMap = new HashMap<>();
			// 네트워크 수 기록할 딕셔너리
			Map<String, Integer> networkMap = new HashMap<>();
			
			for (int j = 0; j < f; j++)
			{
				String[] friends = sc.nextLine().split(" ");
				if(!parentMap.containsKey(friends[0])) {
					parentMap.put(friends[0], friends[0]);
					networkMap.put(friends[0], 1);
				}
				if(!parentMap.containsKey(friends[1])) {
					parentMap.put(friends[1], friends[1]);
					networkMap.put(friends[1], 1);
				}
				
				String p1 = find(parentMap, friends[0]);
				String p2 = find(parentMap, friends[1]);
				
				union(networkMap, parentMap, p1, p2);
				
				System.out.println(networkMap.get(find(parentMap, friends[0])));
			}
		}
	    
	}

	private static void union(Map<String, Integer> networkMap, Map<String, String> parentMap, String p1, String p2)
	{
		if(p1!=p2) {
			if(p1.compareTo(p2)>=0) {
				parentMap.put(p2, p1);
				networkMap.put(p1, networkMap.get(p1)+networkMap.get(p2));
			}else {
				parentMap.put(p1, p2);
				networkMap.put(p2, networkMap.get(p2)+networkMap.get(p1));
			}			
		}
	}

	private static String find(Map<String, String> parentMap, String key)
	{
		while(key!=parentMap.get(key)) {
			key = parentMap.get(key);
		}
		return key;
	}
}
