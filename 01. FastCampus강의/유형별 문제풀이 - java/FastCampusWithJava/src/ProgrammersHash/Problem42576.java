package ProgrammersHash;

import java.util.HashMap;

public class Problem42576 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] participant = new String[] {"kiki", "leo", "kiki", "eden"} ;
		String[] completion = new String[] {"eden", "kiki", "kiki"};
		System.out.println(sol.solution(participant, completion));
	}
}

class Solution{
	public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		/*
		for(String man : participant) {
			if(map.containsKey(man)) {
				map.put(man, map.get(man)+1);
			}else {
				map.put(man, 1);
			}
		}
		*/
		for(String man : participant) {
			map.put(man, map.getOrDefault(man, 1));
		}
		for(String man : completion) {
			map.put(man, map.get(man)-1);
		}
		for(String key : map.keySet()) {
			if(map.get(key)!=0) {
				return key;
			}
		}
		return "";
	}
}