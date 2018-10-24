package 快速排序;

import java.util.Arrays;

public class QuickSort2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = new int[] {4,7,6,5,3,2,8,1};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int startIndex, int endIndex) {
		// TODO 自动生成的方法存根
		if(startIndex >= endIndex){
			return;
		}
		
		int pivotIndex = partition(arr,startIndex,endIndex);
		quickSort(arr,startIndex,pivotIndex - 1);
		quickSort(arr,pivotIndex + 1,endIndex);
		
	}

	private static int partition(int[] arr, int startIndex, int endIndex) {
		// TODO 自动生成的方法存根
		
		int pivot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;
		while(left != right){
			while(left < right && arr[right] > pivot){
				right--;
			}
			while(left < right && arr[left] <= pivot){
				left++;
			}
			if(left < right) {
				int p = arr[left];
				arr[left] = arr[right];
				arr[right] = p;
			}
			
		}
		int p = arr[left];
		arr[left] = arr[startIndex];
		arr[startIndex] = p;
		return left;
	}

}
