package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Problem5397 {
	public static void main(String[] args) throws FileNotFoundException {
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. ���� ����\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);
		
		int test_case = sc.nextInt();
		
		for (int i = 0; i < test_case ; i++) {
			// �Է�
			String input = sc.next();
			// ���� ����
			Stack<Character> stackLeft = new Stack<Character>();
			// ������ ����
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
			
			// ��� ���
			char[] result = new char[stackLeft.size() + stackRight.size()];
			// ���� ����
			int resultIdx = stackLeft.size()-1;
			while(!stackLeft.isEmpty())
				result[resultIdx--] = stackLeft.pop();
			// ������ ����
			resultIdx = result.length - stackRight.size();
			while(!stackRight.isEmpty())
				result[resultIdx++] = stackRight.pop();
			
			// ��� ���
			System.out.println(String.valueOf(result));
		}
	}
}
