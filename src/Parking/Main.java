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
		
		System.out.println("���� �ִ� ���� ���� �Է��ϼ���.");
		int max = sc.nextInt();
		
		while(true) {
			try {
			
			if(max<vehicle.size())break;
			int N=0;
			System.out.println("���ϴ� ����� �����ϼ���!");
			System.out.println("1. ����");
			System.out.println("2. ����");
			System.out.println("3. ������������");
			System.out.println("4. �Ϸ� ���� ���");
			System.out.println("5. ����");
			System.out.print(">");
			N=sc.nextInt();
			
			if(N==1)PS.Input();
			else if(N==2)PS.Output();
			else if(N==3)PS.Show();
			else if(N==4)PS.CheckMoney();
			else if(N==5)break;
			else {
				System.out.println("�޴� ��ȣ�� ��Ȯ�ϰ� �Է��ϼ���.");
			}
			
		}catch(Exception e) {
			System.out.println(e+"���Ŀ� �°� �Է��ϼ���.");
			sc = new Scanner(System.in);
			continue;
		}
		}
		
	}
	

}
