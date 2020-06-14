package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem2798 {
	public static void main(String[] args) throws FileNotFoundException {
		// 입력 설정
		File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
		Scanner sc = new Scanner(file);
		
		// 입력
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] cards = new int[n];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = sc.nextInt();
		}
		
		int result = 0;
		for (int i = 0; i < cards.length-2; i++) {
			for (int j = i+1; j < cards.length-1; j++) {
				for (int k = j+1; k < cards.length; k++) {
					int local_sum = cards[i]+cards[j]+cards[k];
					if(local_sum <= m && local_sum>result)
						result = local_sum;
				}
			}
		}
		
		System.out.println(result);
	}
}
