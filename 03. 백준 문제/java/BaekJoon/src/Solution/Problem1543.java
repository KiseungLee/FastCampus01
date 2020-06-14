package Solution;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Problem1543
{
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(new InputStreamReader(System.in));
    	String doc = sc.nextLine();
    	String word = sc.nextLine();
    	int count = 0;
    	for (int i = 0; i < doc.length(); i++)
		{
    		int findIndex = doc.indexOf(word, i);
    		if (findIndex == -1) {
    			break;
    		}else {
    			count += 1;
    			i = findIndex + word.length() - 1;
    		}
		}
    	
    	System.out.println(count);
    }
}
