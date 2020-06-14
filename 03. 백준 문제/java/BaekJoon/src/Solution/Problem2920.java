package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Problem2920 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
		Scanner sc = new Scanner(file);
		// Scanner sc = new Scanner(System.in);
		
		int[] numArr = new int[8];
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = sc.nextInt();
		}
		boolean ascending = true;
		boolean descending = true;
		
		for (int i = 0; i < numArr.length-1; i++) {
			if(numArr[i]>numArr[i+1])
				ascending = false;
			else if (numArr[i]<numArr[i+1])
				descending = false;
		}
		
		if(ascending)
			System.out.println("ascending");
		else if(descending)
			System.out.println("descending");
		else
			System.out.println("mixed");
		sc.close();
	}
}
