package ������;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void heapSort(int[] arr) {
		// ���������鹹���ɶ����
		for(int i = (arr.length-2)/2; i >= 0; i--){
			downAdjust(arr,i,arr.length);
		}
		//�������
		System.out.println(Arrays.toString(arr));
		//ѭ��ɾ���Ѷ�Ԫ��
		for(int i = arr.length - 1; i > 0; i --){
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			//�³���������
			downAdjust(arr,0,i);
		}
		
	}

	private static void downAdjust(int[] arr, int parentIndex, int length) {
		// temp���游��㣬�������ĸ�ֵ
		int temp = arr[parentIndex];
		int childIndex = 2*parentIndex + 1;
		//�ж��Һ���
		while(childIndex < length){
			if(childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]){
				childIndex++;
			}
			//������ڵ�С���κ�һ�����ӵ�ֵ��ֱ������
			if(temp >= arr[childIndex])
				break;
			arr[parentIndex] = arr[childIndex];
			parentIndex = childIndex;
			childIndex = 2 * childIndex + 1;
		}
		arr[parentIndex] = temp;
	}

}
// 1.����ѱ�������һ����ȫ������
// 2.���ѵĶѶ����������е����Ԫ��


// �������㷨����

// 1.���������鹹���ɶ����
// 2.ѭ��ɾ���Ѷ�Ԫ�أ��Ƶ�����β�������ڲ����¶�


//      10
//     /  \
//    8    9
//   / \  / \
//  7   54   6
// /    \
//3      2

//		2
// 	   /  \
//    8    9
//   / \  / \
//  7   54   6
// /    \
//3      10

//      9
//	   /  \
//	  8    6
//	 / \  / \
//	7   54   2
// /    \
//3      10





