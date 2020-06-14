package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Problem1427
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);		
	    
	    char[] arr = sc.next().toCharArray();
	    
	    Arrays.sort(arr);
	    
	    for (int i = arr.length-1; i >=0 ; i--)
		{
			System.out.print(arr[i]);
		}
	}
}
