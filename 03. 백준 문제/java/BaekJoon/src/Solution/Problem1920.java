package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem1920
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);
	    
	    int n = Integer.valueOf(sc.nextLine());
	    String[] str1 = sc.nextLine().split(" ");
	    Set<Integer> set = new HashSet<Integer>();
	    for (String str : str1)
		{
			set.add(Integer.valueOf(str));
		}
	    
	    int m = Integer.valueOf(sc.nextLine());
	    String[] str2 = sc.nextLine().split(" ");
	    for (String string : str2)
		{
			if(set.contains(Integer.valueOf(string)))
				System.out.println(1);
			else
				System.out.println(0);
		}
	    
	}
}
