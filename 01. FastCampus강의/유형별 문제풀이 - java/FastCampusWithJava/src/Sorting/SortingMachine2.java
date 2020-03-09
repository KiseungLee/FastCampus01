package Sorting;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.Random;

public class SortingMachine2 {
	public static void main(String[] args) throws Exception {
		Sorting2 sort = new Sorting2();
		// int[] arr = {3,12,34,2,3,51,1,0,0,1,2,3,45,1,0,12,3,1,0,3,2,1,5,7};
		int[] arr = {1,2,3,4,5,6,7,7,7,1,9,2,8,1,13};
		System.out.println(">> bubbleSort    : "+Arrays.toString(sort.bubbleSort(Arrays.copyOf(arr, arr.length))));
		System.out.println(">> selectionSort : "+Arrays.toString(sort.selectionSort(Arrays.copyOf(arr, arr.length))));
		System.out.println(">> insertionSort : "+Arrays.toString(sort.insertionSort(Arrays.copyOf(arr, arr.length))));
		System.out.println(">> mergeSort     : "+Arrays.toString(sort.mergeSort(Arrays.copyOf(arr, arr.length))));
		System.out.println(">> quickSort     : "+Arrays.toString(sort.quickSort(Arrays.copyOf(arr, arr.length))));
		System.out.println(">> radixSort     : "+Arrays.toString(sort.radixSort(Arrays.copyOf(arr, arr.length))));
		System.out.println(">> countingSort  : "+Arrays.toString(sort.countingSort(Arrays.copyOf(arr, arr.length))));
	}
}

class Sorting2{
	public int[] bubbleSort(int[] arr) throws Exception {
		for(int i=0 ; i<arr.length-1; i++) {
			for(int j=0 ; j<arr.length-1-i; j++) {
				if(arr[j]>arr[j+1])
					swap(arr,j,j+1);
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
					minValue= arr[j];
				}
			}
			swap(arr, i, minIdx);
		}
		return arr;
	}
	
	public int[] insertionSort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int now = arr[i];
			int j=i-1;
			for(; j>=0; j--) {
				if(arr[j]>=now) {
					arr[j+1] = arr[j];
				}else {
					arr[j+1] = now;
					break;
				}
			}
			if(j==-1)
				arr[0]=now;
		}
		
		
		return arr;
	}
	
	
	// 삽입정렬도 new 없이 가야 될거 같음.
	public int[] insertionSort2(int[] arr) throws Exception {
		for(int i=1; i<arr.length; i++) {
			boolean isBreak = false;
			for(int j=i-1; j>=0; j--) {
				if(arr[i]>arr[j]) {
					// i번째를 j번째 뒤에 insert
					arr = insertBack(arr, i, j);
					isBreak = true;
					break;
				}
			}
			if(!isBreak)
				// i번째를 j앞에 insert
				arr = insertFront(arr, i, 0);
		}
		return arr;
	}
	
	public int[] mergeSort(int[] arr) {
		mergeSortlet(arr, 0, arr.length-1);
		return arr;
	}
	
	private void mergeSortlet(int[] arr, int start, int end) {
		// 종료조건
		if(start>=end)
			return;
		
		// divide
		int mid = (start+end)/2;
		
		// 재귀
		mergeSortlet(arr, start, mid);
		mergeSortlet(arr, mid+1, end);
		
		// conquer
		int leftIdx = start;
		int rightIdx = mid+1;
		int[] tempArr = new int[end-start+1];
		int tempIdx = 0;
		while(leftIdx<=mid && rightIdx<=end) {
			if(arr[leftIdx]<arr[rightIdx]) {
				tempArr[tempIdx++] = arr[leftIdx++];
			}else {
				tempArr[tempIdx++] = arr[rightIdx++];
			}
		}
		while(leftIdx<=mid) {
			tempArr[tempIdx++] = arr[leftIdx++];
		}
		while(rightIdx<=end) {
			tempArr[tempIdx++] = arr[rightIdx++];
		}
		for(int i=0; i<tempArr.length; i++) {
			arr[i+start] = tempArr[i];
		}
	}
	// 머지 소트도 추가 배열 없이 가능해야 할거 같음
	public int[] mergeSort2(int[] arr) {
		// 종료조건
		if(arr.length<=1)
			return arr;
		
		// divide
		int leftCount = arr.length/2;
		int rightCount = arr.length-leftCount;
		int[] left = new int[leftCount];
		int[] right = new int[rightCount];
		for(int i=0; i<arr.length; i++) {
			if(i<leftCount)
				left[i] = arr[i];
			else
				right[i-leftCount] = arr[i];
		}
		
		// 재귀 보내기
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
	
	private <T> void quickSort(T[] arr, Comparator<T> comparator){
		quickSortlet(arr, 0 , arr.length-1, comparator);
	}
	
	private <T> void quickSortlet(T[] arr, int start, int end, Comparator<T> comparator) {
		// 종료
		if(start>=end)
			return;
		
		// pivot
		T pivot = makePivot(arr, start ,end);
		int left = start;
		int right = end;
		
		// 나누기
		while(left<=right) {
			while(comparator.compare(arr[left], pivot)<0) {
				left++;
			}
			while(comparator.compare(arr[right], pivot)>0) {
				right--;
			}
			if(left<=right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		
		// 재귀
		quickSortlet(arr, start, right, comparator);
		quickSortlet(arr, left, end, comparator);
	}
	
	private <T> void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private <T> T makePivot(T[] arr, int start, int end) {
		return arr[(start+end)/2];
	}

	// 퀵 소트 다 바꿔야 되.
	public int[] quickSort(int[] arr) throws Exception {
		quickSortlet(arr, 0, arr.length-1);
		return arr;
	}
	
	
	private void quickSortlet(int[] arr, int start, int end) throws Exception {
		// 종료조건
		if(start>=end)
			return;
		
		// pivot설정
		int pivot = makePivot(arr, start, end);
		
		// pivot기준으로 나누기
		int left = start;
		int right = end;
		while(left<=right) {
			while(arr[left]<pivot)
				left++;
			while(arr[right]>pivot)
				right--;
			
			if(left<=right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		// 재귀보내기
		quickSortlet(arr, start, right);
		quickSortlet(arr, left, end);
	}
	
	private int makePivot(int[] arr, int start, int end) {
		return arr[(start+end)/2];
	}
	
	public int[] radixSort(int[] arr) {
		return arr;
	}
	
	public int[] countingSort(int[] arr) {
		return arr;
	}
	
	private int makePivot(int[] arr) {
		return arr[new Random().nextInt(arr.length)];
	}
	
	private int[] insertFront(int[] arr, int i, int j) throws Exception {
		isZeroOrMore(i);
		isZeroOrMore(j);
		
		int[] result = new int[arr.length];
		int resultIdx = 0;
		
		for(int x=0; x<arr.length; x++) {
			if(x==i) {
				continue;
			}else if(x==j) {
				result[resultIdx++] = arr[i];
				result[resultIdx++] = arr[j];
			}else {
				result[resultIdx++] = arr[x];
			}
		}
		return result;
	}
	
	private int[] insertBack(int[] arr, int i, int j) throws Exception {
		isZeroOrMore(i);
		isZeroOrMore(j);
		
		int[] result = new int[arr.length];
		int resultIdx = 0;
		
		for(int x=0; x<arr.length; x++) {
			if(x==i) {
				continue;
			}else if(x==j) {
				result[resultIdx++] = arr[j];
				result[resultIdx++] = arr[i];
			}else {
				result[resultIdx++] = arr[x];
			}
		}
		return result;
	}
	
	private void swap(int[] arr, int i, int j) throws Exception {
		isZeroOrMore(i);
		isZeroOrMore(j);
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;			
	}
	
	private boolean isZeroOrMore(int n) throws Exception {
		if(n<0) {
			throw new Exception("0보다 작은 값이 입력됐습니다.");			
		}else {
			return true;
		}
	}
}
