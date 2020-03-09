package Sorting;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SortingMachine {
	public static void main(String[] args) throws Exception {
		int[] arr = {3,12,5,3,75,22,13,65,8,64, 2,3,13, 0, 23};
		Sorting sor = new Sorting();
		System.out.println(">> bubbleSort    : " + Arrays.toString(sor.bubbleSort(Arrays.copyOf(arr, arr.length))));
		System.out.println(">> selectionSort : " + Arrays.toString(sor.selectionSort(Arrays.copyOf(arr, arr.length))));
		System.out.println(">> insertionSort : " + Arrays.toString(sor.insertionSort(Arrays.copyOf(arr, arr.length))));
		System.out.println(">> mergeSort     : " + Arrays.toString(sor.mergeSort(Arrays.copyOf(arr, arr.length))));
		System.out.println(">> quickSort     : " + Arrays.toString(sor.quickSort(Arrays.copyOf(arr, arr.length))));
		System.out.println(">> radixSort     : " + Arrays.toString(sor.radixSort(Arrays.copyOf(arr, arr.length))));
		System.out.println(">> countingSort  : " + Arrays.toString(sor.countingSort(Arrays.copyOf(arr, arr.length))));
	}
	public static void canChange(int[] arr) {
		int[] temp = new int[arr.length];
		arr = temp;
	}
}

class Sorting{
	public int[] bubbleSort(int[] arr) throws Exception {
		for(int i=0 ; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j]>arr[j+1])
					swap(arr, j, j+1);
			}
		}
		return arr;
	}
	
	public int[] selectionSort(int[] arr) throws Exception {
		for(int i=0; i<arr.length-1; i++) {
			int minIdx = 0;
			int minValue = Integer.MAX_VALUE;
			for(int j=i; j<arr.length; j++) {
				if(arr[j]<minValue) {
					minIdx = j;
					minValue = arr[j];
				}
			}
			swap(arr, i, minIdx);
		}
		return arr;
	}
	
	public int[] insertionSort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			boolean isBreak = false;
			for(int j=i-1; j>=0; j--) {
				if(arr[j]<arr[i]) {
					// i번째를 j번째 뒤에 insert한다.
					arr = insertion(arr, i, j);
					isBreak = true;
					break;
				}
			}
			if(!isBreak)
				arr = insertion(arr, i, -1);
		}
		
		return arr;
	}
	
	public int[] mergeSort(int[] arr) {
		// 종료조건
		if(arr.length<=1)
			return arr;
		
		// divide
		int leftCount = arr.length/2;
		int rightCount = arr.length - leftCount;
		int[] left = new int[leftCount];
		int[] right = new int[rightCount];
		for(int i=0; i<arr.length; i++) {
			if(i<leftCount) {
				left[i] = arr[i];
			}else {
				right[i-leftCount] = arr[i];
			}
		}
		
		// 재귀보내기
		left = mergeSort(left);
		right = mergeSort(right);
		
		// conquer
		int[] result = new int[arr.length];
		int resultIdx = 0;
		int leftIdx = 0;
		int rightIdx = 0;
		while(leftIdx<leftCount && rightIdx<rightCount) {
			if(left[leftIdx]<right[rightIdx]) {
				result[resultIdx++] = left[leftIdx++];
			}else {
				result[resultIdx++] = right[rightIdx++];
			}
		}
		while(leftIdx<leftCount) {
			result[resultIdx++] = left[leftIdx++];
		}
		while(rightIdx<rightCount) {
			result[resultIdx++] = right[rightIdx++];
		}
		return result;
	}
	
	public int[] quickSort(int[] arr) {
		// 종료조건
		if(arr.length<=1 || arr[0]==arr[arr.length-1])
			return arr;
		
		// pivot 설정
		int pivot = makePivot(arr);
		
		// 나누기
		Queue<Integer> left = new ArrayDeque<Integer>();
		Queue<Integer> right = new ArrayDeque<Integer>();
		for(int i=0; i<arr.length ; i++) {
			if(arr[i]<=pivot) {
				left.add(arr[i]);
			}else {
				right.add(arr[i]);
			}
		}
		
		// 재귀 보내기
		int[] leftArr = left.stream().mapToInt(i -> i).toArray();
		int[] rightArr = right.stream().mapToInt(i -> i).toArray();
		leftArr = quickSort(leftArr);
		rightArr = quickSort(rightArr);
		
		// 합치기
		int[] result = new int[arr.length];
		int resultIdx = 0;
		for(int n : leftArr)
			result[resultIdx++] = n;
		for(int n : rightArr)
			result[resultIdx++] = n;

		return result;
	}
	
	public int[] radixSort(int[] arr) {
		// 최댓값 뽑기
		int maxNum = getMaxNum(arr);
		
		// 최댓값의 자릿수 뽑기
		int maxDigit = getMaxDigit(maxNum);
		
		// 자릿수 만큼의 Queue 배열 만들기
		Queue<Integer>[] queueArr = new Queue[9];
		for(int i=0; i<queueArr.length ; i++)
			queueArr[i] = new ArrayDeque<Integer>();
		
		// 자릿수 별로 정렬 하기
		for(int i=1; i<=maxDigit; i++) {
			radixSortlet(arr, queueArr, i);
		}
		
		return arr;
	}
	
	public int[] countingSort(int[] arr) {
		
		return arr;
	}
	
	private void radixSortlet(int[] arr, Queue<Integer>[] queueArr, int n) {
		for(int i=0; i<arr.length; i++) {
			int num = arr[i];
			int numIdx = getNum(num, n);
			queueArr[numIdx].add(num);
		}
		int arrIdx = 0;
		for(Queue<Integer> queue : queueArr) {
			while(!queue.isEmpty())
				arr[arrIdx++] = queue.poll();
		}
	}
	
	private int getNum(int num, int n) {
		for(int i=0; i<n-1; i++) {
			num = num/10;
		}
		return num%10;
	}
	
	private int getMaxDigit(int num) {
		int n = 0;
		while(num!=0) {
			num = num/10;
			n++;
		}
		return n;
	}
	
	private int getMaxNum(int[] arr) {
		return Arrays.stream(arr).max().getAsInt();
	}
	
	private int makePivot(int[] arr) {
		return (arr[0]+arr[arr.length-1])/2;
	}
	
	// i번째를 j번째 뒤에 insert 한다. ** j는 -1 이상
	private int[] insertion(int[] arr, int i, int j) {
		int[] result = new int[arr.length];
		int resultIdx = 0;
		
		if(j==-1)
			result[resultIdx++] = arr[i];
		
		for(int x=0; x<arr.length ; x++) {
			if(x==i) {
				continue;
			}else if(x==j) {
				result[resultIdx++] = arr[x];
				result[resultIdx++] = arr[i];
			}else {
				result[resultIdx++] = arr[x];
			}
		}
		return result;
	}
	
	private void swap(int[] arr, int i, int j) throws Exception {
		// 예외처리
		if(!isZeroOrMore(i) || !isZeroOrMore(j))
			throw new Exception("something");

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private boolean isZeroOrMore(int n){
		return (n >= 0 ? true : false);
	}
}
