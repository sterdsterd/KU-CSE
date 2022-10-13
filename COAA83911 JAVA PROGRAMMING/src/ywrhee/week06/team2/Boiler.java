package ywrhee.week06.team2;

import java.util.Scanner;

// 이율원
public class Boiler extends HomeAppliance implements IoTInterface {

    private int temperature;
    private boolean isAway = false;
    private int hotWaterMode = 0;

    public static Scanner sc = new Scanner(System.in);

    public Boiler(String haName, int temperature) {
        super(haName);
        if (temperature < 20) this.temperature = 20;
        else if (temperature > 40) this.temperature = 40;
        else this.temperature = temperature;
    }

    @Override
    public void menu() {
        for (;;) {
            System.out.println("1) 전원 토글  2) 온도 조절  3) 외출 모드 토글  4) 온수 조절 5) 종료");
            System.out.print("메뉴를 선택하세요 : ");
            int choice = sc.nextInt();

            if (choice == 1) setHaPower(!isHaPower());
            else if (choice == 2) {
                System.out.println("온도 (20도 - 40도) : ");
                setTemperature(sc.nextInt());
            } else if (choice == 3) {
                isAway = !isAway;
            } else if (choice == 4) {
                switchHotWaterMode();
            } else if (choice == 5) {
                return;
            } else {
                System.out.println("유효하지 않은 메뉴입니다.");
            }
            showStatus();
        }
    }

    @Override
    public void showStatus() {
        String str = "전원 : " + (isHaPower() ? "켜짐" : "꺼짐") + "\n";
        str += "온도 : " + temperature + "\n";
        str += "외출모드 : " + (isAway ? "켜짐" : "꺼짐") + "\n";
        str += "온수모드 : ";

        if (hotWaterMode == 0) str += "꺼짐";
        else if (hotWaterMode == 1) str += "저";
        else if (hotWaterMode == 2) str += "중";
        else if (hotWaterMode == 3) str += "고";

        System.out.println(str);
    }

    public boolean isAway() {
        return isAway;
    }

    public int getHotWaterMode() {
        return hotWaterMode;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        if (temperature < 20) this.temperature = 20;
        else if (temperature > 40) this.temperature = 40;
        else this.temperature = temperature;
    }

    public void switchHotWaterMode() {
        hotWaterMode++;
        if (hotWaterMode > 3) hotWaterMode = 0;
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
