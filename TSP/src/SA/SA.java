package SA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SA {
	//��ǰ�¶�
	private double currentT = 280;
	//����¶�
	private double minT = 0.01;
	//��ÿ���¶��²��ù̶�����������Lk��100n��nΪ������
	private double internalLoop = 100;
	//�¶�˥������
	private double coolingRate = 0.001;
	
	private Tour currentSolution;
	
	public void initTour(){
		Tour tour = new Tour();
		FileReader reader = null;
		try {
			//�����������
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
		//ѭ����ֱ��ϵͳ��ȴ
		while(currentT > minT){
			for(int i = 0; i < internalLoop; i++){
				newSolution = currentSolution.generateNeighbourTour();
				//�õ���ĵ�ǰ����
				int currentEnergy = currentSolution.getDistance();
				
				int neighbourEnergy = newSolution.getDistance();
				//���������Ƿ�����ڵ�
				if(acceptanceProbability(currentEnergy,neighbourEnergy,currentT) > Math.random()){
					currentSolution = new Tour(newSolution.getCitiesList());
				}
				
				//�����ҵ�����ѽ������
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
	 * @return ������ܵĸ���
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
        System.out.println("���վ���:" +besTour.getDistance());

	}

}
