package ð�����������;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] arr = new int[]{3,5,2,6,4,7,6,8};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr) {
		// TODO �Զ����ɵķ������
		int temp;
		int lastExchangeIndex = 0;
		//�趨����߽磬����������ֱ������
		int sortBorder = arr.length - 1;
		for(int i = 0;i < arr.length; i++){
			//�ж��Ƿ��Ѿ�������
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
