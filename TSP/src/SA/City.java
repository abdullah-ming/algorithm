package SA;

public class City {
	
	public City(){
		
	}
	public City(float x,float y){
		this.x = x;
		this.y = y;
	}
	
//	private int num;
	private float x;
	private float y;
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	public double distanceTo(City city){
		float xDistance = Math.abs(getX() - city.getX());
		float yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
		return distance;
		
	}
	
	
	
}
