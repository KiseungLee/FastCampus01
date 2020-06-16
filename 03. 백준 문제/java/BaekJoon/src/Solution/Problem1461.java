package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem1461
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. ���� ����\\java\\BaekJoon\\src\\Solution\\input.txt");
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
	    // ���� �κ� ī��Ʈ
	    for (int i = 0; i < books.length && books[i] < 0; i+=m)
			length += -books[i];
	    // ��� �κ� ī��Ʈ
	    for (int i = books.length-1; i>=0 && books[i] > 0; i-=m) 
			length += books[i];

	    
	    // �Դ� ����
	    length *= 2;
	    
	    // ���� �� ���� �ѹ���
	    length -= Math.max(-books[0], books[books.length-1]);
	    
	    System.out.println(length);
	}
}
