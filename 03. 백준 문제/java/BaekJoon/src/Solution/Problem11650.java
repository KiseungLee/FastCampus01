package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem11650
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);		
	    
	    int n = sc.nextInt();
	    
	    int[][] arr = new int[n][2];
	    
	    for (int i = 0; i < n; i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[i] = new int[] {x, y};
		}
	    
	    Arrays.sort(arr, new Comparator<int[]>()
		{
			@Override
			public int compare(int[] o1, int[] o2)
			{
				if (o1[0] > o2[0])
					return 1;
				else if (o1[0]==o2[0])
					return o1[1] - o2[1];
				else
					return -1;
			}
		});
	    
	    for (int[] is : arr)
		{
			System.out.println(is[0] + " " + is[1]);
		}
	}
}
