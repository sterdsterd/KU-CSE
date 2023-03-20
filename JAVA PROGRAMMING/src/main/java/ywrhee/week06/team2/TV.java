package ywrhee.week06.team2;

import java.util.Scanner;

// 정명훈
public class TV extends HomeAppliance{
	private boolean power = true;
	private int channel = 0;
	private int volume = 0;
	private int choice;
	private int volume1;
	Scanner scan = new Scanner(System.in);

	public boolean isPower() {
		return power;
	}

	public int getChannel() {
		return channel;
	}

	public TV(String haName, int channel) {
		super(haName);
		this.channel = channel;
	}
	public void turnOnOff() {
		System.out.print("전원을 바꾸겟습니까?(1. true,2. false)중 하나 선택 ");

		choice = scan.nextInt();
		if(choice == 1) {
			power = !power;
		}

	}

	public void showStatus() {
		System.out.println("Tv 이름은" + haName + "\n전원 : " + power + "\n채널 : " + channel + "\n볼륨 : " +
				volume + "입니다.");
	};

	public void switchChannel() {
		System.out.print("채널번호를 입력하시오 :");
		channel = scan.nextInt();
	}

	public void switchVolume() {
		System.out.print("바꿀 볼륨을 입력하시오(0 ~ 20) :");
		volume1 = scan.nextInt();
		if(volume1 >= 0 && volume1 <= 20)
			volume = volume1;

	}
	@Override
	public void menu() {

		while(true) {
			int sw;
			System.out.println("1)전원 2)채널(전원이 켜져 있어야 함) 3)볼륨(전원이 켜져 있어야 함) 4)종료");
			System.out.print("원하는 메뉴를 선택하세요 :");
			sw = scan.nextInt();

			while(sw != 1 && sw!= 2 && sw != 3 && sw != 4) {
				System.out.print("다시 입력하십시오 :");
				sw = scan.nextInt();
			}


			if(sw == 1) {

				turnOnOff();
			}
			else if(sw == 2 && power){
				switchChannel();

			}
			else if(sw == 3 && power) {
				switchVolume();

			}
			else if(sw == 4)
				break;
			else if(power == false && sw != 1 && sw!= 2 && sw != 3 && sw != 4) {
				System.out.println("전원이 꺼져 있어 메뉴 2,3번을 실행할 수 없습니다.");
			}

			showStatus();
		}
	}

}