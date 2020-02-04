package Lec01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ���� https://www.acmicpc.net/problem/2920
public class Problem2920 {
	public static void main(String[] args) throws IOException {
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] splitLine = line.split(" ");
		int[] numList = new int[splitLine.length];
		
		// �Է� Ÿ�� ��ȯ
		for (int i = 0; i < splitLine.length; i++) {
			numList[i] = Integer.parseInt(splitLine[i]);
		}
		
		// ����, ���������� üũ���� ����
		boolean isAscending = true;
		boolean isDescending = true;
		// ����, ���� ���� �˻�
		for(int i=0; i<numList.length-1; i++) {
			if(numList[i]>numList[i+1]) {
				isAscending = false;
			}else {
				isDescending = false;
			}
		}
		
		// ��� ���
		if(isAscending)
			System.out.println("ascending");
		else if(isDescending)
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
