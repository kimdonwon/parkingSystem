package vehicle;

public abstract class vehicle {

	int num;
	String type;
	int[] time;
	int money;
	
	public vehicle() {
		
	};
	public vehicle(int num,String type,int[] time) {
		this.num = num;
		this.type = type;
		this.time = time;
	}
	
	public int getNum() {
		return num;
	}
	public String getType() {
		return type;
	}
	public int getMoney() {
		return money;
	}
	
	
	public int[] getTime() {
		return time;
	}
	public abstract int getFeature();
	
	
	
	
	
}
