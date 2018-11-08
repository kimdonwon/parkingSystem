package Parking;

public class Convert {
	
public int getMinute(int[] time) {
		
		int t=time[4];
		t=t+time[3]*60;
		t=t+time[2]*60*24;
		t=t+time[1]*60*24*30;
		t=t+time[0]*60*24*30*365;
		return t;
	}

public int getDay(int[] time) {
	int t=0;
	t=t+time[2]*60*24;
	t=t+time[1]*60*24*30;
	t=t+time[0]*60*24*30*365;
	return t;
}

public String getTimeForm(int [] time) {
	String s[]=new String[5];
	String tf="";
	for(int i=0;i<5;i++) {
		s[i]=""+time[i];
		if(s[i].length()==1)s[i]="0"+s[i];
	}
	tf=s[0]+"/"+s[1]+"/"+s[2]+" "+s[3]+":"+s[4];
	
	
	return tf;
}


}
