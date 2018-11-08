package Parking;

import java.util.HashMap;

public class Account {

	private HashMap <Integer,Integer>ht = new HashMap<Integer,Integer>();
	
	public void setMoney(int day,int money) {
		int t=0;
		
		if(ht.containsKey(day)) {
			t=ht.get(day);
			t=t+money;
			ht.put(day, t);
		}
		
		else ht.put(day, money);
	}
	public int getMoney(int day) {
		if(ht.containsKey(day)) {
			return ht.get(day);
		}
		else return 0;
	}
}
