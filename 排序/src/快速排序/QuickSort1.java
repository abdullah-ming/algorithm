package 快速排序;

import java.util.Arrays;

public class QuickSort1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = new int[] {4,7,6,4,4,2,8,1};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}
	public static void quickSort(int[] arr,int startIndex,int endIndex){
		if(startIndex>=endIndex){
			return;
		}
		
		int pivotIndex = partition(arr,startIndex,endIndex - 1);
		quickSort(arr,startIndex,pivotIndex);
		quickSort(arr,pivotIndex + 1,endIndex);
		
	}
	private static int partition(int[] arr, int startIndex, int endIndex) {
		// TODO 自动生成的方法存根
		int pivot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;
		int index = startIndex;
		
		while(left <= right){
			
			while(left <= right){
				if(arr[right] < pivot){
					arr[left] = arr[right];
					index = right;
					left++;
					break;
				}
				right--;
			}
			
			while(left <= right){
				if(arr[left] > pivot){
					arr[right] = arr[left];
					index = left;
					right--;
					break;
				}
				left++;
			}
		}
		arr[index] = pivot;
		return index;
	}

}
