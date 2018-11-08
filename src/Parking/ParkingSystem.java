package Parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import vehicle.bus;
import vehicle.car;
import vehicle.truck;
import vehicle.vehicle;
public class ParkingSystem {
	
	
	Scanner sc = new Scanner(System.in);
	Convert cv = new Convert();
	Account ac = new Account();
	public void CheckMoney() {
		int []time= new int[3];
		System.out.println("수입을 알고 싶은 날짜를 입력하세요.");
		System.out.print(">");
		for(int i=0;i<3;i++)
			time[i]=sc.nextInt();
		int day = cv.getDay(time);
		int money = ac.getMoney(day);
		System.out.println(money+"원 입니다.");
	
		
	}
	public void Show() {
		
		Collections.sort( Main.vehicle,new Comparator<vehicle>() {
			@Override
			public int compare(vehicle o1, vehicle o2) {
				if(cv.getMinute(o1.getTime())<cv.getMinute(o2.getTime()))return -1;
				else if(cv.getMinute(o1.getTime())>cv.getMinute(o2.getTime()))return 1;
				else return 0;
			}
		});
		ArrayList<car> car = new ArrayList<car>();
		ArrayList<bus> bus = new ArrayList<bus>();
		ArrayList<truck> truck = new ArrayList<truck>();
		
		for(int i=0;i<Main.vehicle.size();i++) {
			vehicle temp = Main.vehicle.get(i);
			if(temp.getType().equals("c"))car.add((car) temp);
			else if(temp.getType().equals("b"))bus.add((bus) temp);
			else if(temp.getType().equals("t"))truck.add((truck)temp);
			
		}
		
		for(int i=0;i<car.size();i++)
			System.out.println("자동차 "+car.get(i).getNum()+" "+cv.getTimeForm(car.get(i).getTime()));
		for(int i=0;i<bus.size();i++)
			System.out.println("버스 "+bus.get(i).getNum()+" "+cv.getTimeForm(bus.get(i).getTime()));
		for(int i=0;i<truck.size();i++)
			System.out.println("트럭 "+truck.get(i).getNum()+" "+cv.getTimeForm(truck.get(i).getTime()));
		
		
	}
	
	public void Input() {
		
		String type="";
		int num=0;
		int time[]=new int[5];
		int people=0;
		
		System.out.println("차량 종류 및 용량을 입력하세요! 승용차(c), 트럭(t), 버스(b)");
		System.out.print(">");
		type=sc.next();
		if(type.equals("b") || type.equals("t")) {
			people=sc.nextInt();
		}
		else if(!type.equals("c")) {
			System.out.println("차량 종류를 정확하게 입력하세요.");
			return;
		}
		
		System.out.println("차량 번호를 입력하세요!");
		System.out.print(">");
		num=sc.nextInt();
		
		System.out.println("입차 시간을 입력하세요!");
		System.out.print(">");
		for(int i=0;i<5;i++)
		time[i]=sc.nextInt();
		
		if(type.equals("c")) {
			Main.vehicle.add(new car(num,type,time));	
		}
		else if(type.equals("b")) {
			Main.vehicle.add(new bus(num,type,people,time));
		}
		else if(type.equals("t")) {
			Main.vehicle.add(new truck(num,type,people,time));
		}
		
		
	}
	
	
	public void Output() {
		int num=0;
		int outtime[]=new int[5];
		System.out.println("차량 번호를 입력하세요!");
		System.out.print(">");
		num=sc.nextInt();
		
		System.out.println("출차 시간을 입력하세요!");
		System.out.print(">");
		for(int i=0;i<5;i++)
		outtime[i]=sc.nextInt();
		for(int i=0;i<Main.vehicle.size();i++) {
			if(Main.vehicle.get(i).getNum()==num) {
				int[] intime=Main.vehicle.get(i).getTime();
				String type=Main.vehicle.get(i).getType();
				int people = Main.vehicle.get(i).getFeature();	
				PayRole pr = new PayRole();
				int money=pr.payment(type,people,intime,outtime);
				int day=cv.getDay(outtime);
				ac.setMoney(day, money);
				Main.vehicle.remove(i);
				return;
			}
		}
		System.out.println("출차 차량 번호가 주차 차량에 없습니다.");
		
	}
	
	
	
	
	
	
}
