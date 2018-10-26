package 堆排序;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void heapSort(int[] arr) {
		// 将无序数组构建成二叉堆
		for(int i = (arr.length-2)/2; i >= 0; i--){
			downAdjust(arr,i,arr.length);
		}
		//输出最大堆
		System.out.println(Arrays.toString(arr));
		//循环删除堆顶元素
		for(int i = arr.length - 1; i > 0; i --){
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			//下沉调整最大堆
			downAdjust(arr,0,i);
		}
		
	}

	private static void downAdjust(int[] arr, int parentIndex, int length) {
		// temp保存父结点，用于最后的赋值
		int temp = arr[parentIndex];
		int childIndex = 2*parentIndex + 1;
		//判断右孩子
		while(childIndex < length){
			if(childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]){
				childIndex++;
			}
			//如果父节点小于任何一个孩子的值，直接跳出
			if(temp >= arr[childIndex])
				break;
			arr[parentIndex] = arr[childIndex];
			parentIndex = childIndex;
			childIndex = 2 * childIndex + 1;
		}
		arr[parentIndex] = temp;
	}

}
// 1.二叉堆本质上是一个完全二叉树
// 2.最大堆的堆顶是整个堆中的最大元素


// 堆排序算法步骤

// 1.把无序数组构建成二叉堆
// 2.循环删除堆顶元素，移到集合尾部，调节产生新堆


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





