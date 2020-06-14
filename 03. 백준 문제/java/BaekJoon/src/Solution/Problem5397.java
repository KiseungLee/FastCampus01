package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Problem5397 {
	public static void main(String[] args) throws FileNotFoundException {
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);
		
		int test_case = sc.nextInt();
		
		for (int i = 0; i < test_case ; i++) {
			// 입력
			String input = sc.next();
			// 왼쪽 스택
			Stack<Character> stackLeft = new Stack<Character>();
			// 오른쪽 스택
			Stack<Character> stackRight = new Stack<Character>();
			
			for (Character c : input.toCharArray()) {
				if(c=='<') 
				{
					if(!stackLeft.isEmpty())
						stackRight.add(stackLeft.pop());
				}else if(c=='>') 
				{
					if(!stackRight.isEmpty()) 
						stackLeft.add(stackRight.pop());
				}else if(c=='-') {
					if(!stackLeft.isEmpty())
						stackLeft.pop();
				}
				else 
				{
					stackLeft.add(c);
				}
			}
			
			// 결과 출력
			char[] result = new char[stackLeft.size() + stackRight.size()];
			// 왼쪽 스택
			int resultIdx = stackLeft.size()-1;
			while(!stackLeft.isEmpty())
				result[resultIdx--] = stackLeft.pop();
			// 오른쪽 스택
			resultIdx = result.length - stackRight.size();
			while(!stackRight.isEmpty())
				result[resultIdx++] = stackRight.pop();
			
			// 결과 출력
			System.out.println(String.valueOf(result));
		}
	}
}
