package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Problem1236
{
	public static void main(String[] args)
	{
//	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
//	    Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		String[] nm = sc.nextLine().split(" ");
		int n = Integer.valueOf(nm[0]);
		int m = Integer.valueOf(nm[1]);
		
		char[][] castle = new char[n][m];
		
		// 입력
		for (int i = 0; i < n; i++)
		{
			String row = sc.nextLine().trim();
			for (int j = 0; j < row.length(); j++)
			{
				castle[i][j] = row.charAt(j);
			}
		}
		
		for (int i = 0; i < castle.length; i++)
		{
			System.out.println(Arrays.toString(castle[i]));
		}
		
		int[] rows = new int[n];
		int[] cols = new int[m];
		
		for (int i = 0; i < rows.length; i++)
		{
			for (int j = 0; j < cols.length; j++)
			{
				if(castle[i][j]=='X') {
					rows[i] += 1;
					cols[j] += 1;
				}
			}
		}
		
		System.out.println(Arrays.toString(rows));
		System.out.println(Arrays.toString(cols));
		
		int x = 0;
		for(int r : rows) {
			if (r==0)
				x += 1;
		}
		
		int y = 0;
		for(int c : cols) {
			if (c==0)
				y+=1;
		}
		
		System.out.println( Math.max(x, y) );
	}
}
