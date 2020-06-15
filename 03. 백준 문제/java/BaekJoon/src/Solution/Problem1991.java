package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1991
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);			
	    
	    int n = Integer.valueOf(sc.nextLine());
	    
	    Map<Character, Node> map = new HashMap<Character, Node>();
	    
	    for (int i = 0; i < n; i++)
		{
	    	String line = sc.nextLine();
			map.put(line.charAt(0), new Node(line.charAt(0), line.charAt(2), line.charAt(4)));
		}
	    
	    printPreorder(map, 'A');
	    System.out.println();
	    
	    printInorder(map, 'A');
	    System.out.println();
	    
	    printPostorder(map, 'A');
	}

	private static void printPreorder(Map<Character, Node> map, char c)
	{
		System.out.print(c);
		
		if(map.get(c).left!='.')
			printPreorder(map, map.get(c).left);
		
		if(map.get(c).right!='.')
			printPreorder(map, map.get(c).right);
	}

	private static void printInorder(Map<Character, Node> map, char c)
	{
		if(map.get(c).left!='.')
			printInorder(map, map.get(c).left);		
		
		System.out.print(c);
		
		if(map.get(c).right!='.')
			printInorder(map, map.get(c).right);
	}
	
	private static void printPostorder(Map<Character, Node> map, char c)
	{
		if(map.get(c).left!='.')
			printPostorder(map, map.get(c).left);
		
		if(map.get(c).right!='.')
			printPostorder(map, map.get(c).right);
		
		System.out.print(c);
	}
}

class Node
{
	char name;
	char left;
	char right;
	
	public Node(char name, char left, char right) {
		this.name = name;
		this.left = left;
		this.right = right;
	}
	
}
