package ProgrammersHash;

import java.util.HashMap;

public class Problem42578 {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		String[][] clothes = new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(sol.solution(clothes));
	}
}

class Solution3{
	public int solution(String[][] clothes) {
		// ������ ���� ����
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String[] clothe : clothes)
			map.put(clothe[1] ,map.getOrDefault(clothe[1], 0)+1);
		
		// ������ ����+1 �� �ؼ� �� ������ (+1�� �� ���� �� ��������)
		int result = 1;
		for(String key : map.keySet())
			result *= (map.get(key)+1);
		
		// �ƹ��͵� ���������� 1��츸 ���� ����
		return result-1;
	}
}