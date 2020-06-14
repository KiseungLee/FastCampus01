package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem2750
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);
	    
	    int n = sc.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++)
		{
			arr[i] = sc.nextInt();
		}
	    
	    Arrays.sort(arr);
	    
	    for (int i : arr)
		{
			System.out.println(i);
		}
	}
}
