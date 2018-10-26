package 冒泡排序改良版;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = new int[]{3,5,2,6,4,7,6,8};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr) {
		// TODO 自动生成的方法存根
		int temp;
		int lastExchangeIndex = 0;
		//设定无序边界，若已有序则直接跳过
		int sortBorder = arr.length - 1;
		for(int i = 0;i < arr.length; i++){
			//判断是否已经有序了
			boolean isSorted = true;
			for(int j = 0;j < sortBorder; j++){
				if(arr[j] > arr[j + 1]){
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					
					isSorted = false;
					lastExchangeIndex = j;
				}
			}
			sortBorder = lastExchangeIndex;
			if(isSorted){
				break;
			}
		}
	}

}
