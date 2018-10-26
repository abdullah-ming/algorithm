package 鸡尾酒排序;

import java.util.Arrays;

public class CockTailSort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = new int[]{2,3,4,5,6,7,8,1};
		cockTailSort(arr);
		System.out.println(Arrays.toString(arr)); 
	}

	private static void cockTailSort(int[] arr) {
		// TODO 自动生成的方法存根
		int temp;
		
		int lastRightExchangeIndex = 0;
		int lastLeftExchangeIndex = 0;
		int rightSortBorder = arr.length - 1;
		int leftSortBorder = 0;
		for(int i = 0;i < arr.length/2; i++){
			
			boolean isSorted = true;
			
			for(int j = leftSortBorder; j < rightSortBorder; j++){
				if(arr[j] > arr[j + 1]){
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSorted = false;
					lastRightExchangeIndex = j;
				}
			}
			rightSortBorder = lastRightExchangeIndex;
			if(isSorted){
				break;
			}
			isSorted = true;
			for(int j = rightSortBorder; j > leftSortBorder; j--){
				if(arr[j] < arr[j + 1]){
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					isSorted = false;
					lastLeftExchangeIndex = j;
				}
			}
			leftSortBorder = lastLeftExchangeIndex;
			if(isSorted){
				break;
			}
		}
	}

}
