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
		// 종류별 갯수 구함
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String[] clothe : clothes)
			map.put(clothe[1] ,map.getOrDefault(clothe[1], 0)+1);
		
		// 종류별 갯수+1 씩 해서 다 곱해줌 (+1은 그 종류 옷 안입을때)
		int result = 1;
		for(String key : map.keySet())
			result *= (map.get(key)+1);
		
		// 아무것도 안입을때의 1경우만 빼고 리턴
		return result-1;
	}
}