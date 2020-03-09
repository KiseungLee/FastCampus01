package Lec01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 음계 https://www.acmicpc.net/problem/2920
public class Problem2920 {
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] splitLine = line.split(" ");
		int[] numList = new int[splitLine.length];
		
		// 입력 타입 변환
		for (int i = 0; i < splitLine.length; i++) {
			numList[i] = Integer.parseInt(splitLine[i]);
		}
		
		// 오름, 내림차순을 체크해줄 변수
		boolean isAscending = true;
		boolean isDescending = true;
		// 오름, 내림 차순 검사
		for(int i=0; i<numList.length-1; i++) {
			if(numList[i]>numList[i+1]) {
				isAscending = false;
			}else {
				isDescending = false;
			}
		}
		
		// 결과 출력
		if(isAscending)
			System.out.println("ascending");
		else if(isDescending)
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
