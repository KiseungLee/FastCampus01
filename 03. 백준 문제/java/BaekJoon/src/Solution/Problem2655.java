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
		// 입력
	    File file = new File("C:\\Users\\Kiseung\\Documents\\AlgorithmStudy\\03. 백준 문제\\java\\BaekJoon\\src\\Solution\\input.txt");
	    Scanner sc = new Scanner(file);				
		// Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    Brick[] bricks = new Brick[n];
	    for (int i = 0; i < bricks.length; i++)
			bricks[i] = new Brick(i+1, sc.nextInt(), sc.nextInt(), sc.nextInt());

	    
	    // 밑면으로 정렬
	    Arrays.sort(bricks, new Comparator<Brick>()
		{
			@Override
			public int compare(Brick a, Brick b)
			{
				return b.area-a.area;
			}
		});

	    // dp[i] : i번째 벽돌이 가장 위에 있을 때 최대 높이
	    int[] dp = new int[n];
	    dp[0] = bricks[0].height;
	    // dp 연산 : i번째 벽돌 뒤로 dp[0]~dp[i-1] 중에 i번째 벽돌보다 무게가 작은 것들 중 최대 높이를 구해서 i번째 벽돌 높이를 더함
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
	    
	    // 역추적을 위한 연산을 위해 최대 높이와 최대 높이 벽돌의 인덱스 뽑기
	    int max_height = 0;
	    int max_height_index = 0;
	    for (int i = 0; i < dp.length; i++)
		{
			if(dp[i]>max_height) {
				max_height = dp[i];
				max_height_index =  i;
			}
		}
	    // 최대 높이에서 최대 높이 벽돌의 높이를 뼈면서 역추적
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
	    
	    // 최종 결과 출력
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
