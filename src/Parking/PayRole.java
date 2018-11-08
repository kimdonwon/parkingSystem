package Parking;

public class PayRole {
	public int[] getRole(String type,int people) {
		int role[]=new int [4];
		int paymoney=0;//�� ������ �ݾ�
		int paytime=0;//�� ������ �ð�
		int firsttime=0;//�� ������ �⺻�ð�
		int firstmoney=0;//�� ������ �⺻ �ݾ�
		if(type.equals("c")) {
			paymoney=500;
			paytime=10;
			firsttime=30;
			firstmoney=1000;
		}
		else if(type.equals("b")) {
			if(people>=40) {
				paymoney=2000;
				paytime=30;
				firsttime=60;
				firstmoney=4000;
			}
			else if(people>=24) {
				paymoney=1500;
				paytime=30;
				firsttime=60;
				firstmoney=3000;
			}
			else {
				paymoney=1000;
				paytime=30;
				firsttime=60;
				firstmoney=2000;
			}
		}
		else if(type.equals("t")) {
			if(people>=10) {
				paymoney=4000;
				paytime=60;
				firsttime=60;
				firstmoney=4000;
			}
			else if(people>=5) {
				paymoney=3000;
				paytime=60;
				firsttime=60;
				firstmoney=3000;
			}
			else {
				paymoney=2000;
				paytime=60;
				firsttime=60;
				firstmoney=2000;
			}
			
		}
		role[0]=paymoney;
		role[1]=paytime;
		role[2]=firsttime;
		role[3]=firstmoney;
		
		return role;
		
		
	}
	
	public int payment(String type,int people,int[] time,int[] outTime) {
		int money=0;
		Convert tm = new Convert();
		int [] role = getRole(type,people);
		
		
		int paymoney=role[0];
		int paytime=role[1];
		int firsttime=role[2];
		int firstmoney=role[3];
		
		
		for(int i=0;i<5;i++) {
			if(time[i]<outTime[i])break;
			if(time[i]>outTime[i]) {
				System.out.println("���� �ð��� �� �� �Ǿ����ϴ�.");
				return money; 
			}
		}
		int input = tm.getMinute(time);
		int output= tm.getMinute(outTime);
		if(output-input>=30*24*60) {
			System.out.println("�����ð��� 30�� ���� Ů�ϴ�.");
			return money;
		}
		if(output-input<firsttime) {
			money=firstmoney;
			System.out.println("���� �ð��� " + firsttime + "�� �Դϴ�.");
			System.out.println("���� ����� "+firstmoney+"��");
			return money;
		}
		money=(((output-input)-(firsttime))/(paytime)+1)*paymoney+firstmoney;
		
		int hour=(((output-input)/paytime+1)*paytime)/60;
		int minute=(((output-input)/paytime+1)*paytime)%60;
		
		System.out.println("���� �ð��� "+hour+"�ð�"+minute+"�� �Դϴ�.");
		System.out.println("���� ����� "+money+"��");
		return money;
		
	}
	
	
}
