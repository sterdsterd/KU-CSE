package ywrhee.week06.team2;

import java.util.Scanner;

// 문신혁

public class Refrigerator extends HomeAppliance{
	private int rifTemp=0;
	private static Scanner scanner = new Scanner(System.in);

	public Refrigerator(String haName, int Temp) {
		super(haName);
		if (Temp >=0 && Temp <= 10)
			this.rifTemp = Temp;
	}

	@Override
	public void showStatus() {
		System.out.println("---------------\n" + this.haName + "의 현재 상태");
		if (this.haPower) {
			System.out.println("제품 이름 : " + this.haName);
			System.out.println("전원 : 켜짐");
			System.out.println("온도 설정 : " + this.rifTemp);
			System.out.println("---------------\n");
		}else {
			System.out.println("제품 이름 : " + this.haName);
			System.out.println("전원 : 꺼짐");
			System.out.println("온도 설정 : " + this.rifTemp);
			System.out.println("---------------\n");
		}
	}

	@Override
	public void menu() {
		int sel;

		while (true) {
			System.out.println("(1)전원  (2)온도  (3)종료");
			System.out.print("원하는 메뉴를 선택하세요 : ");
			sel = scanner.nextInt();

			if (sel == 1) {
				if(this.haPower) {
					this.haPower = !this.haPower;
					System.out.println("전원을 껐습니다.");
					System.out.println();
				}else {
					this.haPower = !this.haPower;
					System.out.println("전원을 켰습니다.");
					System.out.println();
				}
			}else if (sel == 2) {
				if (this.haPower ) {
					System.out.print("설정할 온도를 입력해주세요(0~10) : ");
					sel = scanner.nextInt();
					if (sel >= 0 && sel <= 10) {
						this.rifTemp = sel;
						System.out.println("온도를 " + this.rifTemp + "로 설정하였습니다.");
						System.out.println();
					}else {
						System.out.println("잘못된 입력입니다. 처음부터 진행해주세요.");
						System.out.println();
					}
				}else {
					System.out.println("전원이 꺼져있습니다.");
					System.out.println();
				}
			}else if (sel == 3) {
				break;
			}else
				System.out.println("잘못된 입력입니다. 처음부터 진해주세요.");
			showStatus();
		}

	}


}
