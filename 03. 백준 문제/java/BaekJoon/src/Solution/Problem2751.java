package Solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem2751
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = Integer.valueOf(br.readLine());
		}
		br.close();
		
	    sort(arr);
	    
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    for (int i : arr)
		{
	    	bw.write(String.valueOf(i)+"\n");
		}
	    bw.flush();
	    bw.close();
	}
	
	public static void sort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
	}
	
	public static void mergeSort(int[] arr, int start, int end){
		if (start>end) {
			int mid = (start+end)/2;
			
			// divied
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			
			// conquer
			int left = start;
			int right = mid+1;
			
		}
	}
}
