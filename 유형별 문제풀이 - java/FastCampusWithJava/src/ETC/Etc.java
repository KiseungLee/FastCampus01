package ETC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Etc {
	public static void main(String[] args) {
		String str = "z";
		
		int checker = 0;
		for(int i=0; i<str.length(); i++) {
			
			int val = str.charAt(i) - 'a';
			if((checker & (1<<val))>0) {
				System.out.println("false");
				break;
			}
			checker |= (1<<val);
			System.out.println(Integer.toBinaryString(checker));
		}
		System.out.println("true");
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
	}
	
	
}
