package ProgrammersStackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem42583 {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		int l = 100;
		int w = 100;
		int[] truckWeights = {10,10,10,10,10,10,10,10,10,10}; 
		System.out.println(sol.solution(l, w, truckWeights));
	}
}

class Solution3{
	public int solution(int l, int w, int[] truckWeights) {
		int weightNow = 0;
		int count = 0;
		int time = 0;
		int truckIdx = 0;
		
		// 0���� ������ ���θ� �������
		Deque<Integer> deque = new ArrayDeque<Integer>();
		while(deque.size()<l) {
			deque.push(0);
		}
		
		// ���� �� ������ ����
		while(count<truckWeights.length) {
			time++;							// �ð� ++
			int out = deque.pollFirst();	// ����
			if(out!=0) {					// ������ �����
				count++;					// ���� ����
				weightNow -= out;			// ���� ����
			}
			if(truckIdx<truckWeights.length &&weightNow+truckWeights[truckIdx] <= w) {	// ���� ���Ұ� && ���� ���� ���� ���԰� ��ƾ�ٸ�
				deque.addLast(truckWeights[truckIdx]);	// �� �־��ְ�
				weightNow += truckWeights[truckIdx];	// ���� ���ϰ�
				truckIdx++;								// ���� Ʈ������
			}else {
				deque.addLast(0);						// �ƴ϶�� �׳� ���� �־���
			}
		}
		
		return time;
	}
}
