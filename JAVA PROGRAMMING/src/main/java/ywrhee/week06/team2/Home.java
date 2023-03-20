package ywrhee.week06.team2;

import java.util.Scanner;

// 이율원
public class Home {
    private HomeAppliance[] homeAppliances;
    private final int NUM;
    private int count;

    public static Scanner sc = new Scanner(System.in);

    public Home(int NUM) {
        this.NUM = NUM;
        homeAppliances = new HomeAppliance[this.NUM];
    }

    public void buyHA(HomeAppliance homeAppliance) {
        if (this.count < this.NUM)
            homeAppliances[count++] = homeAppliance;
        else System.out.println("더 이상 가전을 놓을 수 없습니다.");
    }

    public void open() {
        for (;;) {
            System.out.println("제어할 가전제품을 선택하세요");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ") " + homeAppliances[i].getHaName());
            }
            System.out.print("제품을 선택해 주세요 : ");
            int choice = sc.nextInt() - 1;

            System.out.println(homeAppliances[choice].getHaName() + "를 제어합니다.");
            homeAppliances[choice].menu();
        }
    }

    public IoTInterface connect() {
        System.out.println("제어할 가전제품을 선택하세요");
        for (int i = 0; i < count; i++) {
            if (homeAppliances[i] instanceof IoTInterface)
                System.out.println((i + 1) + ") " + homeAppliances[i].getHaName());
        }
        System.out.print("제품을 선택해 주세요 : ");
        int choice = sc.nextInt() - 1;

        //System.out.println(homeAppliances[choice].getHaName() + "를 제어합니다.");
        return homeAppliances[choice] instanceof IoTInterface ? (IoTInterface) homeAppliances[choice] : null;
    }
}
