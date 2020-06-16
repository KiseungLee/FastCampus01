package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem1092
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. ���� ����\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);				
		// Scanner sc = new Scanner(System.in);
	    
	    // ũ���� �Է�, �ִ밪 �̱�, ����
	    int n = sc.nextInt();
	    Integer[] cranes = new Integer[n];
	    int maxCrane = 0;
	    for (int i = 0; i < cranes.length; i++)
		{
			int crane = sc.nextInt();
			maxCrane = Math.max(maxCrane, crane);
			cranes[i] = crane;
		}
	    Arrays.sort(cranes, Comparator.reverseOrder());
	    
	    // �ڽ� �Է�, �ִ밪 �̱�, ����
	    int m = sc.nextInt();
	    Integer[] boxes = new Integer[m];
	    int maxBox = 0;
	    for (int i = 0; i < boxes.length; i++)
		{
			int box = sc.nextInt();
			maxBox = Math.max(maxBox, box);
			boxes[i] = box;
		}
	    Arrays.sort(boxes, Comparator.reverseOrder());
	    
	    // �ű� �� ���� ����� -1 ��� ����
	    if(maxCrane<maxBox) {
	    	System.out.println(-1);
	    	return;
	    }
	    
	    // ��� �ڽ� �ű� �� ���� �ݺ�
	    boolean[] done = new boolean[m];
	    int time = 0;
	    int count = 0;
	    while (count<m) {
	    	time += 1;
		    for (int i = 0; i < cranes.length; i++)
			{
		    	int doneBefore = -1;
				for (int j = doneBefore+1 ; j < boxes.length; j++)
				{
					if(!done[j] && cranes[i]>=boxes[j]) {
						done[j] = true;
						count += 1;
						doneBefore = j;
						break;
					}
				} // end for j boxes
				// i��° ũ������ �ű� �� �ִ� �ڽ��� ��� doneBefore�� -1�� ���� �ִٸ� i��° ���� ũ���ε��� �غ� �ʿ䵵 �����Ƿ� break
				if(doneBefore==-1)
					break;
			} // end for i cranes
	    } // end while count<m

	    System.out.println(time);
	} // end main
}
