package BOJ;

import java.util.Scanner;

public class NQueen {
	
	static int count;
	static int[] chessBoard; // chessBoard[x] : ü������ x��° �ٿ� ���� �ִ� �� ��ġ
	static int n;
	
	public static void main(String[] args) {
		// ���̽����� Ǯ�ٰ� ���̽��� �ð��ʰ��� �ذ����� ���� �ڹٷ� �׽�Ʈ �غ��� �Ŷ� �ڵ尡 �ſ� �������մϴ�.
		// �Է�
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		
		// ex) chessBoard[2] = 3 : 2���� ���� 3��° �࿡ ���� �ִ�.
		chessBoard = new int[n];
		
		// 0��° ���� ���
		run(0);
		
		// ��� ���
		System.out.println(count);
		
	}
	
	public static void run(int x) {
		if(x==n) {
			count++;
		}else {
			for(int i=0; i<n; i++) {
				// x��° ���� ���� i��° ĭ�� ���ƺ�
				chessBoard[x] = i;
				// �� Ʈ��ŷ �˻� ����ϸ� �����ٿ� �� ���ƺ���
				if(backTrack(x))
					run(x+1);
			}
		}
	}
	
	public static boolean backTrack(int x) {
		for(int i=0; i<x; i++) {
			// ���� ���� �ִ���
			if(chessBoard[i]==chessBoard[x])
				return false;
			// �밢���� ���� �ִ���
			if(Math.abs(chessBoard[i]-chessBoard[x])==x-i)
				return false;
		}
		return true;
	}
}
