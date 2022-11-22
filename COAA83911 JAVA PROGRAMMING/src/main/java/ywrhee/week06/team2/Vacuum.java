package ywrhee.week06.team2;
import java.util.Scanner;

// 유재혁

public class Vacuum extends HomeAppliance implements IoTInterface {
    static Scanner scan = new Scanner(System.in);
    int menu=0;
    private int vaPower = 0;
    public Vacuum (String haName, int vaPower) {
        super(haName);

        if(vaPower<0) {
            this.vaPower = 0;
        }
        else if(vaPower>3) {
            this.vaPower = 3;
        }
        else
            this.vaPower = vaPower;
    }
    @Override
    public void showStatus() {
        String str = "전원: "+ (isHaPower() ? "켜짐" : "꺼짐") + "\n";
        str += "제품 이름: " + super.haName + "세기: " + this.vaPower;
        System.out.println(str);
    }
    @Override
    public void menu() {
        while(menu!=3){
            System.out.println("1) 전원 토글 2) 세기 조절 3)종료");
            menu = scan.nextInt();
            if(menu == 1)
                setHaPower(!isHaPower());
            else if(menu==2) {
                System.out.println("세기 (0-3)");
                setVaPower(scan.nextInt());
            }
            showStatus();
        }
    }
    public void setVaPower(int vaPower) {
        if(vaPower<0) {
            this.vaPower = 0;
        }
        else if(vaPower>3) {
            this.vaPower = 3;
        }
        else
            this.vaPower = vaPower;
    }

    @Override
    public void turnOn() {
        System.out.println(haName + "를 제어합니다.");
    }

    @Override
    public void turnOff() {
        System.out.println(haName + " 제어 종료");
    }

    @Override
    public void control() {
        menu();
    }
}