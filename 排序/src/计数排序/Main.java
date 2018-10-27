package 计数排序;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = new int[]{4,4,3,5,6,7,8,9,1,3,4,5};
		int[] sortedArray = countSort(arr);
		System.out.println(Arrays.toString(sortedArray));
	}

	private static int[] countSort(int[] arr) {
		// TODO 自动生成的方法存根
		int max = arr[0];
		int min = arr[0];
		for(int i = 1; i < arr.length;i++){
			if(arr[i] > max){
				max = arr[i];
			}
			if(arr[i] < min){
				min = arr[i];
			}
		}
		int d = max - min;
		int[] countArray = new int[d+1];
		for(int i = 0; i < arr.length;i++){
			countArray[arr[i] - min]++;
		}
		
		  
		return null;
	}

}
