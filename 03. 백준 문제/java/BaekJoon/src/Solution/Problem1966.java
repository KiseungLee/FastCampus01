package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;


public class Problem1966 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
		Scanner sc = new Scanner(file);
		
		int test_case = sc.nextInt();
		for (int i = 0; i < test_case ; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int count = 0;
			Queue<int[]> queue = new ArrayDeque<int[]>();
			
			Integer[] priorities = new Integer[n];
			int priortiesIdx = 0;
			
			for (int j = 0; j < n; j++) {
				int num = sc.nextInt();
				queue.add(new int[] {j, num});
				priorities[j] = num;
			}
			Arrays.sort(priorities, Collections.reverseOrder());
			
			while(!queue.isEmpty()) {
				if (queue.peek()[1] == priorities[priortiesIdx] ) {
					if(queue.peek()[0] == m) {
						System.out.println(count+1);
						break;
					}else {
						queue.poll();
						count+=1;
						priortiesIdx+=1;
					}
				}else {
					queue.add(queue.poll());
				}
			}
		}
	}
}
