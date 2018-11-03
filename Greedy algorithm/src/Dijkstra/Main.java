package Dijkstra;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		char[] vertex = new char[]{'A','B','C','D','E','F','G'};
		int[][] matrix = new int[7][];
		final int N = 65535;
		matrix[0]=new int[]{N,5,7,N,N,N,2};  
        matrix[1]=new int[]{5,N,N,9,N,N,3};  
        matrix[2]=new int[]{7,N,N,N,8,N,N};  
        matrix[3]=new int[]{N,9,N,N,N,4,N};  
        matrix[4]=new int[]{N,N,8,N,N,5,4};  
        matrix[5]=new int[]{N,N,N,4,5,N,6};  
        matrix[6]=new int[]{2,3,N,N,4,6,N};  
        Graph G = new Graph(vertex,matrix);
        
        G.dsj(6);
        
	}

}
class Graph{
	private char[] vertex;  //顶点数组
	private int[][] matrix;  //邻接矩阵
	private Visited_vertex vi;   //已访问的顶点集合
	public Graph(char[] vertex,int[][] matrix){
		this.vertex = vertex;
		this.matrix = matrix;
	}
	public void dsj(int index){  // 计算最短路径
		
		vi = new Visited_vertex(vertex.length,index); //初始化访问顶点集合对象
		
		update(index);
		vi.show();
		for(int j = 1;j < vertex.length;j++){
			index = vi.updateArr();
			update(index);
			vi.show();
		}
	}
	
	private void update(int index) {
		int len = 0;
		for(int j = 0;j<matrix[index].length;j++){
			len = vi.getDis(index)+matrix[index][j];
			if(!vi.in(j)&&len<vi.getDis(j)){
				vi.updatePre(j, index);
				vi.updateDis(j, len);
			}
		}
		
	}
}
class Visited_vertex{
	public int[] already_arr;
	public int[] pre_visited;
	public int[] dis;
	public Visited_vertex(int length,int index){
		this.already_arr = new int[length];
		this.pre_visited = new int[length];
		this.dis = new int[length];
		Arrays.fill(dis,65535);//设置初始化距离
		already_arr[index] = 1;//设置出发顶点已访问
		dis[index] = 0; //设置出发顶点访问距离为0
	}
	public int updateArr(){ //选择并返回新的访问顶点
		int min = 65535,index = 0;
		for(int i = 0;i < already_arr.length;i++){
			if(already_arr[i] == 0&&dis[i]<min){
				min = dis[i];
				index = i;
			}
		}
		already_arr[index] = 1;
		return index;
	}
	public boolean in(int index){  //判断index顶点是否被访问过
		return already_arr[index] == 1;
	}
	public void updateDis(int index,int len){
		dis[index] = len;
	}
	public void updatePre(int pre,int index){
		pre_visited[pre] = index;
	}
	public int getDis(int index){
		return dis[index];
	}
	public void show(){
		System.out.println("=============================");
		for(int i:already_arr){
			System.out.print(i+"  ");
		}
		System.out.println();
		for(int i:pre_visited){
			System.out.print(i+"  ");
		}
		System.out.println();
		for(int i:dis){
			if(i!=65535){
				System.out.print(i+"  ");
			}else{
				System.out.print("N  ");
			}
		}
		System.out.println();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}