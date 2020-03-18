package BOJ;

import java.util.Scanner;

public class NQueen {
	
	static int count;
	static int[] chessBoard; // chessBoard[x] : 체스판의 x번째 줄에 퀸이 있는 행 위치
	static int n;
	
	public static void main(String[] args) {
		// 파이썬으로 풀다가 파이썬의 시간초과를 해결하지 못해 자바로 테스트 해보는 거라 코드가 매우 지저분합니다.
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		
		// ex) chessBoard[2] = 3 : 2번재 줄의 3번째 행에 퀸이 있다.
		chessBoard = new int[n];
		
		// 0번째 부터 출력
		run(0);
		
		// 결과 출력
		System.out.println(count);
		
	}
	
	public static void run(int x) {
		if(x==n) {
			count++;
		}else {
			for(int i=0; i<n; i++) {
				// x번째 줄의 퀸을 i번째 칸에 놓아봄
				chessBoard[x] = i;
				// 백 트랙킹 검사 통과하면 다음줄에 퀸 놓아보기
				if(backTrack(x))
					run(x+1);
			}
		}
	}
	
	public static boolean backTrack(int x) {
		for(int i=0; i<x; i++) {
			// 위에 퀸이 있는지
			if(chessBoard[i]==chessBoard[x])
				return false;
			// 대각선에 퀸이 있는지
			if(Math.abs(chessBoard[i]-chessBoard[x])==x-i)
				return false;
		}
		return true;
	}
}
