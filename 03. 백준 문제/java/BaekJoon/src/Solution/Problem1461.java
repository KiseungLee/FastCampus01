package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem1461
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);				
		// Scanner sc = new Scanner(System.in);			
	    
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    int[] books = new int[n];
	    for (int i = 0; i < books.length; i++)
			books[i] = sc.nextInt();
	    sc.close();
	    
	    Arrays.sort(books);
	    
	    int length = 0;
	    // 음수 부분 카운트
	    for (int i = 0; i < books.length && books[i] < 0; i+=m)
			length += -books[i];
	    // 양수 부분 카운트
	    for (int i = books.length-1; i>=0 && books[i] > 0; i-=m) 
			length += books[i];

	    
	    // 왔다 갔다
	    length *= 2;
	    
	    // 제일 먼 곳은 한번만
	    length -= Math.max(-books[0], books[books.length-1]);
	    
	    System.out.println(length);
	}
}
