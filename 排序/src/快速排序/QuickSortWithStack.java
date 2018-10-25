package ��������;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QuickSortWithStack {

	public static void main(String[] args) {
		
		int[] arr = new int[] {4,7,6,5,3,2,8,1};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int startIndex, int endIndex) {
		// ��һ������ջװ�ָ�������
		Stack<Map<String,Integer>> quickSortStack = new Stack<Map<String,Integer>>();
		
		Map<String,Integer> rootParam = new HashMap<String,Integer>();
		
		rootParam.put("startIndex", startIndex);
		rootParam.put("endIndex",endIndex);
		quickSortStack.push(rootParam);
		//��ջ��Ϊ��ʱ
		while(!quickSortStack.isEmpty()){
			//ջ��Ԫ�س�ջ���õ���ʼ�±�
			Map<String,Integer> param = quickSortStack.pop();
			
			int pivotIndex = partition(arr,param.get("startIndex"),param.get("endIndex"));
			
			if(param.get("startIndex") < pivotIndex - 1){
				
				Map<String,Integer> leftParam = new HashMap<String,Integer>();
				leftParam.put("startIndex",param.get("startIndex"));
				leftParam.put("endIndex",pivotIndex - 1);
				quickSortStack.push(leftParam);
				
			}
			if(param.get("endIndex") > pivotIndex + 1){
				
				Map<String,Integer> rightParam = new HashMap<String,Integer>();
				rightParam.put("startIndex",pivotIndex + 1);
				rightParam.put("endIndex",param.get("endIndex"));
				quickSortStack.push(rightParam);
				
			}
		}
		
		
	}

	private static int partition(int[] arr, int startIndex, int endIndex) {
		// TODO �Զ����ɵķ������
		
		int pivot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;
		
		while(left!=right){
			//����ָ������
			while(left<right && arr[right] > pivot){
				right--;
			}
			//����ָ������
			while(left<right && arr[left] <= pivot){
				left++;
			}
			//����ָ��
			if(left<right){
				int p = arr[right];
				arr[right] = arr[left];
				arr[left] = p;
			}
		}
		
		int p = arr[startIndex];
		arr[startIndex] = arr[left];
		arr[left] = p;
		
		return left;
	}

}
