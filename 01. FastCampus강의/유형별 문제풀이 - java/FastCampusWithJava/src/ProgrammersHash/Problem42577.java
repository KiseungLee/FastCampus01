package ProgrammersHash;

public class Problem42577 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		String[] phoneBook = new String[] {"123", "456", "789"};
		System.out.println(sol.solution(phoneBook));
	}
}

class Solution2{
	public boolean solution(String[] phoneBook) {
		for(int i=0; i<phoneBook.length-1; i++) {
			for(int j=i+1 ; j<phoneBook.length; j++) {
				if(isContain(phoneBook[i], phoneBook[j]))
					return false;
			}
		}
		return true;
	}
	
	public boolean isContain(String str1, String str2) {
		// StartWith라는 것도 있다!
		if(str1.indexOf(str2)==0 || str2.indexOf(str1)==0)
			return true;
		else
			return false;
	}
}
