package Solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem10989
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
	    
	    int n = Integer.valueOf(br.readLine());
	    int[] arr = new int[10000];
	    
	    for (int i = 0; i < n; i++)
		{
			arr[Integer.valueOf(br.readLine())-1] += 1;
		}
	    
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i]; j++)
			{
				bw.write(String.valueOf(i+1));
				bw.write("\n");
			}
		}
	    bw.flush();
	}
}
