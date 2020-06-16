package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem2212
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);				
		// Scanner sc = new Scanner(System.in);		
	    
	    int n = sc.nextInt();
	    int k = sc.nextInt();
	    
	    int[] sensors = new int[n];
	    for (int i = 0; i < sensors.length; i++)
	    	sensors[i] = sc.nextInt();
	    
	    Arrays.sort(sensors);
	    
	    
	    int[] gaps = new int[n-1];
	    for (int i = 0; i < gaps.length; i++)
			gaps[i] = sensors[i+1] - sensors[i]; 
	    
	    Arrays.sort(gaps);
	    
	    // 정렬한 gaps중 큰거 k-1개 빼고 더함
	    int result = 0;
	    for (int i = 0; i < gaps.length-(k-1); i++)
			result += gaps[i];	    		
	    
	    System.out.println(result);
	}
}
