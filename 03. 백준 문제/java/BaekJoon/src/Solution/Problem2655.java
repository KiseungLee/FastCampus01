package Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Problem2655
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// �Է�
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. ���� ����\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);				
		// Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    Brick[] bricks = new Brick[n];
	    for (int i = 0; i < bricks.length; i++)
			bricks[i] = new Brick(i+1, sc.nextInt(), sc.nextInt(), sc.nextInt());

	    
	    // �ظ����� ����
	    Arrays.sort(bricks, new Comparator<Brick>()
		{
			@Override
			public int compare(Brick a, Brick b)
			{
				return b.area-a.area;
			}
		});

	    // dp[i] : i��° ������ ���� ���� ���� �� �ִ� ����
	    int[] dp = new int[n];
	    dp[0] = bricks[0].height;
	    // dp ���� : i��° ���� �ڷ� dp[0]~dp[i-1] �߿� i��° �������� ���԰� ���� �͵� �� �ִ� ���̸� ���ؼ� i��° ���� ���̸� ����
	    for (int i = 1; i < bricks.length; i++)
		{
	    	int height = 0;
    		for (int j = 0; j < i; j++)
    		{
    			if(bricks[j].weight > bricks[i].weight) {
    				if(dp[j]>height) {
    					height = dp[j];
    				}
    			}
    		} // end for j
    		dp[i] = height+bricks[i].height;
		} // end for i
	    
	    // �������� ���� ������ ���� �ִ� ���̿� �ִ� ���� ������ �ε��� �̱�
	    int max_height = 0;
	    int max_height_index = 0;
	    for (int i = 0; i < dp.length; i++)
		{
			if(dp[i]>max_height) {
				max_height = dp[i];
				max_height_index =  i;
			}
		}
	    // �ִ� ���̿��� �ִ� ���� ������ ���̸� ���鼭 ������
	    int count = 0;
	    List<Integer> result = new ArrayList<>();
	    while(max_height!=0) {
	    	count += 1;
	    	max_height -= bricks[max_height_index].height;
	    	result.add(bricks[max_height_index].index);
	    	for (int i = max_height_index-1; i >=0 ; i--)
			{
				if(dp[i]==max_height) {
					max_height_index = i;					
					break;
				}
			} // end for i
	    	
	    }// end while
	    
	    // ���� ��� ���
	    System.out.println(count);
	    for(int num : result)
	    	System.out.println(num);
	}
}

class Brick{
	int index;
	int area;
	int height;
	int weight;
	public Brick(int index, int area, int height, int weight) {
		this.index = index;
		this.area = area;
		this.height = height;
		this.weight = weight;
	}
}
