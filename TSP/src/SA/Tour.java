package SA;

import java.util.ArrayList;
import java.util.Collections;

public class Tour {
	
	
	
	public Tour() {
		
		this.citiesList =new ArrayList<City>();
		
	}
	
	public Tour(ArrayList<City> tour){
		citiesList = new ArrayList<City>();
        for (City city : tour) {
            this.citiesList.add(city);
        }
	}
	
	
	private ArrayList<City> citiesList;
	private int distance = 0;
	
	public ArrayList<City> getCitiesList(){
        return citiesList;
    }
	
	
    public City getCity(int tourPosition) {
        return (City)citiesList.get(tourPosition);
    }
   
    
    //将城市设置在城市列表中的某个位置
    public void setCity(int tourPosition, City city) {
        citiesList.set(tourPosition, city);
        
        distance = 0;
        
    }
	
	public Tour addCity(City city) {
        citiesList.add(city);
        return this;
    }
	
	public Tour generateIndividual() {
        // 循环遍历所有的目的地城市，并将它们添加到城市列表中
        for (int cityIndex = 0; cityIndex < citiesList.size(); cityIndex++) {
          setCity(cityIndex, this.getCity(cityIndex));
        }

        return this;
    }
	//随机产生邻接城市
	public Tour generateNeighbourTour(){
		Tour newSolution = new Tour(this.citiesList);
		
		int tourPos1 = (int) (newSolution.numberOfCities() * Math
                .random());
        int tourPos2 = (int) (newSolution.numberOfCities() * Math
                .random());
        // 获取选定位置的城市
        City citySwap1 = newSolution.getCity(tourPos1);
        City citySwap2 = newSolution.getCity(tourPos2);
        
        newSolution.setCity(tourPos2, citySwap1);
        newSolution.setCity(tourPos1, citySwap2);
        return newSolution;
	}
	
	public int numberOfCities() {
        return citiesList.size();
    }
	
	
	//获取城市列表的总距离
	public int getDistance(){
		if(distance == 0){
			int tourDistance = 0;
			for(int cityIndex = 0; cityIndex < numberOfCities();cityIndex++){
				
				City fromCity = getCity(cityIndex);
				
				City destinationCity;
				
				if(cityIndex + 1 < numberOfCities()){
					destinationCity = getCity(cityIndex + 1);
				}
				else{
					destinationCity = getCity(0);
				}
				
				tourDistance += fromCity.distanceTo(destinationCity);
			}
			distance = tourDistance;
		}
		return distance;
	}

}
