package vehicle;

public class bus extends vehicle{
	int people;
	public bus(){
		
	}
	public bus(int num,String type,int people,int[] time){
		super(num,type,time);
		this.people=people;
	}
	
	public int getFeature() {
		return people;
	}
	
}
