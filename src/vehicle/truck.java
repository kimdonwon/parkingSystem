package vehicle;

public class truck extends vehicle{
	int T;
	public truck(){
		
	}
	public truck(int num,String type,int T,int[] time){
		super(num,type,time);
		this.T=T;
	}
	public int getFeature() {
		return T;
	}
	
	
}
