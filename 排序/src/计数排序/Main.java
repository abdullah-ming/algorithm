package 计数排序;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = new int[]{95,94,91,98,99,90,93,91,92};
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
		
		int sum = 0;
		for(int i = 0; i < countArray.length;i++){
			sum += countArray[i];
			countArray[i] = sum;
		}
		
		int[] sortedArray = new int[arr.length];
		for(int i = arr.length - 1;i >= 0; i--){
			sortedArray[countArray[arr[i] - min] - 1] = arr[i];
			countArray[arr[i] - min] --;
		}
		return sortedArray;
	}

}
