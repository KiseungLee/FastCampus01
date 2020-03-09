package ProgrammersHash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem42579 {
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		String[] genres = new String[] {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = new int[] {500, 600, 150, 800, 2500};
		System.out.println(sol.solution(genres, plays));
	}
}
class Genre{
	private String name;
	private int count;
	private ArrayList<int[]> list;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ArrayList<int[]> getList() {
		return list;
	}

	public void setList(ArrayList<int[]> list) {
		this.list = list;
	}
	
	Genre(String name){
		this.name = name;
		this.count = 0;
		this.list = new ArrayList<int[]>();
	}
	void addCount(int count) {
		this.count += count;
	}
	void addList(int index, int num) {
		list.add(new int[] {index, num});
	}
	void sortList(){
		Collections.sort(list, (int[] a, int[] b)-> (b[1]-a[1]==0? a[0]-b[0]: b[1] - a[1]));
	}

}
class Solution4{
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Genre> map = new HashMap<String, Genre>();
		
		for(int i=0; i<genres.length; i++) {
			Genre genre = map.getOrDefault(genres[i], new Genre(genres[i]));
			genre.addCount(plays[i]);
			genre.addList(i, plays[i]);
			map.put(genres[i], genre);
		}
		
		List<Genre> list = new ArrayList<Genre>(map.values());
		Collections.sort((List<Genre>) list, (Genre g1, Genre g2) -> g2.getCount()-g1.getCount());
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(Genre genre : list) {
			genre.sortList();
			int count = 0;
			for(int[] i : genre.getList()) {
				result.add(i[0]);
				count++;
				if(count==2) break;
			}
		}
		
		int[] result2 = new int[result.size()];
		for(int i = 0 ; i<result.size(); i++)
			result2[i] = result.get(i);
		return result2;
	}
}