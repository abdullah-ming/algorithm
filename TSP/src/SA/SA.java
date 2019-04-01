package SA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SA {
	//当前温度
	private double currentT = 280;
	//最低温度
	private double minT = 0.01;
	//在每个温度下采用固定迭代次数，Lk＝100n，n为城市数
	private double internalLoop = 100;
	//温度衰减速率
	private double coolingRate = 0.001;
	
	private Tour currentSolution;
	
	public void initTour(){
		Tour tour = new Tour();
		FileReader reader = null;
		try {
			//读入城市坐标
			reader = new FileReader("input.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(reader);
		String str;
		String[] str1 = new String[3];
		try {
			while((str = br.readLine()) != null){
				String[] strArray =str.split(" ");
				float xDistance = Float.parseFloat(strArray[1]);
				float yDistance = Float.parseFloat(strArray[2]);
				tour.addCity(new City(xDistance,yDistance));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		currentSolution = tour.generateIndividual();
	}

	public Tour anneal(){
		Tour bestSolution = new Tour(currentSolution.getCitiesList());
		Tour newSolution = null;
		//循环，直到系统冷却
		while(currentT > minT){
			for(int i = 0; i < internalLoop; i++){
				newSolution = currentSolution.generateNeighbourTour();
				//得到解的当前能量
				int currentEnergy = currentSolution.getDistance();
				
				int neighbourEnergy = newSolution.getDistance();
				//决定我们是否接受邻点
				if(acceptanceProbability(currentEnergy,neighbourEnergy,currentT) > Math.random()){
					currentSolution = new Tour(newSolution.getCitiesList());
				}
				
				//跟踪找到的最佳解决方案
				if (currentSolution.getDistance() < bestSolution.getDistance()) {
                    bestSolution = new Tour(currentSolution.getCitiesList());
                }
				
			}
			
			currentT *= 1-coolingRate;
			
		}
		return bestSolution;
	}
	/**
	 * 
	 * @param energy
	 * @param newEnergy
	 * @param temperature
	 * @return 计算接受的概率
	 */
	
	private double acceptanceProbability(int energy,int newEnergy,double temperature) {
		
		if(newEnergy < energy){
			return 1.0;
		}

		return Math.exp((energy - newEnergy) / temperature);
	}
	public static void main(String[] args) {
		SA sa=new SA();
        sa.initTour();
        Tour besTour = sa.anneal();
        System.out.println("最终距离:" +besTour.getDistance());

	}

}
