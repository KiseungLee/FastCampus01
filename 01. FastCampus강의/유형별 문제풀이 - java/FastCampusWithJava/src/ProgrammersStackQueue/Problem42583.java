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
		
		// 0으로 가득찬 도로를 만들어줌
		Deque<Integer> deque = new ArrayDeque<Integer>();
		while(deque.size()<l) {
			deque.push(0);
		}
		
		// 차가 다 나갈때 까지
		while(count<truckWeights.length) {
			time++;							// 시간 ++
			int out = deque.pollFirst();	// 나감
			if(out!=0) {					// 나간게 차라면
				count++;					// 갯수 증가
				weightNow -= out;			// 무게 감소
			}
			if(truckIdx<truckWeights.length &&weightNow+truckWeights[truckIdx] <= w) {	// 차가 남았고 && 다음 차가 들어가도 무게가 버틴다면
				deque.addLast(truckWeights[truckIdx]);	// 차 넣어주고
				weightNow += truckWeights[truckIdx];	// 무게 더하고
				truckIdx++;								// 다음 트럭으로
			}else {
				deque.addLast(0);						// 아니라면 그냥 도로 넣어줌
			}
		}
		
		return time;
	}
}
