package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem11004
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		String[] temp2 = temp.split(" ");
		int n = Integer.valueOf(temp2[0]);
		int k = Integer.valueOf(temp2[1]);
		
		String[] arr = (br.readLine()).split(" ");
		
		br.close();
		
	    Arrays.sort(arr);
	    System.out.println(arr[k-1]);
	}
}
