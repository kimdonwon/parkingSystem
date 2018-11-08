package Parking;

import java.util.ArrayList;
import java.util.Scanner;

import vehicle.vehicle;

public class Main {
	static ArrayList<vehicle> vehicle = new ArrayList<vehicle>(); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ParkingSystem PS = new ParkingSystem();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("주차 최대 차량 수를 입력하세요.");
		int max = sc.nextInt();
		
		while(true) {
			try {
			
			if(max<vehicle.size())break;
			int N=0;
			System.out.println("원하는 기능을 선택하세요!");
			System.out.println("1. 입차");
			System.out.println("2. 출차");
			System.out.println("3. 주차차량보기");
			System.out.println("4. 하루 수입 계산");
			System.out.println("5. 종료");
			System.out.print(">");
			N=sc.nextInt();
			
			if(N==1)PS.Input();
			else if(N==2)PS.Output();
			else if(N==3)PS.Show();
			else if(N==4)PS.CheckMoney();
			else if(N==5)break;
			else {
				System.out.println("메뉴 번호를 정확하게 입력하세요.");
			}
			
		}catch(Exception e) {
			System.out.println(e+"형식에 맞게 입력하세요.");
			sc = new Scanner(System.in);
			continue;
		}
		}
		
	}
	

}
