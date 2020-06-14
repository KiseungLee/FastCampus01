package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Problem1874 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
		Scanner sc = new Scanner(file);
		
		// n
		int n = sc.nextInt();
		// 수열들 다룰 stack
		Stack<Integer> stack = new Stack<>();
		// 스택에 들어간 숫자 기록
		int num = 0;
		// 중간에 끊겼는지
		boolean isBreak = false;
		// 결과 담을 리스트
		List<Character> list = new ArrayList<Character>();
		
		for (int i = 0; i < n; i++) {
			// 입력
			int now = sc.nextInt();
			
			// num이 now가 될 때까지 넣기
			while(num<now) {
				stack.push(++num);
				list.add('+');
			}
			
			// stack의 맨 위에 값이 now면 pop, now가 아니면 no
			if(stack.peek()==now) {
				stack.pop();
				list.add('-');
			}else {
				isBreak = true;
				break;
			}
		}
		// 남은 거 빼기
		while( !stack.isEmpty()) {
			stack.pop();
			list.add('-');
		}
		
		// 결과 출력
		if(isBreak) {
			System.out.println("NO");
		}else {
			for (Character character : list) {
				System.out.println(character);
			}
		}
	}
}
