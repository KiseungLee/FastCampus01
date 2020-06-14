package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Problem1874 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. ���� ����\\java\\BaekJoon\\src\\Solution\\input.txt");
		Scanner sc = new Scanner(file);
		
		// n
		int n = sc.nextInt();
		// ������ �ٷ� stack
		Stack<Integer> stack = new Stack<>();
		// ���ÿ� �� ���� ���
		int num = 0;
		// �߰��� �������
		boolean isBreak = false;
		// ��� ���� ����Ʈ
		List<Character> list = new ArrayList<Character>();
		
		for (int i = 0; i < n; i++) {
			// �Է�
			int now = sc.nextInt();
			
			// num�� now�� �� ������ �ֱ�
			while(num<now) {
				stack.push(++num);
				list.add('+');
			}
			
			// stack�� �� ���� ���� now�� pop, now�� �ƴϸ� no
			if(stack.peek()==now) {
				stack.pop();
				list.add('-');
			}else {
				isBreak = true;
				break;
			}
		}
		// ���� �� ����
		while( !stack.isEmpty()) {
			stack.pop();
			list.add('-');
		}
		
		// ��� ���
		if(isBreak) {
			System.out.println("NO");
		}else {
			for (Character character : list) {
				System.out.println(character);
			}
		}
	}
}
